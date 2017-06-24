package commons;
import java.util.ArrayList;
/**
 * This class contains parameters of a Switch.
 * This class can be instantiated, for every single instance will denote a single Switch
 * @since June 7 2017 
 * @author pankaj
 * @location IITKGP
 */
public class Switch {
	private long ID;
	private long x,y;
	private boolean interested;
	private ArrayList<Long>  usersConnected;
	private ArrayList<Long> interestedUsers;
	/**
	 * @param id :  the id Of the switch
	 * @param x : the x coordinate of Switch's location
	 * @param y : the y coordinate of Switch's location
	 * @param interestedUsers : list of all interestedUsers
	 * @param usersConnected : list of all connected Users
	 */
	Switch(long id){
		this.ID=id;
		setX(ID/100000);
		setY(ID%100000);
		usersConnected=new ArrayList<>();
		interestedUsers=new ArrayList<>();
	}
	public void addConnection(Long id){
		usersConnected.add(id);
	}
	
	/**
	 * To remove a connection , while relocating
	 * @see RelocateUsers_Waypoint
	 * @param id : ID of the user which is to be relocated
	 */
	public void removeConnection(Long id){
		if(usersConnected.contains(id))
			usersConnected.remove(id);
	}
	/**
	 * add a user in the list of interested user
	 * @param id : user ID
	 */
	public void addInterestedUser(Long id){
		interestedUsers.add(id);
	}
	/**
	 * To remove a user from the list of interested users
	 * @param id
	 */
	public void removeInterestedUser(Long id){
		interestedUsers.remove(id);
	}
	/**
	 * returns the list of interested users
	 */
	public ArrayList<Long> getInterestedUser(){
		return interestedUsers;
	}
	/**
	 * returns the list of connected users
	 */
	public ArrayList<Long> getConnectedUser(){
		return usersConnected;
	}
	
	public  void setConnectedUser(ArrayList<Long> al){
		usersConnected=al;
	}
	
	public long getX() {
		return x;
	}
	
	public void setX(long x) {
		this.x = x;
	}
	
	public long getY() {
		return y;
	}
	
	public void setY(long y) {
		this.y = y;
	}
	public Long getId() {
		return ID;
	}
	
	public boolean isInterested() {
		return interested;
	}
	
	public void setInterested(boolean interested) {
		this.interested = interested;
	}
}
