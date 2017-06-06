package iitkgp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
	private static int users,switches,cores,grid,ports;
	private static HashMap<Integer,ArrayList<Integer>> graph;
	private static ArrayList<Core> cl =new ArrayList<>();
	private static ArrayList<Switch> sl=new ArrayList<>();
	private static ArrayList<User> ul=new ArrayList<>();
	
	/**
	 * This method creates graph upon which the shortest path algorithm will be implemented.
	 * @param users number of users
	 * @param switches Number of switches in the network
	 * @param cores number of core switches
	 * The graph is stored in the Database class's static field "map"
	 */
	public static  void makeGraph(){
		allocate();
		connectSwitchesToCores();
		connectUsersToSwitches();
		Database.setGraph(graph);
	}
	//@SuppressWarnings("unchecked")
	private static void allocate() {
		users=Database.getUserCount();
		switches=Database.getSwitchCount();
		cores=Database.getCoreCount();
		grid=Database.getGridsize();
		graph=new HashMap<>();
		ports=Database.getPORTS();
		
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
		
		//position stores N random numbers, N=#users+#switches+#cores
		int[] position=Utilities.rand(0, grid, users+switches+cores,true);
		int from,to;
		HashMap<Integer,User> userList=new HashMap<>();
		HashMap<Integer,Switch> switchList=new HashMap<>();
		HashMap<Integer,Core> coreList=new HashMap<>();
		
		/*
		 * This fragment of code populates the database's usersList
		 * It populates from the numbers generated in position array.
		 */
		Database.setSourceId(position[0]);
		from=0; to=users;
		for(int i = from; i< to ;i++){
			User user=NodeFactory.getUser(position[i],5,5);
			userList.put(position[i],user);
			ul.add(user);
		}
		Database.setUsersList(userList);
		
		/*
		 * This fragment of code populates the database's switchesList
		 * It populates from the numbers generated in position array.
		 */
		from=users; to=users+switches;
		for(int i=from;i<to;i++){
			Switch swit=NodeFactory.getSwitch(position[i]);
			switchList.put(position[i],swit);
			sl.add(swit);
		}
		Database.setSwitchesList(switchList);
		
		/*
		 * This fragment of code populates the database's coresList
		 * It populates from the numbers generated in position array.
		 */
		from=users+switches; to=users+switches+cores;
		for(int i=from;i<to;i++){
			Core core=NodeFactory.getCore(position[i]);
			coreList.put(position[i],core);
			cl.add(core);
		}
		Database.setCoresList(coreList);
	}
	private static void connectUsersToSwitches() {
		int dist,temp,minid = 0;
		ArrayList<Integer> al;
		for(User user:ul){
			dist=Integer.MAX_VALUE;
			for(Switch switc:sl){
				if(switc.isInPortFree() && (temp=findDistance(user.getId(),switc.getId()))<dist){
					dist=temp;
					minid=switc.getId();
				}
			}
			if(graph.containsKey(user.getId())){
				al=graph.get(user.getId());
				al.add(minid);
				graph.put(user.getId(), al);
			}
			else{
				al=new ArrayList<>();
				al.add(minid);
				graph.put(user.getId(), al);
			}
			if(graph.containsKey(minid)){
				al=graph.get(minid);
				al.add(user.getId());
				graph.put(minid, al);
			}
			else{
				al=new ArrayList<>();
				al.add(user.getId());
				graph.put(minid, al);
			}
		}
	}
	private static synchronized void connectSwitchesToCores() {
		int dist,sid,cid;
		ArrayList<Pair> distance = new ArrayList<>();
		for(Switch s:sl){
			for(Core c:cl){
				//System.out.println(s.getId()+" "+c.getId());
					dist=findDistance(s.getId(),c.getId());
					//System.out.println(dist);
					Pair p=new Pair();
					p.id=c.getId();
					p.dist=dist;
					//System.out.println(dist+" "+p.dist);
					distance.add(p);
			}
			//System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
			Collections.sort(distance,new PairSorting());
			//System.out.println("Number of ports= "+ports);
			sid=s.getId();
			ArrayList<Integer> al=null;;
			for(int i=0;i<ports/2;i++){
				cid=distance.get(i).id;
				s.connectToCore(cid);
				if(graph.containsKey(sid)){
					al=(graph.get(sid));
					al.add(cid);
					graph.put(sid,al);
				}
				else{
					al=new ArrayList<>();
					al.add(cid);
					graph.put(sid,al);
				}
				if(graph.containsKey(cid)){
					al=(graph.get(cid));
					al.add(sid);
					graph.put(cid,al);
				}
				else{
					al=new ArrayList<>();
					al.add(sid);
					graph.put(cid,al);
				}
			}
			distance.clear();
		}
	}
	private static int findDistance(int id, int id2) {
		// TODO Auto-generated method stub
		int x1,x2,y1,y2;
		x1=id/100;
		y1=id%100;
		x2=id2/100;
		y2=id2%100;
		
		return (int)(Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
	}
}