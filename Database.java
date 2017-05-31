package iitkgp;

import java.util.HashMap;

/**
 * @since  31/05/2017 Wednesday
 * @author pankaj
 * @location Indian Institute of Technology, Kharagpur
 * <h3>Description</h3>
 * This class stores all the data from user as well as the computed data
 */
public abstract class Database {
	private static final int GRID=50;
	private static int CORE=50;
	private static int SWITCH=200;
	private static int USER=1000;
	private static int PORTS=8;
	private static HashMap<Integer,Integer> map=new HashMap<>();
	public static HashMap<Integer, Integer> getGraph(){
		return map;
	}
	public static int getGridsize() {
		return GRID;
	}
	public static int getCoreCount() {
		return CORE;
	}
	public static void setCoreCount(int coreCount) {
		Database.CORE = coreCount;
	}
	public static int getSwitchCount() {
		return SWITCH;
	}
	public static void setSwitchCount(int switchCount) {
		Database.SWITCH = switchCount;
	}
	public static int getUserCount() {
		return USER;
	}
	public static void setUserCount(int userCount) {
		Database.USER = userCount;
	}
	public static int getPORTS() {
		return PORTS;
	}
	public static void setPORTS(int ports) {
		PORTS = ports;
	}
	
}
