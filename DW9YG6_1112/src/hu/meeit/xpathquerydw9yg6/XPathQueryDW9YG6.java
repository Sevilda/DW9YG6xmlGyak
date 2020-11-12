package hu.meeit.xpathquerydw9yg6;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class XPathQueryDW9YG6 {
	public static void main(String[] args)
	{
		try {

			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			File file = new File("studentDW9YG6.xml");
			Document document = documentBuilder.parse(file);

			document.getDocumentElement().normalize();

			System.out.println("Query:");

			XPathExpression expr;

			// attribute
			expr = xPath.compile("/class/student[@rollno='593']/@rollno");
			String attribute = (String) expr.evaluate(document, XPathConstants.STRING);
			System.out.println("\tStudent Roll Number: " + attribute);
			// first name
			expr = xPath.compile("/class/student[@rollno='593']/firstname");
			String firstName = (String) expr.evaluate(document, XPathConstants.STRING);
			System.out.println("\tFirst Name: " + firstName);
			// last name
			expr = xPath.compile("/class/student[@rollno='593']/lastname");
			String lastName = (String) expr.evaluate(document, XPathConstants.STRING);
			System.out.println("\tLast Name: " + lastName);
			// nickname
			expr = xPath.compile("/class/student[@rollno='593']/nickname");
			String nickName = (String) expr.evaluate(document, XPathConstants.STRING);
			System.out.println("\tNickname: " + nickName);
			// Marks
			expr = xPath.compile("/class/student[@rollno='593']/marks");
			String mark = (String) expr.evaluate(document, XPathConstants.STRING);
			System.out.println("\tMarks: " + mark);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
