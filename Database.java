package iitkgp;

import java.util.HashMap;

/**
 * @since  31/05/2017 Wednesday
 * @author pankaj
 * @location Indian Institute of Technology, Kharagpur
 * <h3>Description</h3>
 * This abstratc class stores all the data from user as well as the computed data.
 * <p>contains getter and setter methods to set and retrieve data from this class.
 */
public abstract class Database {
	private static final int GRID=50;
	private static int CORE=50;
	private static int SWITCH=200;
	private static int USER=1000;
	private static int PORTS=8;
	private static HashMap<Integer,Integer> map=new HashMap<>();
	
	/**
	 * This method is a getter method that return a hashmap.
	 * @return map : a hashmap containing all connectivity between nodes
	 */
	public static HashMap<Integer, Integer> getGraph(){
		return map;
	}
	/**
	 * This method is a getter method.
	 * @return GRID : the size of the grid is GRID * GRID
	 */
	public static int getGridsize() {
		return GRID;
	}
	/**
	 * This is a getter method that returns number of Cores in the network.
	 * @return Integer
	 */
	public static int getCoreCount() {
		return CORE;
	}
	/**
	 * This is a setter method that sets the Number of Cores in network to passed arguement
	 * @param coreCount Number of cores in the network
	 */
	public static void setCoreCount(int coreCount) {
		Database.CORE = coreCount;
	}
	/**
	 * This is a getter method that return number of Switches in the network.s
	 * @return Integer
	 */
	public static int getSwitchCount() {
		return SWITCH;
	}
	/**
	 * This is a setter method that sets number of switches in Network to passed parameter
	 * @param switchCount the number of switches in the network
	 */
	public static void setSwitchCount(int switchCount) {
		Database.SWITCH = switchCount;
	}
	/**
	 * This is a getter method returning number of End Hosts in the network.
	 * @return Integer
	 */
	public static int getUserCount() {
		return USER;
	}
	/**
	 * This is a setter method that sets number of end hosts to passed parameter
	 * @param userCount number of users in the network
	 */
	public static void setUserCount(int userCount) {
		Database.USER = userCount;
	}
	/**
	 * This is a getter method that returns number of PORTS each switch has.
	 * @return Integer : number of ports/switch
	 */
	public static int getPORTS() {
		return PORTS;
	}
	/**
	 * This is a setter method that sets number of Ports of each switch to passed parameter. This is the maximum number of hosts a switch can be connected to.
	 * @param ports Integer denoting the number of ports/switch
	 */
	public static void setPORTS(int ports) {
		PORTS = ports;
	}
	
}
