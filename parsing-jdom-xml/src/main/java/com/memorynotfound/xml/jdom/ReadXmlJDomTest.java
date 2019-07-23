package com.memorynotfound.xml.jdom;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import entities1.Product;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
public class ReadXmlJDomTest {
	
static String MasseOrdmaMin,MasseOrdmaAffine,MasseOrdmaEssi1Min,MasseOrdmaEssi1Affine,MasseOrdmaEssi2Min,MasseOrdmaEssi2Affine,Co2UrbCarb1,Co2ExurbCarb1;

	
  public static void main(String argv[]) {
		
    try {
    File fXmlFile = new File("src\\main\\resources\\essaiTest.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);		
	doc.getDocumentElement().normalize();
	
	System.out.println("La racine est " + doc.getDocumentElement().getNodeName());
	
	System.out.println("------------------------------------");
	
	//Entete
	NodeList nListEntete = doc.getElementsByTagName("Entete");
	
	System.out.println("La balise est " + nListEntete.item(0).getNodeName() );
	
	System.out.println("------------------------------------");
	
	for (int temp = 0; temp < nListEntete.getLength(); temp++) {
		Node nNodeEntete = nListEntete.item(temp);
		
		Element eElementEntete = (Element) nNodeEntete;
		
		NodeList vinNodeEntete = eElementEntete.getElementsByTagName("ServiceSortant").item(0).getChildNodes();
		System.out.println( eElementEntete.getElementsByTagName("ServiceSortant").item(0).getNodeName() );
		for (int i = 0; i < vinNodeEntete.getLength(); i++) {
			Node ChildNode = vinNodeEntete.item(i);
			if (ChildNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println( "   " + ChildNode.getNodeName() + " : " + ChildNode.getTextContent() );
			}
		}
	
	}
	
	//Configuration
		/*NodeList nListConfiguration = doc.getElementsByTagName("Configuration");
		System.out.println("La balise est " + nListConfiguration.item(0).getNodeName() + " contient " + nListConfiguration.getLength() +" elements.");
		
		System.out.println("------------------------------------");
		
		for (int temp = 0; temp < nListConfiguration.getLength(); temp++) {
			Node nNodeConfig = nListConfiguration.item(temp);
			
			Element eElementConfig = (Element) nNodeConfig;
			
			if (nNodeConfig.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println( "   " + nNodeConfig.getNodeName() + " : " + nNodeConfig.getTextContent() );
			}
		
		}*/
	
	//DonneesVin
NodeList nList = doc.getElementsByTagName("DonneesVin");

	System.out.println("La balise est " + nList.item(0).getNodeName() + " contient " + nList.getLength() + " elements.");
			
	System.out.println("------------------------------------");
	

	List<Product> listProducts = new ArrayList<Product>();

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
						
						
							if(ChildNode.getNodeName() == "MasseOrdmaMin") {
								MasseOrdmaMin = ChildNode.getTextContent();
							
								
							}
							if(ChildNode.getNodeName() == "MasseOrdmaAffine") {
								MasseOrdmaAffine = ChildNode.getTextContent();
								
							}
							if(ChildNode.getNodeName() == "MasseOrdmaEssi1Min") {
								MasseOrdmaEssi1Min = ChildNode.getTextContent();
								
							}
							if(ChildNode.getNodeName() == "MasseOrdmaEssi1Affine") {
								MasseOrdmaEssi1Affine =  ChildNode.getTextContent();
								
							}
							if(ChildNode.getNodeName() == "MasseOrdmaEssi2Min") {
								MasseOrdmaEssi2Min = ChildNode.getTextContent();
								
							}
							if(ChildNode.getNodeName() == "MasseOrdmaEssi2Affine") {
								MasseOrdmaEssi2Affine = ChildNode.getTextContent();
							
								 
							}
							if(ChildNode.getNodeName() == "Co2UrbCarb1") {
								Co2UrbCarb1 = ChildNode.getTextContent();
								
							}
							if(ChildNode.getNodeName() == "Co2ExurbCarb1") {
								
								Co2ExurbCarb1 = ChildNode.getTextContent();
							}
							
						
							
					}
					
				}
				
				
			
				
				listProducts.add(new Product(MasseOrdmaMin.toString(),MasseOrdmaAffine.toString(),MasseOrdmaEssi1Min,MasseOrdmaEssi1Affine,MasseOrdmaEssi2Min,MasseOrdmaEssi2Affine,Co2UrbCarb1,Co2ExurbCarb1));
				//listProducts.add(new Product("1055","1112", "641", "2", "78", "414", "5545", "400"));
			}
						
		}
	}
	
	
	/************** create csv **************/
	String COMMA_DELIMITER = ";";
	String NEW_LINE_SEPARATOR = "\n";
	String FILE_HEADER = "MasseOrdmaMin;MasseOrdmaAffine;MasseOrdmaEssi1Min;MasseOrdmaEssi1Affine;MasseOrdmaEssi2Min;MasseOrdmaEssi2Affine;Co2UrbCarb1;Co2ExurbCarb1;";
	try {

	FileWriter fileWriter = new FileWriter("src\\main\\java\\data1\\listProducts.csv"); 
	fileWriter.append(FILE_HEADER);
	
	for(Product p : listProducts) { 
		fileWriter.append(NEW_LINE_SEPARATOR);
		fileWriter.append(String.valueOf(p.getMasseOrdmaMin()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(p.getMasseOrdmaAffine()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(p.getMasseOrdmaEssi1Min()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(p.getMasseOrdmaEssi1Affin()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(p.getMasseOrdmaEssi2Min()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(p.getMasseOrdmaEssi2Affine()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(p.getCo2UrbCarb1()));
		fileWriter.append(COMMA_DELIMITER);
		fileWriter.append(String.valueOf(p.getCo2ExurbCarb1()));
		
	}
	fileWriter.flush();
	fileWriter.close();
	System.out.println("Done");
	
    } catch (Exception e) {
	  System.out.println(e.getMessage());
    }

	
	} catch (Exception e) {
		e.printStackTrace();
	}

  }

}




