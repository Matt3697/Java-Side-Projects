package sqlProject;

import java.util.Scanner;

public class Member {
	public String first_name, last_name;
	public int res;
	
	public Member() {
		
	}
	
	public void getData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter Members First Name.");
		first_name = scanner.nextLine();
		System.out.println("Please Enter Members Last Name.");
		last_name = scanner.nextLine();
		System.out.println();
		System.out.println("You Entered " + first_name + " " + last_name);
		System.out.println("Is this information correct? (yes (0) or no (1)");
		res = scanner.nextInt();
	}
	
	public String getFirstName() {
		return first_name;
	}
	public String getLastName() {
		return last_name;
	}
	public int getRes() {
		return res;
	}
}
