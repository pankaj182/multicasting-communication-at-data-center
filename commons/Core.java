package commons;
import java.util.ArrayList;
/**
 * This class contains parameters of a Core switch.
 * This class can be instantiated, for every single instance will denote a single Core switch
 * @since June 7 2017 
 * @author pankaj
 * @location IITKGP
 */
public class Core {
	private long Id;
	private long x,y;
	private ArrayList<Long> switchesConnected;
	private boolean interested;
	
	/**
	 * @param id :  the id Of the Core switch
	 * @param x : the x coordinate of Core Switch's location
	 * @param y : the y coordinate of Core Switch's location
	 * @param interested : if interested or not
	 * @param switchesConnected : list of all connected Switches
	 */
	Core(long ID){
		this.Id=ID;
		setX(ID/100000);
		setY(ID%100000);
		switchesConnected=new ArrayList<>();
		setInterested(false);
	}
	
	public void addNearestSwitch(long sid) {
		switchesConnected.add(sid);
	}
	
	public ArrayList<Long> getNearestSwitches() {
		return switchesConnected;
	}
	
	public boolean isInterested() {
		return interested;
	}
	
	public void setInterested(boolean interested) {
		this.interested = interested;
	}
	
	public long getY() {
		return y;
	}
	
	public void setY(long y) {
		this.y = y;
	}
	
	public long getX() {
		return x;
	}
	
	public void setX(long x) {
		this.x = x;
	}
	
	public long getId() {
		return Id;
	}
	
	public void setId(long id) {
		Id = id;
	}
}
