package myPackage;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class JavaArray {

	public static void main(String[] args) {

		try {
			Object obj = new JSONParser().parse(new FileReader("XMLDw9yg61.json"));
			
			JSONArray jsonArray = (JSONArray) obj;
			//not correct, will have to recheck
			Iterator<String> iterator = jsonArray.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
