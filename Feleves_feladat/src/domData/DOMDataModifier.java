package domData;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMDataModifier {
	public static void main(String[] args) {

		try {
			File inputFile = new File("hospital.xml");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(inputFile);
			
			Element rootElement = doc.getDocumentElement();

			String oldPatientID = "pat23", newPatientID = "pat11";
			modifyPatientID(rootElement, oldPatientID, newPatientID);
			String medicineName = "Aspirin";
			int newPrice = 1662;
			updateMedicinePrice(rootElement, medicineName, newPrice);

			// write the content on back into the file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult outputResult = new StreamResult(inputFile);
			transformer.transform(source, outputResult);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modifyPatientID(Element rootElement, String oldPatientID, String newPatientID) {
		try {
			NodeList patientList = rootElement.getElementsByTagName("patient");
			// update patient id
			for (int i = 0; i < patientList.getLength(); i++) {
				NamedNodeMap attr = patientList.item(i).getAttributes();
				Node nodeAttr = attr.getNamedItem("id");
				if (oldPatientID.equalsIgnoreCase(nodeAttr.getTextContent())) {
					nodeAttr.setTextContent(newPatientID);
					System.out.println("Modified patient with id " + oldPatientID + ".");
					break;
				}
			}
		} catch (DOMException e) {
			e.printStackTrace();
		}
	}

	public static void updateMedicinePrice(Element rootElement, String medicineName, int newPrice) {
		try {
//			all medicine nodes
			NodeList medicineList = rootElement.getElementsByTagName("medicine");
//			all nodes of one medicine
			NodeList allMedicine = medicineList.item(0).getChildNodes();
			for (int i = 0; i < medicineList.getLength(); i++) {
//				test if current node is the same as the one we are looking for
				Node medNode = allMedicine.item(i);
				if (medNode.getNodeName().equals("name") && medicineName.equalsIgnoreCase(medNode.getTextContent())) {
					Element medElement = (Element) medNode.getParentNode();
//						System.out.println(medElement.getElementsByTagName("price").item(0).getTextContent());
					medElement.getElementsByTagName("price").item(0).setTextContent(String.valueOf(newPrice));
					System.out.println("Modified price of " + medicineName + " to " + newPrice);
					break;
				}
			}
		} catch (DOMException e) {
			e.printStackTrace();
		}

	}
}
