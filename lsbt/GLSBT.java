package lsbt;
import commons.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public abstract class GLSBT {
	public static ArrayList<Double> generateTree(int r){

		ArrayList<User> nodes=new ArrayList<>();
		nodes.addAll(DBlsbt.getNodes());
		
		int numTotalNodes=nodes.size();
		for(User n:nodes){
			n.setDegree(n.getCapacity()/r);
		}
		Collections.sort(nodes,new Sorting());
		double hopCount,distanceTravelled,transmissionTime,energySpent,distSquare,tempDistance,delay;
		hopCount=distanceTravelled=transmissionTime=energySpent=distSquare=delay=0;
		
		int pos=0,size,j,k,numChild;
		pos++;
		Queue<User> queue =new LinkedList<>();
		queue.add(nodes.get(0));
		User poppedNode,childNode;
		int height=0;
		while(!queue.isEmpty()){
			height++;
			size=queue.size();
			for(j=0;j<size;j++){
				poppedNode=queue.remove();
				numChild=poppedNode.getDegree();
				for(k=0;k<numChild;k++){
					if(pos>=numTotalNodes)
						break;
					childNode=nodes.get(pos);
					pos++;
					queue.add(childNode);
					hopCount++;
					tempDistance=Utilities.calculateDistance(poppedNode.getID(),childNode.getID());
					distanceTravelled+=tempDistance;
					distSquare+=(tempDistance)*(tempDistance);
				}
			}
		}
		ArrayList<Double> res=new ArrayList<>();
		transmissionTime=distanceTravelled/(3*100000000);
		delay=(transmissionTime+(0.078125*r)); // transmission+propagation delay (for packet size 800Mb)
		//0 - hopCounts ; 1- distanceTravelled 3- Transmisson Time 4- Energy Spent 5 - delay
		energySpent=Database.ENERGYCONSTANT*distSquare;
		res.add(hopCount);
		res.add(distanceTravelled);
		res.add(transmissionTime/height);
		res.add(energySpent);
		res.add(delay);
		res.add((double) nodes.size());
		return res;
		
	}
}
