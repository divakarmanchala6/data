package studentsData;
import java.io.*;
import java.util.*;

public class Students {
	
	
	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> students = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the student name: ");
		String name = sc.nextLine();
		sc.close();
		
		String filePath = "/Users/divakarmanchala/Documents/studentsmarks.csv";
		
		try {
			
			BufferedReader bf = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = bf.readLine()) != null) {
				//System.out.println(line);
				String[]  ar = line.split(",");
				HashMap<String, String> m = new HashMap<String, String>();
				m.put("Roll Number", ar[0]);
				m.put("Name", ar[1]);
				m.put("Telugu", ar[2]);
				m.put("Hindi", ar[3]);
				m.put("English", ar[4]);
				m.put("Maths", ar[5]);
				m.put("Science", ar[6]);
				m.put("Social", ar[7]);
				students.add(m);
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HashMap<String, String> studentMarks = new HashMap<String, String>();
		
		for (HashMap<String, String> student: students) {
			if (student.get("Name").equals(name)) {
				studentMarks = student;
			}
		}
		
		if (studentMarks.isEmpty()) {
			System.out.println("Student Not Found");
		} else {
			int telugu = Integer.parseInt(studentMarks.get("Telugu"));
			int hindi = Integer.parseInt(studentMarks.get("Hindi"));
			int english = Integer.parseInt(studentMarks.get("English"));
			int maths = Integer.parseInt(studentMarks.get("Maths"));
			int science = Integer.parseInt(studentMarks.get("Science"));
			int social = Integer.parseInt(studentMarks.get("Social"));
			int total = telugu + hindi + english + maths + social + science;
			
			System.out.println("Name of the student: " + studentMarks.get("Name"));
			System.out.println("Roll No: " + studentMarks.get("Roll Number"));
			System.out.println();
			System.out.println("-----Marks Obtained-----");
			System.out.println("Telugu:  " + telugu);
			System.out.println("Hindi:   " + hindi);
			System.out.println("English: " + english);
			System.out.println("Maths:   " + maths);
			System.out.println("Science: " + social);
			System.out.println("Social:  " + science);
			System.out.println("------------");
			System.out.println("Total:   " + total);
		}

	}

}
