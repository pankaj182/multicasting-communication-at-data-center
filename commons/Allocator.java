package commons;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public abstract class Allocator {
	
	private static HashMap<Long, Core> cores=new HashMap<>();
	private static HashMap<Long, Switch> switches=new HashMap<>();
	private static HashMap<Long, User> users=new HashMap<>();
	public static void locateCores(){
		long coreId[]=new long[]{200002000l, 200006000l, 200010000l, 200014000l, 200018000l,
				600002000l, 600006000l, 600010000l, 600014000l, 600018000l,
				1000002000l, 1000006000l, 1000010000l, 1000014000l, 1000018000l,
				1400002000l, 1400006000l, 1400010000l, 1400014000l, 1400018000l,
				1800002000l, 1800006000l, 1800010000l, 1800014000l, 1800018000l };
		
		for(int i=0;i<25;i++){
			cores.put(coreId[i], NodeFactory.getCore(coreId[i]));
		}
		Database.setCores(cores);
	}
	
	public static void locateSwitches(){
		long switchId[]=new long[]{100001000l, 100003000l, 100005000l, 100007000l, 100009000l,
				100011000l, 100013000l, 100015000l, 100017000l, 100019000l,
				300001000l, 300003000l, 300005000l, 300007000l, 300009000l,
				300011000l, 300013000l, 300015000l, 300017000l, 300019000l,
				500001000l, 500003000l, 500005000l, 500007000l, 500009000l,
				500011000l, 500013000l, 500015000l, 500017000l, 500019000l,
				700001000l, 700003000l, 700005000l, 700007000l, 700009000l,
				700011000l, 700013000l, 700015000l, 700017000l, 700019000l,
				900001000l, 900003000l, 900005000l, 900007000l, 900009000l,
				900011000l, 900013000l, 900015000l, 900017000l, 900019000l,
				1100001000l, 1100003000l, 1100005000l, 1100007000l, 1100009000l,
				1100011000l, 1100013000l, 1100015000l, 1100017000l, 1100019000l, 
				1300001000l, 1300003000l, 1300005000l, 1300007000l, 1300009000l,
				1300011000l, 1300013000l, 1300015000l, 1300017000l, 1300019000l,
				1500001000l, 1500003000l, 1500005000l, 1500007000l, 1500009000l,
				1500011000l, 1500013000l, 1500015000l, 1500017000l, 1500019000l,
				1700001000l, 1700003000l, 1700005000l, 1700007000l, 1700009000l,
				1700011000l, 1700013000l, 1700015000l, 1700017000l, 1700019000l, 
				1900001000l, 1900003000l, 1900005000l, 1900007000l, 1900009000l, 
				1900011000l, 1900013000l, 1900015000l, 1900017000l, 1900019000l };
		
		long sid,coreId;
		Switch sw;
		for(int i=0;i<100;i++){
			sid=switchId[i];
			sw=NodeFactory.getSwitch(sid);
			sw.setConnectedUser(new ArrayList<>());
			switches.put(sid, sw);
			coreId=Utilities.getRegionalCoreId(sid);
			Core c= cores.get(coreId);
			c.addNearestSwitch(sid);
			cores.put(coreId, c);
		}
		Database.setSwitches(switches);
		Database.setCores(cores);
	}
	
	public static void locateUsers(){
		int usersCount=Input.getNumUSERS();
		ArrayList<Long> usersId=Utilities.getRandomUsers(usersCount);
		User u;
		Switch s;
		long nearestSwitch;
		ArrayList<Long> sal;
		for(int i=0;i<usersCount;i++){
			
			if(i<0.2*usersCount)       // 20% allocated capacity of 128
				u=NodeFactory.getUser(usersId.get(i),128);
			else if(i<0.6*usersCount)  // 40% allocated capacity of 384
				u=NodeFactory.getUser(usersId.get(i),384);
			else if(i<.85*usersCount)  // 25% allocated capacity of 1000
				u=NodeFactory.getUser(usersId.get(i),1000);
			else                        // rest 15% allocated capacity of 5000
				u=NodeFactory.getUser(usersId.get(i),5000);
			nearestSwitch=Utilities.findNearestSwitch(u);
			s=switches.get(nearestSwitch);
			
			sal=s.getConnectedUser();
			sal.add(u.getID());
			s.setConnectedUser(sal);
			
			u.setConnectedTo(s.getId());
			switches.put(s.getId(), s);
			users.put(u.getID(), u);
		}
		Database.setUsers(users);
		Database.setSwitches(switches);
	}
	public static void pickInterestedUsers(){
		ArrayList<Long> interestedUsers=new ArrayList<>();
		int numUsers=Input.getNumUSERS();
		// setting number of interested users to be in range [n/4,n]
		int numInterestedUsers=Utilities.rand(numUsers/4, numUsers);
		Input.setNumInterestedUsers(numInterestedUsers);
		
		int i=0;
		long uid;
		User u;
		Switch s;
		
		for(Map.Entry<Long, User> e:users.entrySet()){
			
			uid=e.getKey();
			u=e.getValue();
			
			if(i==numInterestedUsers)
				break;
			
			interestedUsers.add(uid);
			u.setInterested(true);
			
			s=switches.get(u.isConnectedTo()); // get the switch to which this user is connected
			s.setInterested(true);
			s.addInterestedUser(u.getID());
			switches.put(s.getId(), s);
			users.put(uid, u);
			
			i++;
		}
		Database.setUsers(users);
		Database.setInterestedUsers(interestedUsers);
		Database.setSourceId(interestedUsers.get(0)); // this sets up the sourceId
	}
}
