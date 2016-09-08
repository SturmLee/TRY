package com.stone.xmltest;

import org.xml.sax.SAXException;

import org.w3c.dom.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static javax.swing.text.html.CSS.getAttribute;

/**
 * Created by stonegroup on 2016/9/4.
 */
public class XmlDemo {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {


        //create a documnetBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //create a document from a file or a stream

        StringBuilder xmlStringBuilder = new StringBuilder();
        xmlStringBuilder.append("<?xml version = \"1.0\"?> <class></class>");
        ByteArrayInputStream input = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("utf-8"));
        Document document =  builder.parse(input);

        //Extract the root element
        Element root = document.getDocumentElement();

        //Examine attributes
        //return sepcific attribute
        getAttribute("attributeName");
        //return a Map (table) of names/values






    }
}
