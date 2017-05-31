package iitkgp;
import java.util.Scanner;
/**
 * @since  31/05/2017 Wednesday
 * @author pankaj
 * @location Indian Institute of Technology, Kharagpur
 * <h3>Description</h3>
 * This class takes input from user as required by the program.<p>
 * This uses try-catch-finally blocks For exception handling in case an exception is thrown.
 * @see Validate
 */
public class UserInputTaker {
	static Scanner sc=null;
	UserInputTaker(){
		sc=new Scanner(System.in);
	}
	public static void main(String[] args) {
		int ports,cores,users,switches,grid;
		grid=Database.getGridsize();
		
		try{
			// For Ports
			System.out.println("Number of Ports in a switch (n>=4):");
			ports=sc.nextInt();
			if(Validate.validatePorts(ports))
				Database.setPORTS(ports);
			else
				throw new Exception("Please enter a number greater or equal to 4");
			
			//For Number of Users
			System.out.println("Number of Users:Range[0,"+grid*grid/2+"]");
			users=sc.nextInt();
			if(Validate.validateUsers(users))
				Database.setUserCount(sc.nextInt());
			else
				throw new  Exception("Invalid Number of users");
			
			//For switches
			System.out.println("Number of Switches : Range["+users/ports+","+users+"]");
			switches=sc.nextInt();
			if(Validate.validateSwitches(switches))
				Database.setSwitchCount(sc.nextInt());
			else
				throw new Exception("Invalid Number of Switches");
			
			//For core switches
			System.out.println("Number of Core Switches : Range["+users/ports+","+users+"]");
			cores=sc.nextInt();
			if(Validate.validateCores(cores))
				Database.setCoreCount(sc.nextInt());
			else
				throw new Exception("invalid Number of core switches");
		}
		
		catch(Exception e){
			System.out.println("Please Enter Correct details");
		}
		finally{
			sc.close();
		}
	}
}
