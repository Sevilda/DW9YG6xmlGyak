package domdw9yg6;

import java.io.File;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomDW9YG6 {

	public static void main(String[] args) {
		try {
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		File file = new File("szemelyek.xml");
		Document doc=documentBuilder.parse(file);
		
		
		doc.getDocumentElement().normalize();
		Element rootElement = doc.getDocumentElement();
		
		System.out.println("Gyoker elem: " + rootElement.getNodeName());
		
		NodeList nodeList = rootElement.getChildNodes();
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode=nodeList.item(i);
			if (currentNode.getNodeType()==Node.ELEMENT_NODE ) {
				Element currentElement= (Element)currentNode;
				
				String id = currentElement.getAttribute("id");
				System.out.println("id: " + id );
				
				String name=currentElement.getElementsByTagName("nev").item(0).getTextContent();
				System.out.println("\tNev: "+name );
				
				if ((currentElement.getElementsByTagName("kor").item(0))!=null) {
				String age=currentElement.getElementsByTagName("kor").item(0).getTextContent();
				System.out.println("\tKor: " + age);
				}
				else currentElement.getNextSibling();
				
				String city=currentElement.getElementsByTagName("varos").item(0).getTextContent();
				System.out.println("\tVaros: " + city);
				
				}
			}
		
		} catch (Exception E) {
			E.printStackTrace();
		}

	}

}
