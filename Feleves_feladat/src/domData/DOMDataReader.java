package domData;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMDataReader {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			File file = new File("hospital.xml");
			Document doc = documentBuilder.parse(file);

			doc.getDocumentElement().normalize();
			Element rootElement = doc.getDocumentElement();

			System.out.println(rootElement.getNodeName());

			// readWards(rootElement);
			// readDoctors(rootElement);
			// readPatients(rootElement);
			// readMedicines(rootElement);
			// readTreatments(rootElement);

		} catch (Exception E) {
			E.printStackTrace();
		}

	}

	public static void readWards(Element rootElement) {
		try {
			NodeList nodeList = rootElement.getElementsByTagName("ward");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node currentNode = nodeList.item(i);
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					Element currentElement = (Element) currentNode;

					String id = currentElement.getAttribute("id");
					System.out.println("Id: " + id);

					String name = currentElement.getElementsByTagName("name").item(0).getTextContent();
					System.out.println("\tName: " + name);

					String location = currentElement.getElementsByTagName("location").item(0).getTextContent();
					System.out.println("\tLocation: " + location);
				}
			}
		} catch (DOMException e) {
			e.printStackTrace();
		}
	}

	public static void readDoctors(Element rootElement) {
		try {
			NodeList nodeList = rootElement.getElementsByTagName("doctor");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node currentNode = nodeList.item(i);
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					Element currentElement = (Element) currentNode;

					String id = currentElement.getAttribute("id");
					System.out.println("id: " + id);

					String fullname = currentElement.getElementsByTagName("fullname").item(0).getTextContent();
					System.out.println("\tName: " + fullname);

					String birthdate = currentElement.getElementsByTagName("birthdate").item(0).getTextContent();
					System.out.println("\tBirthdate: " + birthdate);

					// optional node
					NodeList specializingNode = currentElement.getChildNodes();
					for (int j = 0; j < specializingNode.getLength(); j++) {
						if (specializingNode.item(j).getNodeName() == "specializing") {
							String specializing = specializingNode.item(j).getTextContent();
							System.out.println("\tSpecializing: " + specializing);
						}
					}

					// id ref
					String employed = currentElement.getElementsByTagName("employed").item(0).getTextContent();
					NodeList wardNodes = rootElement.getElementsByTagName("ward");
					for (int k = 0; k < nodeList.getLength(); k++) {
						Node currentWardNode = wardNodes.item(k);
						if (currentWardNode.getNodeType() == Node.ELEMENT_NODE) {
							Element currentWardElement = (Element) currentWardNode;
							if (currentWardElement.getAttribute("id").compareToIgnoreCase(employed) == 0) {
								String wardName = currentWardElement.getElementsByTagName("name").item(0)
										.getTextContent();
								System.out.println("\tEmployed at: " + wardName);
							}
						}
					}
				}
			}
		} catch (DOMException e) {
			e.printStackTrace();
		}
	}

	public static void readPatients(Element rootElement) {
		try {
			NodeList nodeList = rootElement.getElementsByTagName("patient");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node currentNode = nodeList.item(i);
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					Element currentElement = (Element) currentNode;

					String id = currentElement.getAttribute("id");
					System.out.println("id: " + id);

//					NodeList nameNodes=currentElement.getElementsByTagName("fullname").item(0).getChildNodes();
//					String fullname="";
//					for (int j = 0; j < nameNodes.getLength(); j++) {
//						fullname+=nameNodes.item(j).getTextContent();
//					}
					String fullname = currentElement.getElementsByTagName("fullname").item(0).getTextContent();
					System.out.println("\tName: " + fullname);

					String birthdate = currentElement.getElementsByTagName("birthdate").item(0).getTextContent();
					System.out.println("\tBirthdate: " + birthdate);

					// multivalued
					for (int j = 0; j < currentElement.getElementsByTagName("allergy").getLength(); j++) {
						String allergy = currentElement.getElementsByTagName("allergy").item(j).getTextContent();
						System.out.println("\tAllergy: " + allergy);
					}

				}
			}
		} catch (DOMException e) {
			e.printStackTrace();
		}

	}

	public static void readMedicines(Element rootElement) {
		try {
			NodeList nodeList = rootElement.getElementsByTagName("medicine");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node currentNode = nodeList.item(i);
				if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
					Element currentElement = (Element) currentNode;

					String id = currentElement.getAttribute("id");
					System.out.println("id: " + id);

					String name = currentElement.getElementsByTagName("name").item(0).getTextContent();
					System.out.println("\tName: " + name);

					String price = currentElement.getElementsByTagName("price").item(0).getTextContent();
					System.out.println("\tPrice: " + price);

				}
			}
		} catch (DOMException e) {
			e.printStackTrace();
		}
	}

	public static void readTreatments(Element rootElement) {

		NodeList nodeList = rootElement.getElementsByTagName("treatment");

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				Element currentElement = (Element) currentNode;
				
				//patient
				String patient = currentElement.getElementsByTagName("patient-id").item(0).getTextContent();
				NodeList patientNodes = rootElement.getElementsByTagName("patient");
				for (int j = 0; j < patientNodes.getLength(); j++) {
					Node currentPatientNode = patientNodes.item(j);
					if (currentPatientNode.getNodeType() == Node.ELEMENT_NODE) {
						Element currentPatientElement = (Element) currentPatientNode;
						if (currentPatientElement.getAttribute("id").compareToIgnoreCase(patient) == 0) {
							String patientName = currentPatientElement.getElementsByTagName("fullname").item(0).getTextContent();
							System.out.println("\tPatient: " + patientName);
						}
					}
				}
				
				// id ref
				String ward = currentElement.getElementsByTagName("ward-id").item(0).getTextContent();
				NodeList wardNodes = rootElement.getElementsByTagName("ward");
				for (int j = 0; j < nodeList.getLength(); j++) {
					Node currentWardNode = wardNodes.item(j);
					if (currentWardNode.getNodeType() == Node.ELEMENT_NODE) {
						Element currentWardElement = (Element) currentWardNode;
						if (currentWardElement.getAttribute("id").compareToIgnoreCase(ward) == 0) {
							String wardName = currentWardElement.getElementsByTagName("name").item(0)
									.getTextContent();
							System.out.println("\tTreated at: " + wardName);
						}
					}
				}
			}
		}
	}
}
