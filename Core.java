package iitkgp;

import java.util.ArrayList;

/**
 * <p>This class is an entity holding details of a Core Switch such as the maximum number of ports
 *  and the switches which are directly connected to it.
 * Each core has its own unique identifier.
 * @since     31/05/2017 Wednesday
 * @author   pankaj
 * @location Indian Institute of Technology, Kharagpur
 * @see Core#isPortFree()
 * @see Core#connect(Switch)
 * @see Core#getId()
 * @see Switch
 * @see User
 */

public class Core {
	
	private final int capacity=Database.getPORTS();
	private int id;
	private ArrayList<Integer> interfaces;
	
	/**
	 * @param capacity denotes maximum number of Switches that can connect to this Core switch
	 * @param interfaces is a List which contains all connected switches to the core
	 * @param id denotes the unique identifier of an instance of Core.
	 * @see GraphMaker#makeGraph()
	 */
	Core(int id){
		interfaces=new ArrayList<>(capacity);
		this.id=id;
	}
	
	/**
	 * This is a getter method which returns the identity of this core switch.
	 * @return Integer : the assigned unique identity.
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * This method returns the boolean value to indicate whether a port of a core switch is free or not.
	 * @return true if a port is free i.e ( used ports < capacity )
	 * else returns false
	 */
	public boolean isPortFree(){
		return !(interfaces.size()==capacity);
	}
	
	/**
	 * @param switc referes to the switch to be connected to this core switch
	 * @return a boolean value
	 * <p>returns true if switch is successfully connected else returns false
	 * @see Core#isPortFree()
	 */
	public boolean connect(Integer switchId){
		if(isPortFree()){
			interfaces.add(switchId);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * This method returns the Integer value denoting the number of free ports of the Core switch
	 * @return Integer : number of free ports
	 */
	public int freePorts(){
		return capacity-interfaces.size();
	}
}

