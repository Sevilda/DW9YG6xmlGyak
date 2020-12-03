package myPackage;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JavaObject {

	public static void main(String[] args) {

		try {
			Object obj = new JSONParser().parse(new FileReader("XMLDw9yg61.json"));
			JSONObject jsonObj = (JSONObject) obj;
			System.out.println(jsonObj.toJSONString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
