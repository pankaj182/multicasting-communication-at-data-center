package iitkgp;
/**
 * @since  31/05/2017 Wednesday
 * @author pankaj
 * @location Indian Institute of Technology, Kharagpur
 * <h3>Description</h3>
 * This abstratc class validates all the data from user.
 */
public abstract class Validate {
	/**
	 * This method checks the validity based on the number of ports of a switch
	 * It returns false if Number of ports <4
	 * @param ports user input indicating how many ports a switch can possess
	 * @return boolean value
	 */
	public boolean validatePorts(int ports){
		if(ports<4)
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
	public boolean validateUsers(int users){
		/* we are taking maximum users slightly lesser than maximum allowable.
		 * so as to allow switches and core switches to be accomodated without overlapping.
		 * This is just to reduce comlexity.
		 * Hence
		 * Number of maximum users=Maximum grid size/2;
		 */
		int n=Database.getGridsize();
		n=n*n;
		if(users<0 || users> n/2)
			return false;
		return true;
	}
	/**
	 * This method returns whether the number of switches are feasible or not.
	 * Optimum number of switches is one that can handle request from all users
	 * @param switches : number of switches
	 * @return Boolean
	 */
	public boolean validateSwitches(int switches){
		/*
		 * optimum number of switches=#users/(Number of ports in a switch)/2.
		 * Divided by 2 because half or ports of a switch will be connected to cores.
		 * Also assuming number of switches can not be more than number of swicthes.
		 */
		int n=Database.getUserCount();
		int m=Database.getPORTS();
		if(switches<=(n/m) || switches>=n)
			return false;
		return true;
	}
	/**
	 * This method validate Number of cores users can maximum have.
	 * @param cores Integer denoting  number of cores
	 * @return boolean value
	 */
	public boolean validateCores(int cores){
		/*
		 * Assuming Maximum cores allowed is as much as the number of switches
		 * and minimum number of cores = n/m i.e all ports of cores serves all different switches
		 * i.e when there will be no redundancy
		 */
		int n=Database.getSwitchCount();
		int m=Database.getPORTS()/2;
		if(cores<=n/m || cores>=n)
			return false;
		return true;
	}
}
