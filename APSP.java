package iitkgp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class APSP {
	//private static void apsp
	static HashMap<Integer,ArrayList<Integer>> graph=Database.getGraph();
	static HashMap<Integer,User> users=Database.getUsersList();
	static HashMap<Integer,Integer> totalHops=new HashMap<>();
	private static HashMap<Integer,HashMap<Integer,Integer>> shortestPath=new HashMap<>();
	public static  void apsp(){
		for(Integer u:users.keySet()){
			shortestPath.put(u,bfs(u));
		}
		Database.setShortestPath(shortestPath);
		Database.setTotalHops(totalHops);
	}
	private static HashMap<Integer,Integer> bfs(Integer u) {
		// TODO Auto-generated method stub
		Queue<Integer> queue=new LinkedList<Integer>();
		HashMap<Integer,Integer> hm=new HashMap<>();
		HashMap<Integer,Boolean> visited=new HashMap<>();
		ArrayList<Integer> al;
		queue.add(u);
		int sum=0;
		int i,v,size,count=0;
		while(!queue.isEmpty()){
			size=queue.size();
			for(i=0;i<size;i++){
				v=queue.remove();
				visited.put(v,true);
				if(users.containsKey(v)){
					sum+=count;
					hm.put(v, count);
				}
				al=graph.get(v);
				for(Integer x:al){
					if(!visited.containsKey(x))
						queue.add(x);
				}
			}
			count++;
		}
		totalHops.put(u, sum);
		return hm;
	}
}