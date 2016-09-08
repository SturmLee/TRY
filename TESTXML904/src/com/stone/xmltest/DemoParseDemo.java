package com.stone.xmltest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by stonegroup on 2016/9/4.
 */
public class DemoParseDemo {
    public static void main(String[] args) {
        try {
            File inputFile = new File("E:\\JavaFiles\\input.txt");


            System.out.println(inputFile.exists());

            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            String nodeName = doc.getDocumentElement().getNodeName();
            System.out.println("Root element:"
            + nodeName);

//            NodeList nList = doc.getElementsByTagName("student");
            NodeList nList = doc.getDocumentElement().getChildNodes();

            System.out.println(nList.getLength());
            System.out.println(nList);

            System.out.println("----------------");
            for (int i = 0 ; i < nList.getLength() ; i++){

                System.out.println("%%%%%%%%%%%%%%%%%%%"+i);
                Node nnNode = nList.item(i);
                NodeList sNodeList = nnNode.getChildNodes();
                System.out.println("~~~~name~~~~"+nnNode.getNodeName());
                System.out.println("~~~~content~~~~"+nnNode.getTextContent());

                System.out.println("~~~~contentNext~~~~"+nnNode.getNextSibling());


                System.out.println("~~~~childnodes~~~~"+nnNode.getChildNodes());
                System.out.println("~~~~attr~~~~"+nnNode.getAttributes());
                System.out.println("~~~~nodetype~~~~"+nnNode.getNodeType());

                System.out.println("~~~~node~~~~"+nnNode);

//                Element eelM = (Element) nnNode;
//                System.out.println(eelM.getNodeName());
                for (int j = 0 ; j < sNodeList.getLength(); j++){
                    Node sNode = sNodeList.item(j);
                    if (sNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) sNode;
                        System.out.println("__________");
                        System.out.println(sNode);
                        System.out.println(element.hasChildNodes());
                        System.out.println(element.getChildNodes());
                        System.out.println("子标签检测"+sNode.getTextContent());
                        System.out.println(sNode.getNodeName() + "\t" + sNode.getTextContent());
                        System.out.println("^^^^^^^^^^^");
                        System.out.println();

                    }
//                    else
//                        System.out.println(sNode.getNodeName()+"!!!");



                }

            }

            System.out.println("-------------------");
//            for (int temp = 0 ; temp < nList.getLength() ; temp++){
//                Node nNode = nList.item(temp);
//                System.out.println("\nCurrent Element :"
//                + nNode.getNodeName());
//                if (nNode.getNodeType() == Node.ELEMENT_NODE){
//                    Element eElement = (Element) nNode;
//                    System.out.println("Student roll no : "
//                        + eElement.getAttribute("rollno"));
//                    System.out.println("First Name :" +
//                        eElement.getElementsByTagName("firstname").item(0)
//                        .getTextContent());
//                    System.out.println("Last Name : " +
//                      eElement.getElementsByTagName("lastname")
//                        .item(0)
//                        .getTextContent());
//                    System.out.println("Nick Name : " +
//                        eElement
//                        .getElementsByTagName("nickname")
//                        .item(0)
//                        .getTextContent());
//                    System.out.println("Marks : " +
//                        eElement.getElementsByTagName("marks")
//                        .item(0)
//                        .getTextContent());
//                }
//            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
