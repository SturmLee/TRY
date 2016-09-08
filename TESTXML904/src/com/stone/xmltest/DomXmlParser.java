package com.stone.xmltest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by stonegroup on 2016/9/7.
 */
public class DomXmlParser {
    public static void main(String[] args) {
        try {
            File file = new File("E:\\JavaFiles\\in.xml");

            System.out.println("文件是否存在："+file.exists());

            DocumentBuilderFactory documentBuilderFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            String rootNode = document.getDocumentElement().getNodeName();
            NodeList rootNList= document.getDocumentElement().getChildNodes();
            System.out.println(rootNode);
            getChild(rootNList);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void getChild(NodeList nodeList){
        for (int i = 0 ; i < nodeList.getLength();i++){
            System.out.println("0000000000000000");
            Node node = nodeList.item(i);
            System.out.println("节点类型："+node.getNodeType());
            System.out.println("节点名字："+node.getNodeName());
            System.out.println("节点属性：");
            if (node.getNodeType()==Node.TEXT_NODE)
                System.out.println("节点内容："+node.getTextContent());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("111111111111111111111");
                    System.out.println("该节点为元素Element:"+Node.ELEMENT_NODE);

                    Element element = (Element) node;
                    System.out.println("节点属性："+node.getAttributes().getNamedItem(node.getNodeName()));
                    System.out.println("是否存在子节点:"+element.hasChildNodes());
                    if (node.hasChildNodes()){
                        NodeList nnList = node.getChildNodes();
                        System.out.println("子节点个数:"+nnList.getLength());
                       if (nnList.getLength()<2){
                           System.out.println(node.getNodeName()+":\t"+node.getTextContent());
                       }else {
                           System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");
                           getChild(nnList);
                           System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXX");

                       }
               }

                }



        }



    }



}
