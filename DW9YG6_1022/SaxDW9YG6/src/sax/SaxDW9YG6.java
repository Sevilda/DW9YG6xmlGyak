package sax;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;



public class SaxDW9YG6 {
	
	int nameElement, ageElement, breedElement;
	String nameElementSt, ageElementSt, breedElementSt; 

	public static void main(String[] args) throws ParserConfigurationException {
	try {
			         File inputFile = new File("/home/sev/Documents/XML/public/git/DW9YG6_1022/cats.xml");
			         SAXParserFactory factory = SAXParserFactory.newInstance();
			         SAXParser saxParser = factory.newSAXParser();
			         SaxHandler userhandler = new SaxHandler();
			         saxParser.parse(inputFile, userhandler);     

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();		
	}
	}
	
	
	public SaxDW9YG6() {}
}
