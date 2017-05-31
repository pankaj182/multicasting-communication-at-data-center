package iitkgp;

import java.util.ArrayList;

/**
 * @since     31/05/2017 Wednesday
 * @author   pankaj
 * @location Indian Institute of Technology, Kharagpur
 * <h3>Description</h3>
 * <p>This class is an entity holding details of a Core Switch such as the maximum number of ports and the switches which are directly connected to it.</p>
 * @see Core#isPortFree()
 * @see Core#connect(Switch)
 */
public class Core {
	


	private final int capacity=Utilities.PORTS;
	private ArrayList<Switch> interfaces;
	/**
	 * @param capacity denotes maximum number of Switches that can connect to this Core switch
	 * @param interfaces is a List which contains all connected switches to the core
	 */
	Core(){
		interfaces=new ArrayList<>(capacity);
	}
	
	
	/**
	 * This method returns the boolean value to indicate whether a port of a core switch is free or not.
	 * @return true if a port is free i.e used ports < capacity
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
	public boolean connect(Switch switc){
		if(isPortFree()){
			interfaces.add(switc);
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

