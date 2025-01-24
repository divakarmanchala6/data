package studentsData;

import java.util.*;

public class Demo {
	
	
	
	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Roll Number", "1");
		map.put("Name", "Divakar");
		map.put("Telugu", "90");
		map.put("Hindi", "30");
		map.put("English", "60");
		map.put("Maths", "76");
		map.put("Science", "62");
		map.put("Social", "72");
		ar.add(map);
		
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("Roll Number", "1");
		m.put("Name", "Pawan Kalyanl");
		m.put("Telugu", "90");
		m.put("Hindi", "30");
		m.put("English", "60");
		m.put("Maths", "76");
		m.put("Science", "62");
		m.put("Social", "72");
		ar.add(m);
		
		
		
		
		//System.out.println(m.get("Name"));
		
		HashMap<String, String> sts = new HashMap<String, String>();
		
		for (HashMap<String, String> i: ar) {
			//System.out.println(i);
			if (i.get("Name") == "Divakar") {
			sts = i;
			}
		}
		
		if (sts.isEmpty()) {
			System.out.println("Student Not Found");
		} else {
			System.out.println("Name: " + sts.get("Name"));
		}
		
		

	}

}
