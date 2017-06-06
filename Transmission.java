package iitkgp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public  abstract class Transmission {
	private static ArrayList<Integer> delivered=new ArrayList<>();
	private static HashMap<Integer,Integer> totalHops=Database.getTotalHops();
	private static HashMap<Integer,User> usersList=Database.getUsersList();
	private static HashMap<Integer,HashMap<Integer,Integer>> shortestPath=Database.getShortestPath();
	private static ArrayList<Integer> undelivered=new ArrayList<>();
	private static int sourceId=Database.getSourceId();
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	public static void deliver(){
		int countHops=0;
		HashMap<Integer,Integer> neighbours;
		delivered.add(sourceId);
		for(Integer i:usersList.keySet()){
			if(i.intValue()!=sourceId)
				undelivered.add(i);
//			System.out.println("loop id 0");
		}
		double temp,utility=0;
		int nextDestination = 0,nextSource=0;
		while(undelivered.size()>0){
			for(Integer i:delivered){
				temp=calculateUtility(usersList.get(i));
				if(temp>utility){
					utility=temp;
					nextSource=i;
				}
//				System.out.println("loop id 1");
			}
			
			neighbours=shortestPath.get(nextSource);
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			for(Map.Entry<Integer, Integer> i:neighbours.entrySet()){
				if(i.getValue()<min && undelivered.contains(i.getKey())){
					min=i.getValue();
					nextDestination=i.getKey();
				}
				if(i.getValue()>max)
					max=i.getValue();
//				System.out.println("loop id 2");
			}
			countHops+=min;
			User suser=usersList.get(nextSource);
			User duser=usersList.get(nextDestination); 
			suser.setUsabilityStatus();
			suser.setEnergy(suser.getEnergy()*(1-(min/max)*(min/max)));
			undelivered.remove((Integer)nextDestination); // casting , otherwise it assumes as an index, not object
			delivered.add(nextDestination);
//			System.out.println("loop id 3");
		}
		System.out.println("Hop count= "+countHops);
	}
	private static double calculateUtility(User user){
		HashMap<Integer,Integer> neighbours=shortestPath.get(user.getId());
		int mu,hop,tHops;
		hop=Integer.MAX_VALUE;
		tHops=totalHops.get(user.getId());
		double resEnergy=user.getEnergy();
		double maxEnergy=Database.getEnergy();
		boolean previouslyUsed = user.getUsabilityStatus();
		if(previouslyUsed) mu=1;
		else mu=0;
		for(Integer i:neighbours.values()){
			if(i<hop)
				hop=i;
		}
		double utility=(resEnergy/maxEnergy)+(hop/tHops)+mu;
		return utility;
	}
}
