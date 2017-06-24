package blo;
import commons.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class Transmission extends Thread {
	HashMap<Long,User> users=Database.getUsers();
	ArrayList<Long> interestedUsers=Database.getInterestedUsers();
	HashMap<Long,ArrayList<Long>> graph=Database.getGraph();
	HashMap<Long,Switch> switches=Database.getSwitches();
	HashMap<Long,Core> cores=Database.getCores();
	Long source=Database.getSourceId();
	public void run(){
		double dis;
		long sid=users.get(source).isConnectedTo();
		dis=Utilities.calculateDistance(switches.get(sid), users.get(source));
		
		Result.increaseHops(1);
		Result.increaseDistance(dis);
		Result.increaseEnergy(dis*dis);
		Result.increaseSumDelay(((dis /(3*100000000))+0.078125));
		toNearestSwitch(sid,dis);
	}

	private void toNearestSwitch(long sid,double dist) {
		long cid=Utilities.getRegionalCoreId(sid);
		double dis;
		
		dis=Utilities.calculateDistance(cid, sid);
		
		Result.increaseDistance(dis);
		Result.increaseHops(1);
		Result.increaseEnergy(dis*dis);
		Result.increaseSumDelay(((dis/(3*100000000))+0.078125));
		toNearestCore(cid,dist+dis);
	}

	private void toNearestCore(long cid,double dist) {
		long id;
		double dis;
		for(Map.Entry<Long, Core> e:cores.entrySet()){
			id=e.getKey();
			dis=Utilities.calculateDistance(cid, id);
			Result.increaseHops(1);
			Result.increaseDistance(dis);
			Result.increaseEnergy(dis*dis);
			Result.increaseSumDelay(((dis/(3*100000000))+0.078125));
			toAllCores(id,dist+dis);
		}
	}

	private void toAllCores(long cid,double dist) {
		Switch s;
		Core c;
		double dis;
		c=cores.get(cid);
		ArrayList<Long> nearestSwitches=c.getNearestSwitches();
		// if that switch is interested
		for(Long sid:nearestSwitches){
			s=switches.get(sid);
			if(s.isInterested()){
				dis=Utilities.calculateDistance(cid, sid);
				Result.increaseDistance(dis);
				Result.increaseHops(1);
				Result.increaseEnergy(dis*dis);
				Result.increaseSumDelay(((dis/(3*100000000))+0.078125));
				toSurroudingSwitches(s,dist+dis);
			}
		}
	}

	private void toSurroudingSwitches(Switch s,double totaldis) {
		//all operations here
		//upload download energy utility
		ArrayList<Long> delivered,undelivered;
		long nearestReceipient=0,sender = 0;
		double dis,mindis,util,minutil;
		undelivered=new ArrayList<>();
		delivered=new ArrayList<>();
		
		undelivered.addAll(s.getInterestedUser());
		delivered.add(undelivered.get(0));
		undelivered.remove(0);
		//System.out.println(undelivered.toString());
		while(!undelivered.isEmpty()){
			mindis=Integer.MAX_VALUE;
			for(Long uid:undelivered){
				dis=Utilities.calculateDistance(s,users.get(uid));
				if(dis<mindis){
					mindis=dis;
					nearestReceipient=uid;
				}
			}
			minutil=Integer.MAX_VALUE;
			for(Long uid:delivered){
//				System.out.println(uid);
				if(s==null ||users.get(uid)==null) break;
				dis=2*Utilities.calculateDistance(s,users.get(uid));
				util=Utilities.calculateUtility(users.get(uid), users.get(nearestReceipient), s, totaldis);
				if(util<minutil){
					minutil=util;
					sender=uid;
				}
			}
			undelivered.remove(nearestReceipient);
			delivered.add(sender);
			double temp=Utilities.calculateDistance(nearestReceipient,s.getId());
			Result.increaseDistance(temp);
			Result.increaseEnergy(temp*temp);
			Result.increaseHops(1);
			Result.increaseSumDelay(((temp/(3*100000000))+0.078125));
		}
	}
	

}
