/*
 * Author@ Matthew Sagen
 * 7/17/2017
 * This is a simple java program that implements MYSQL. 
 */

import java.sql.*;
import java.util.Calendar;

public class Main {
	private static int def;
	
	public static void main(String[] args){	

		try{
			//1: Get a connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false", "guest", "guest");
			
			//2: Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3: Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM student");
			
			//4: Process the result set
			System.out.println("First|Last|Lunch Cost");
			System.out.println("----------------------");
			while(myRs.next()){
				System.out.println(myRs.getString("first_name") + ", " + myRs.getString("last_name") + ", " + myRs.getDouble("lunch_cost"));
			}
			//5: Write to database
			System.out.println();
			
			//get user input and time stamp
			Student myStudent = new Student();
			while(myStudent.getVerif() == 0){
				myStudent.getData();
				if(myStudent.getVerif()==1){
					System.out.println("Thank you!");
				}
			}
			
			def = 0;
		    Calendar calendar = Calendar.getInstance();
		    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		    
			//MySQL insert statement
		    String query = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
		    //MSQL insert prepared statement
		    PreparedStatement preparedStmt = myConn.prepareStatement(query);
		    preparedStmt.setString(1,myStudent.getFirstName());
		    preparedStmt.setString(2,myStudent.getLastName());
		    preparedStmt.setString(3,myStudent.getEmail());
		    preparedStmt.setString(4,myStudent.getAddress());
		    preparedStmt.setString(5,myStudent.getCity());
		    preparedStmt.setString(6,myStudent.getState());
		    preparedStmt.setInt(7,myStudent.getZip());
		    preparedStmt.setLong(8,myStudent.getPhone());
		    preparedStmt.setInt(9,myStudent.getBd());
		    preparedStmt.setString(10,myStudent.getSex());
		    preparedStmt.setDate(11,startDate);
		    preparedStmt.setDouble(12,myStudent.getLc());
		    preparedStmt.setInt(13, def);
		    
		    //Execute the prepared statement
		    preparedStmt.execute();
		    
		    //close connection
		    myRs.close();
		    myStmt.close();
		    myConn.close();
		    System.exit(0);
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
}
