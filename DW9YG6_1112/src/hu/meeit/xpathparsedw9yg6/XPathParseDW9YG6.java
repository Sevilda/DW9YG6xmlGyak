package hu.meeit.xpathparsedw9yg6;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XPathParseDW9YG6 {
	public static void main(String[] args) {

		try {

			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			File file = new File("studentDW9YG6.xml");
			Document document = documentBuilder.parse(file);

			document.getDocumentElement().normalize();
			Element rootElement = document.getDocumentElement();

			System.out.println(rootElement.getNodeName() + ": ");

			NodeList nodeList = (NodeList) xPath.compile("/class/student").evaluate(document, XPathConstants.NODESET);

			XPathExpression expr = xPath.compile("/class/student");
			NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				System.out.println("Current element: " + nodes.item(i).getNodeName());
				// attribute
				expr = xPath.compile("/class/student/@rollno");
				String attribute = (String) expr.evaluate(document, XPathConstants.STRING);
				System.out.println("\tStudent Roll Number: " + attribute);
				// first name
				expr = xPath.compile("/class/student/firstname");
				NodeList firstNameNodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
				System.out.println("\tFirst Name: " + firstNameNodes.item(i).getTextContent());
				// last name
				expr = xPath.compile("/class/student/lastname");
				NodeList lastNameNodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
				System.out.println("\tLast Name: " + lastNameNodes.item(i).getTextContent());
				// nickname
				expr = xPath.compile("/class/student/nickname");
				NodeList nickNameNodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
				System.out.println("\tNickname: " + nickNameNodes.item(i).getTextContent());
				// Marks
				expr = xPath.compile("/class/student/marks");
				NodeList markNodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
				System.out.println("\tMarks: " + markNodes.item(i).getTextContent());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
