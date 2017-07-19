/*
 * Author@ Matthew Sagen
 * 7/17/2017
 * This is a simple java program that implements MYSQL. 
 */
import java.math.BigInteger;
import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	public static String firstname;
	public static String lastname;
	public static String email;
	public static String address;
	public static String city;
	public static String state;
	public static int def;
	public static String sex;
	public static int zip;
	public static int bd;
	public static long phone;
	public static double lc;
	
	public static void main(String[] args){	
		try{
			//1: Get a connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "guest", "guest");
			
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
			//get user input and timestamp
			getData();
			def = 0;
		    Calendar calendar = Calendar.getInstance();
		    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		    
			//MySQL insert statement
		    String query = "INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
		    //MSQL insert prepared statement
		    PreparedStatement preparedStmt = myConn.prepareStatement(query);
		    preparedStmt.setString(1, firstname);
		    preparedStmt.setString(2, lastname);
		    preparedStmt.setString(3, email);
		    preparedStmt.setString(4, address);
		    preparedStmt.setString(5, city);
		    preparedStmt.setString(6, state);
		    preparedStmt.setInt(7, zip);
		    preparedStmt.setLong(8, phone);
		    preparedStmt.setInt(9, bd);
		    preparedStmt.setString(10, sex);
		    preparedStmt.setDate(11, startDate);
		    preparedStmt.setDouble(12, lc);
		    preparedStmt.setInt(13, def);
		    
		    //Execute the prepared statement
		    preparedStmt.execute();
		    
		    //close connection
		    myConn.close();
		    System.exit(0);
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public static void getData(){
		boolean flag = false;
		int verify;
		while(flag == false){
			System.out.println("Enter your first name: ");
			firstname = scanner.nextLine();
			
			System.out.println("Enter your last name: ");
			lastname = scanner.nextLine();
			
			System.out.println("Enter your email address: ");
			email = scanner.nextLine();
			
			System.out.println("Enter your street address: ");
			address = scanner.nextLine();
			
			System.out.println("Enter your City: ");
			city = scanner.nextLine();
			
			System.out.println("Enter your State:(Ex: MT) ");
			state = scanner.nextLine();
			
			System.out.println("Enter your ZIP: ");
			zip = scanner.nextInt();
			
			System.out.println("Enter your phone number: (No hyphens)");
			phone = scanner.nextLong();
			
			System.out.println("Enter your birthdate: (YYMMDD) ");
			bd = scanner.nextInt();
			
			System.out.println("Enter your sex: (M or F)");
			sex = scanner.next();
			
			System.out.println("Enter Lunch cost: ");
			lc = scanner.nextDouble();
			
			System.out.println(firstname + "|" + lastname + "|" + email + "|"  + address + "|" 
			+ city + "|" + state + "|" + zip + "|" + phone + "|" + bd + "|" + sex + "|" + lc);
			System.out.println("----------------------------");
			System.out.println("Is this information correct? (1 for yes, or 0 for no)");
			verify = scanner.nextInt();
			if(verify==1){
				flag = true;
				System.out.println("Thank you!");
			}
			else if(verify==0){
				flag = false;
			}
			else{
				System.out.println("Invalid Choice. Try again.");
			}
		}
	}
}
