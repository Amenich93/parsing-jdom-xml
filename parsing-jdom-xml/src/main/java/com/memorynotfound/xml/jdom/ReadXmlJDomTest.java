
package com.memorynotfound.xml.jdom;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXmlJDomTest {

  public static void main(String argv[]) {

    try {

	File fXmlFile = new File("/Users/Ameni/Desktop/projet java/read-xml-java-jdom-parser-example/read-xml/src/main/resources/essaiTest.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
	NodeList nList = doc.getElementsByTagName("DonneesVin");

	System.out.println("La racine est " + doc.getDocumentElement().getNodeName() + " contient " + nList.getLength() + " elements.");
			
	System.out.println("------------------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
		
				
		System.out.println("\n" + nNode.getNodeName() + " numéro: "+ (temp + 1));
		
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			
			if (eElement.getElementsByTagName("VIN").item(0).getNodeName() == "VIN") {
				NodeList vinNode = eElement.getElementsByTagName("VIN").item(0).getChildNodes();
				System.out.println( eElement.getElementsByTagName("VIN").item(0).getNodeName() );
				for (int i = 0; i < vinNode.getLength(); i++) {
					Node ChildNode = vinNode.item(i);
					if (ChildNode.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println( "   " + ChildNode.getNodeName() + " : " + ChildNode.getTextContent() );
					}
				}
			}
			
			if (eElement.getElementsByTagName("RetourExecution").item(0).getNodeName() == "RetourExecution") {
				NodeList vinNode = eElement.getElementsByTagName("RetourExecution").item(0).getChildNodes();
				System.out.println( eElement.getElementsByTagName("RetourExecution").item(0).getNodeName() );
				for (int i = 0; i < vinNode.getLength(); i++) {
					Node ChildNode = vinNode.item(i);
					if (ChildNode.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("   " + ChildNode.getNodeName() + " : " + ChildNode.getTextContent() );
					}
				}
			}

			if (eElement.getElementsByTagName("DonneesNreTvv").item(0).getNodeName() == "DonneesNreTvv") {
				NodeList vinNode = eElement.getElementsByTagName("DonneesNreTvv").item(0).getChildNodes();
				System.out.println( eElement.getElementsByTagName("DonneesNreTvv").item(0).getNodeName() );
				for (int i = 0; i < vinNode.getLength(); i++) {
					Node ChildNode = vinNode.item(i);
					if (ChildNode.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("   " + ChildNode.getNodeName() + " : " + ChildNode.getTextContent() );
					}
				}
			}
			if (eElement.getElementsByTagName("DonneesTechniquesFiliales").item(0).getNodeName() == "DonneesTechniquesFiliales") {
				NodeList vinNode = eElement.getElementsByTagName("DonneesTechniquesFiliales").item(0).getChildNodes();
				System.out.println( eElement.getElementsByTagName("DonneesTechniquesFiliales").item(0).getNodeName() );
				for (int i = 0; i < vinNode.getLength(); i++) {
					Node ChildNode = vinNode.item(i);
					if (ChildNode.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("   " + ChildNode.getNodeName() + " : " + ChildNode.getTextContent() );
					}
				}
			}
			
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}
