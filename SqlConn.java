/*
 * Author@ Matthew Sagen
 * 7/17/2017
 * This is a simple java program that implements MYSQL. 
 */
package sqlProject;
import java.sql.*;
import java.util.Calendar;

public class SqlConn{
	
	private static int def;
	
	public static void main(String[] args){	

		try{
			//1: Get a connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqlProject?autoReconnect=true&useSSL=false", "guest", "guest");
			
			//2: Create a statement
			Statement myStmt = myConn.createStatement();
			
			//3: Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM members");
			
			System.out.println("Welcome!");
			System.out.println("----------------");
			
			//5: Write to database
			System.out.println();
			
			Member newMember = new Member();
			def = 0;
			while(def==0) {
				newMember.getData();
				if(newMember.getRes() == 0) {
					def = 1;
					System.out.println("Thank you!");
				}
			}
		    /*
			Calendar calendar = Calendar.getInstance();
		    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		    */
			
			//MySQL insert statement
		    String query = "INSERT INTO members VALUES(?,?,?)";
			def = 0;
		    //MSQL insert prepared statement
		    PreparedStatement preparedStmt = myConn.prepareStatement(query);
		    preparedStmt.setString(1,newMember.getFirstName());
		    preparedStmt.setString(2,newMember.getLastName());
		    preparedStmt.setInt(3, def);
		 
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
