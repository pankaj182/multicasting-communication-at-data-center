package lsbt;
import commons.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public abstract class Controller {
	public static void control() throws InvalidFormatException, IOException{
		Result.reset();
		
		if(generateNodes()){
			int lowR,highR;
			double distanceTravelled,transmissionTime,energySpent,hopCounts,delay,succ;
			lowR=DBlsbt.getLowerBound();
			highR=DBlsbt.getUpperBound();
			hopCounts=0;
			transmissionTime=Double.MAX_VALUE;
			ArrayList<Double> res;
			for(int j=lowR;j<=highR;j++){
				res=GLSBT.generateTree(j);
				
				hopCounts=res.get(0);
				distanceTravelled=res.get(1);
				transmissionTime=res.get(2);
				energySpent=res.get(3);
				delay=res.get(4);
				succ=res.get(5);
				if(distanceTravelled>Result.getDistance()){
					Result.setDistance(distanceTravelled);
					Result.setHopCount(hopCounts);
					Result.setTransmissionTime(transmissionTime);
					Result.setEnergySpent(energySpent);
					Result.setDelay(delay);
					Result.setSuccessfulNodes((int)succ*Input.getVelocity()/2);
				}
			}
		}
		else{
			Result.setDistance(0);
			Result.setHopCount(0);
			Result.setTransmissionTime(0);
			Result.setEnergySpent(0);
			Result.setDelay(0);
			Result.setSuccessfulNodes(0);
		}
		OutputWriter.write();
	}
	private static boolean generateNodes(){
		HashMap<Long,User> users=new HashMap<>();
				users.putAll(Database.getUsers());
		User u=users.get(Database.getSourceId());
		Long sid=u.getParentSwitch();
		Switch s=Database.getSwitches().get(sid);
//		System.out.println(s.toString());
		ArrayList<Long> nodeId=null;
		nodeId=s.getConnectedUser();
		
		if(nodeId.size()==0){
			return false;
		}
		else{
			ArrayList<User> nodes=new ArrayList<>();
			for(Long id:nodeId){
				User us=users.get(id);
				nodes.add(us);
			}
			DBlsbt.setNodes(nodes);
			int num=nodes.size();
			int max=Integer.MIN_VALUE;
			int sumCapacity=0,cap;
			for(User n:nodes){
				cap=n.getCapacity();
				sumCapacity+=cap;
				if(cap>max)
					max=cap;
			}
			if(num==1){
				DBlsbt.setLowerBound(1);
				DBlsbt.setUpperBound(sumCapacity);
			}
			else{
				DBlsbt.setLowerBound(max/(num-1));
				DBlsbt.setUpperBound(sumCapacity/(num-1));
			}
			return true;
		}
	}
	
}
