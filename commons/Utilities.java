package commons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Utilities {
	
	public static int[] rand(int min,int max,int n,boolean unique){
		int[] result=new int[n];
		if(!unique){
			for(int i =0;i<n;i++){
				result[i]=rand(min,max);
			}
		}
		else{
			/*
			 * Add each number in the range sequentially in a list structure.
			 * Shuffle it.
			 * Take the first n numbers.
			 * Assumption : n is less than the width of range.
			 * x represents the x coodinate ,
			 * y represents the y coordinate
			 */
			ArrayList<Integer> al=new ArrayList<>();
			for(int x=0;x<max;x++){
				for(int y=0;y<max;y++)
				al.add(x*100+y);
			}
			Collections.shuffle(al);
			for(int i=0;i<n;i++){
				result[i]=al.get(i);
			}
		}
		return result;
	}
	
	/**
	 * <p>this utility method returns random numbers in range[0,max]</p>
	 * @param max the range's upper bound
	 * @return a random number from a range of 0 to max
	 * @see java.util.Random
	 */
	@SuppressWarnings({ "unused","null" })
	private static int rand(int max){
		Random rand = null;
	    int randomNum = rand.nextInt((max - 0) + 1);
	    return randomNum;
	}
	
	
	public static int rand(int min,int max){
		return ThreadLocalRandom.current().nextInt(min, max+1); // second parameter is exclusive
	}
	public static long rand(long min,long max){
		return ThreadLocalRandom.current().nextLong(min, max); // second parameter is exclusive
	}
	public static ArrayList<Long> getRandomUsers(int n){
		ArrayList<Long> usersList=new ArrayList<>();
		int usersRequired=n;
		int usersCount=0;
		long nextId,idx,idy;
		while(usersCount<usersRequired){
			idx=rand(0l,20000l);
			idy=rand(0l,20000l);
			nextId=idx*100000+idy;
			if(!usersList.contains((Long)nextId)){
				usersList.add(nextId);
				usersCount++;
			}
		}
		return usersList;
	}
	public static double calculateDistance(Long i,Long j){
		long ix,iy,jx,jy;
		double ans;
		ix=i/100000;
		iy=i%100000;
		jx=j/100000;
		jy=j%100000;
		ans=(Math.sqrt((ix-jx)*(ix-jx)+(iy-jy)*(iy-jy)));
		return ans;
	}
	/**
	 * This method calculates the utility value required for Cooperation
	 * @param user1 : instance of User class
	 * @param user2 : instance of User class
	 * @param s     : instance of Switch class
	 * @param totaldis : Total distance from source to the sender .
	 * @return double : utility value
	 */
	public static double calculateUtility(User user1,User user2,Switch s,double totaldis){
		int mu;
		double mindis;
		mindis=Utilities.calculateDistance(s, user1);
		totaldis=totaldis+mindis;
		mindis+=Utilities.calculateDistance(s, user2);
//		double resEnergy=user1.getEnergy();
//		double maxEnergy=Input.getEnergy();
		boolean previouslyUsed = user1.isEarlierUsed();
		if(previouslyUsed) mu=1;
		else mu=0;
		double utility=-(mindis/totaldis)+mu;
		return utility;
	}
	public static long findNearestSwitch(User u) {
		HashMap<Long,Switch> switches=Database.getSwitches();
		double dist,mindist=Integer.MAX_VALUE;
		long reqId = u.getID();
		for(Map.Entry<Long,Switch> s:switches.entrySet()){
			Switch sw=s.getValue();
			dist=Math.sqrt((u.getX()-sw.getX())*(u.getX()-sw.getX())+(u.getY()-sw.getY())*(u.getY()-sw.getY()));
			if(dist<mindist){
				mindist=dist;
				reqId=s.getKey();
			}
		}
		return reqId;
	}
	
	
	/**
	 * Since the cores are fixed. and Each core is divided in a region.
	 * Hence we can find the IDs of the Core switch of that region
	 * If the point belong to region X, we return core Id present in region X
	 * @param id : the id of the Node for which we need to find the nearest core
	 * @return Long  : the core Id
	 */
	public static long getRegionalCoreId(long id){
		long idx,idy,corex,corey,coreId;
		idx=id/100000;
		idy=id%100000;
		corex=2000+(idx/4000)*4000;
		corey=2000+(idy/4000)*4000;
		coreId=corex*100000+corey;
		return coreId;
	}
	/**
	 * Returns the distance between a User and a Switch
	 * @param s  : instance of Switch class
	 * @param u  : instance of User class
	 * @return distance between the two.
	 * @see Switch
	 * @see User
	 */
	public static double calculateDistance(Switch s,User u){
		long sx,sy;
		double ux,uy,dis;
		sx=s.getX(); sy=s.getY();
		ux=u.getX(); uy=u.getY();
		dis=Math.sqrt((sx-ux)*(sx-ux)+(sy-uy)*(sy-uy));
		return dis;
	}
}

