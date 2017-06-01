package iitkgp;

import java.util.ArrayList;

/**
 * @since  31/05/2017 Wednesday
 * @author pankaj
 * @location Indian Institute of Technology, Kharagpur
 * <h3>Description</h3>
 * This abstract class generates the graph taking users switches and cores as its nodes
 * @see GraphMaker#makeGraph()
 * @see Utilities#rand(int, int, int, boolean)
 */
public abstract class GraphMaker {
	private static int users,switches,cores,max;
	/**
	 * This method creates graph upon which the shortest path algorithm will be implemented.
	 * @param users number of users
	 * @param switches Number of switches in the network
	 * @param cores number of core switches
	 * The graph is stored in the Database class's static field "map"
	 */
	public static synchronized void makeGraph(){
		users=Database.getUserCount();
		switches=Database.getSwitchCount();
		cores=Database.getCoreCount();
		max=Database.getGridsize();
		max=max*max-1;
		/*
		 * The logic here is :
		 * Number of unique random numbers we are generating=#users + #switches + #cores
		 * The reason to do this is-
		 * to avoid the case when there might be one location with two or more nodes(switches/cores/users)
		 * Once we get all random numbers,
		 * we take required number of Random numbers each for switches, cores and switches.
		 * 
		 * Now each number gives its location in grid:
		 * N/100 will give x-coordinate
		 * N%100 will give y-coordinate
		 * Illustration : 
		 * let N=1234
		 * then 1234/100 = 12 = x-coordinate
		 * 1234%100 = 34 = y coordinate
		 * hence (x,y)=(12,34)
		 */
		
		int[] position=Utilities.rand(0, max, users+switches+cores,true);
		
		int from,to;
		
		ArrayList<User> userList=Database.getUsers();
		from=0; to=users;
		for(int i = from; i< to ;i++){
			userList.add(NodeFactory.getUser(position[i],5,5));
		}
		ArrayList<Switch> switchList=Database.getSwitches();
		from=users; to=users+switches;
		for(int i=from;i<to;i++){
			switchList.add(NodeFactory.getSwitch(position[i]));
		}
		
		ArrayList<Core> coreList=Database.getCores();
		from=users+switches; to=users+switches+cores;
		for(int i=from;i<to;i++){
			coreList.add(NodeFactory.getCore(position[i]));
		}
	}
}
