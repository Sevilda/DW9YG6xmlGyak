package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {

	private StringBuilder data = null;

	int nameElement, ageElement, breedElement, catElement;
	String nameElementSt, ageElementSt, breedElementSt;

	@Override
	public void startElement(String uri, String localname, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("cats")) {
			System.out.println("cats start");
		}
		if (qName.equalsIgnoreCase("cat")) {
			String id = attributes.getValue("id");
			System.out.println("\tcat start, id {" + id + "}");
			catElement = 1;
		}
		if (qName.compareTo("name") == 0) {
			System.out.println("\t\tname start");
			nameElement = 1;
		}
		if (qName.compareTo("age") == 0) {
			ageElement = 1;
			System.out.println("\t\tage start");

		}
		if (qName.compareTo("breed") == 0) {
			System.out.println("\t\tbreed start");
			breedElement = 1;
		}
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localname, String qName) throws SAXException {
		if (qName.compareTo("name") == 0) {
			System.out.println("\t\t\t" + data.toString() + "\n\t\tname end");
			nameElement = 0;
		}
		if (qName.compareTo("age") == 0) {
			System.out.println("\t\t\t" + data.toString() + "\n\t\tage end");
			ageElement = 0;
		}
		if (qName.compareTo("breed") == 0) {
			System.out.println("\t\t\t" + data.toString() + "\n\t\tbreed end");
			breedElement = 0;
		}
		if (qName.compareTo("cats") ==0 ) {
			System.out.println("cats end");
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}
