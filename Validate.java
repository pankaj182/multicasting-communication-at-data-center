package iitkgp;
/**
 * This abstratc class validates all the data from user.
 * @since  31/05/2017 Wednesday
 * @author pankaj
 * @location Indian Institute of Technology, Kharagpur
 * @see Validate#validatePorts(int)
 * @see Validate#validateUsers(int)
 * @see Validate#validateSwitches(int)
 * @see Validate#validateCores(int)
 * @see UserInputTaker
 */
public abstract class Validate {
	
	/**
	 * This method checks the validity based on the number of ports of a switch
	 * It returns false if Number of ports <4
	 * @param ports user input indicating how many ports a switch can possess
	 * @return boolean value
	 */
	public static boolean validatePorts(int ports){
		if(ports<4)
			return false;
		return true;
	}
	
	/**
	 * This method returns whether the number of switches are feasible or not.
	 * Number of switches is taken as basic input based on which other constraints will be applied.
	 * @param switches : number of switches
	 * @return Boolean
	 */
	public static boolean validateSwitches(int switches){
		/*
		 * optimum number of switches taken to be in range [1,1000]
		 */
		if(switches<1 || switches>1000)
			return false;
		return true;
	}
	
	/**
	 * This method validate Number of cores users can maximum have.
	 * @param cores Integer denoting  number of cores
	 * @return boolean value
	 */
	public static boolean validateCores(int cores){
		/*
		 * Assuming Maximum cores allowed is as much as the number of switches
		 * Since number of ports in a core = P
		 * Number of ports for cores in a switch = P/2
		 * i.e total P*S/2 number of ports in all S switches.
		 * Hence Total number of ports across all cores = (C*P)
		 * hence C*P= P*S/2
		 * => C = S/2
		 * and minimum number of cores = n/m i.e all ports of cores serves all different switches
		 * i.e when there will be no redundancy
		 */
		int ports=Database.getPORTS();
		int switches=Database.getSwitchCount();
		if(cores<Math.max(ports, switches/2) || cores>switches)
			return false;
		return true;
	}
	
	/**
	 * This method checks the validity based on number of users that the network can support.
	 * @param users : number of users
	 * @return true if number of users are feasible
	 *  else returns false
	 *  <p>We can extend it by increasing the GRID size in Database class
	 *  @see Database#setPORTS(int)
	 */
	public static boolean validateUsers(int users){
		/* we are taking maximum users = switches*ports/4;
		 * so as to allow switches and core switches to be accomodated without overlapping.
		 * Each switch has P/2 ports for end hosts.
		 * Hence There are P*S/2 ports across all switches for end hosts.
		 * hence we can have maximum of P*S/2 users
		 */
		int switches=Database.getSwitchCount();
		int ports=Database.getPORTS();
		if(users<2 || users> switches*ports/2)
			return false;
		return true;
	}
}
