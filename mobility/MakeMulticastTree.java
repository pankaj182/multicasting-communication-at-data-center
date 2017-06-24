package mobility;
import commons.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class MakeMulticastTree {
	static HashMap<Long,User> users=Database.getUsers();
	ArrayList<Long> interestedUsers=Database.getInterestedUsers();
	static HashMap<Long,ArrayList<Long>> graph=Database.getGraph();
	static HashMap<Long,Switch> switches=Database.getSwitches();
	static HashMap<Long,Core> cores=Database.getCores();
	
	public static void makeTree(){
		addUserSwitch();
		addCoreCore();
//		addSwitchCore();
//		Database.setGraph(graph);
	}
	private static void addUserSwitch(){
		//call it first
		long uid,sid;
		User u;
		Switch s;
		ArrayList<Long> al;
		for(Map.Entry<Long, Switch> e:switches.entrySet()){
			sid=e.getKey();
			s=e.getValue();
			al=s.getInterestedUser();
			graph.put(sid,al); // all interested users of this switch added to graph
		}
		for(Map.Entry<Long, User> e:users.entrySet()){
			uid=e.getKey();
			u=e.getValue();
			sid=u.isConnectedTo();  // get the switch id to which this user is connected to
			al=new ArrayList<>();
			al.add(sid);
			graph.put(uid, al);
		}
		Database.setGraph(graph);
	}
	
	
	private static void addCoreCore(){
		//call it second
		// till now graph contains all the uid and sid as the key
		ArrayList<Long> allCoresId=new ArrayList<>();
		for(Long i:cores.keySet())
			allCoresId.add(i);
		ArrayList<Long> al=new ArrayList<>();
		
		// all cores now in the graph as key
		for(Long i:cores.keySet()){
			al.clear();
			al.addAll(allCoresId);
			al.remove(i);
			graph.put(i, al);
		}
	}
	@SuppressWarnings("unused")
	private static void addSwitchCore(){
		ArrayList<Long> alc,alg;
		long cid,sid;
		Core c;
		//core:[Switch]
		for(Map.Entry<Long, Core> e:cores.entrySet()){
			cid=e.getKey();
			c=e.getValue();
			
			alg=graph.get(cid);
			alc=c.getNearestSwitches();
			
			alg.addAll(alc);
			graph.put(cid, alg);
		}
		for(Map.Entry<Long, Switch> e:switches.entrySet()){
			sid=e.getKey();
			cid=Utilities.getRegionalCoreId(sid);
			alg=graph.get(sid);
			alg.add(cid);
			graph.put(sid, alg);
		}
	}
}
