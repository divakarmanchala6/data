package studentsData;

import java.io.*;
import java.sql.*;

public class MarksFromDatabse {

	public static void main(String[] args) {
		String path = "/Users/divakarmanchala/Documents/studentsmarks.csv";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));
			String line;
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "password");
			
			String query = "INSERT INTO marks (roll_no, student_name, telugu, hindi, english, maths, social, science) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement prpt = cnn.prepareStatement(query);
			
			String readQuery = "SELECT * FROM marks";
			
			PreparedStatement readPrpt = cnn.prepareStatement(readQuery);
			ResultSet readResults = readPrpt.executeQuery();
			String readLine;
			
			
			int count = 0;
			while ((line = bf.readLine()) != null) {
				//System.out.println(line);
				if (count == 0) {
					count++;
					continue;
				}
				String[] ar = line.split(",");
				prpt.setInt(1, Integer.parseInt(ar[0]));
				
				prpt.setString(2, ar[1]);
				prpt.setInt(3, Integer.parseInt(ar[2]));
				prpt.setInt(4, Integer.parseInt(ar[3]));
				prpt.setInt(5, Integer.parseInt(ar[4]));
				prpt.setInt(6, Integer.parseInt(ar[5]));
				prpt.setInt(7, Integer.parseInt(ar[6]));
				prpt.setInt(8, Integer.parseInt(ar[7]));
				prpt.executeUpdate();
				System.out.println("Executed");
				
			}
			bf.close();
			cnn.close();
		} catch (IOException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
