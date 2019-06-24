package com.memorynotfound.xml.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ReadXmlJDom {

    public static void main(String... args) throws JDOMException, IOException {

        // read file from classpath
        InputStream in = ReadXmlJDom.class.getResourceAsStream("/example.xml");

        // create builder
        SAXBuilder builder = new SAXBuilder();

        // parse and load file into memory
        Document document = builder.build(in);

        // getting the root element
        Element root = document.getRootElement();
        System.out.println("Root: " + root.getName());
        System.out.println("- - - - - - - - - - - - - - - - - - -");

        // iterating over the children
        List<Element> courses = root.getChildren("course");
        for (Element element : courses){
            System.out.println("\nElement: " + element.getName());
            System.out.println("ID: " + element.getAttributeValue("id"));
            System.out.println("Name: " + element.getChildText("name").trim());
            System.out.println("Price: " + element.getChildText("price"));
        }
    }
}
