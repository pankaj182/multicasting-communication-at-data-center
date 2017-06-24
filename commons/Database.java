package commons;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * This class is the stores the intermediatory results. 
 * All classes can access these results from here.
 * @since June 7 2017 
 * @author pankaj
 * @location IITKGP
 */
public abstract class Database {
	
	/*
	 * @param switches : HashMap to store Switches, Key -> ID, Value - > Instance of Switch
	 * @param cores : HashMap to store Core Switches, Key -> ID, Value - > Instance of Core
	 * @param users : HashMap to store users, Key -> ID, Value - > Instance of User
	 * @param graph : HashMap to store Switches, Key -> ID, Value - > ArrayList of IDs of connected nodes
	 * @param interestedUsers : ArrayList of IDs of the interested users
	 * @param sourceId  : ID of the source Node(the sender)
	 */
	
	public static final double ENERGYCONSTANT = 1;
	private static HashMap<Long,Switch> switches;
	private static HashMap<Long,Core> cores;
	private static HashMap<Long,User> users;
	private static ArrayList<Long> interestedUsers;
	private static HashMap<Long,ArrayList<Long>> graph;
	private static Long sourceId;
	
	public static HashMap<Long,Switch> getSwitches() {
		return switches;
	}
	public static void setSwitches(HashMap<Long,Switch> switches) {
		Database.switches = switches;
	}
	public static HashMap<Long,Core> getCores() {
		return cores;
	}
	public static void setCores(HashMap<Long,Core> cores) {
		Database.cores = cores;
	}
	public static HashMap<Long,User> getUsers() {
		return users;
	}
	public static void setUsers(HashMap<Long,User> users) {
		Database.users = users;
	}
	public static void setInterestedUsers(ArrayList<Long> interestedUsers) {
		Database.interestedUsers=interestedUsers;
	}
	public static ArrayList<Long>  getInterestedUsers() {
		return interestedUsers;
	}
	public static HashMap<Long,ArrayList<Long>> getGraph() {
		return graph;
	}
	public static void setGraph(HashMap<Long,ArrayList<Long>> graph) {
		Database.graph = graph;
	}
	
	public static Long getSourceId() {
		return sourceId;
	}
	
	public static void setSourceId(long s) {
		 sourceId=s;
	}
	public static void reset(){
		sourceId=0l;
		switches=new HashMap<>();
		cores=new HashMap<>();
		users=new HashMap<>();
		graph=new HashMap<>();
		interestedUsers=new ArrayList<>();
	}
}
