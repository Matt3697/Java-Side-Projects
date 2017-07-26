import java.util.Scanner;


public class Student {
	private String firstname,lastname,email,address,city,state,sex;
	private int zip,bd,verify;
	private long phone;
	private double lc;
	
	public void getData(){
		boolean flag = false;
		Scanner scanner = new Scanner(System.in);
		
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
		
		if(verify > 1 || verify < 0){
			System.out.println("Invalid Choice. Try again.");
		}
	}	
	public String getFirstName(){
		return firstname;
	}
	public String getLastName(){
		return lastname;
	}
	public String getEmail(){
		return email;
	}
	public String getAddress(){
		return address;
	}
	public String getCity(){
		return city;
	}
	public String getState(){
		return state;
	}
	public String getSex(){
		return sex;
	}
	public int getZip(){
		return zip;
	}
	public int getBd(){
		return bd;
	}
	public long getPhone(){
		return phone;
	}
	public double getLc(){
		return lc;
	}
	public int getVerif(){
		return verify;
	}
}
