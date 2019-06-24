
package com.memorynotfound.xml.jdom;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

	public class ReadXmlJDomAddinn{

	    public static void main(String... args) throws JDOMException, IOException{

	    	
	    	// read file from classpath
	    	 InputStream in = ReadXmlJDom.class.getResourceAsStream("/essai.xml");

	    	// create builder
	    	 SAXBuilder builder = new SAXBuilder();
	         Document document = builder.build(in);
	         //getting root element from xml doc
			Element root = document.getRootElement();
			System.out.println("Root element on xml document is: "
					+root.getName());
			List DonneesVin = root.getChildren();
			//iterating over all childs in xml
			Iterator itr = (Iterator)DonneesVin.iterator();
			while (itr.hasNext()) {
				Element VIN = (Element) itr.next();
				//reading value of children in xml
				System.out.println("WMI : " + VIN.getChildText("WMI"));
				System.out.println("VDS : " + VIN.getChildText("VDS"));
				System.out.println("VDS : " + VIN.getChildText("AMENI"));
				System.out.println("VIS : " + VIN.getChildText("VIS"));
				Element RetourExecution = (Element) itr.next();
				System.out.println("Code : " + RetourExecution.getChildText("Code"));
				System.out.println("Message : " + RetourExecution.getChildText("Message"));
			}
			
		}

	}

