package iitkgp;

import java.util.ArrayList;
/**
 * @since     27/05/2017 Saturday
 * @author   pankaj
 * @location Indian Institute of Technology, Kharagpur
 * <h3>Description</h3>
 * <p>This class is an entity holding details of a switch such as the maximum number of ports and the nodes which are directly connected to it.</p>
 * @see Switch#isInPortFree()
 * @see Switch#isOutPortFree()
 * @see Switch#connectToNode(Node)
 */
public class Switch {
	private final int capacity=Utilities.PORTS;
	private ArrayList<Node> ininterfaces,outinterfaces;
	/**
	 * @param capacity denotes maximum number of nodes that can connect to this switch
	 * @param interfaces is a List which contains all connected nodes to the switch
	 */
	Switch(){
		ininterfaces=new ArrayList<>(capacity/2);
		outinterfaces=new ArrayList<>(capacity/2);
	}
	
	
	/**
	 * This method returns the boolean value to indicate whether a port of a switch is free or not to be connected to node.
	 * @return true if a port is free i.e used ports <capacity
	 * else returns false
	 */
	public boolean isInPortFree(){
		return !(ininterfaces.size()==capacity/2);
	}
	/**
	 * This method returns the boolean value to indicate whether a port of a switch is free or not to be connected to Cores Switches.
	 * @return true if a port is free i.e used ports <capacity
	 * else returns false
	 */
	public boolean isOutPortFree(){
		return !(outinterfaces.size()==capacity/2);
	}
	
	
	/**
	 * @param node referes to the node to be connected to this switch
	 * @return a boolean value
	 * <p>returns true if node is successfully connected else returns false
	 * @see Switch#InisPortFree()
	 */
	public boolean connectToNode(Node node){
		if(isInPortFree()){
			ininterfaces.add(node);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * This method returns the Integer value denoting the number of free ports of the switch
	 * @return Integer : number of free ports
	 */
	public int freeInPorts(){
		return capacity-ininterfaces.size();
	}
}

