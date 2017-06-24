package commons;
import java.util.ArrayList;

public class User {
	
	private long ID;
	private int capacity;
	private int degree;
	private double x,y;
	private long parent;
	private long parentSwitch;
	private ArrayList<User> children;
	private long connectedSwitch;
	private boolean interested;
	private boolean usedStatus;
	private int downloadCapacity,uploadCapacity;
	User(long ID,int capacity){
		setID(ID);
		setX(ID/100000);
		setY(ID%100000);
		setCapacity(capacity);
		setParentSwitch(0l);
		children=new ArrayList<>();
	}
	/**
	 * @return the iD
	 */
	public long getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(long iD) {
		ID = iD;
	}
	public boolean isInterested() {
		return interested;
	}

	/**
	 * @param interested the interested to set
	 */
	public void setInterested(boolean interested) {
		this.interested = interested;
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x2 the x to set
	 */
	public void setX(double x2) {
		this.x = x2;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y2 the y to set
	 */
	public void setY(double y2) {
		this.y = y2;
	}
	/**
	 * @return the parent
	 */
	public long getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(long parent) {
		this.parent = parent;
	}
	/**
	 * @return the children
	 */
	public ArrayList<User> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(ArrayList<User> children) {
		this.children = children;
	}
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
		setDownloadCapacity(setUploadCapacity(capacity));
	}
	/**
	 * @return the degree
	 */
	public int getDegree() {
		return degree;
	}
	/**
	 * @param degree the degree to set
	 */
	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	public long getParentSwitch() {
		return parentSwitch;
	}
	public boolean isEarlierUsed() {
		return usedStatus;
	}
	public void setEarlierUsed() {
		usedStatus=true;
	}
	public void setParentSwitch(long parentSwitch) {
		this.parentSwitch = parentSwitch;
	}
	public double getAngle() {
		return Utilities.rand(0, 359);
	}
	public long isConnectedTo() {
		return connectedSwitch;
	}
	public void setConnectedTo(long sid) {
		connectedSwitch=sid;
		setParentSwitch(sid);
	}
	public int getDownloadCapacity() {
		return downloadCapacity;
	}
	public void setDownloadCapacity(int downloadCapacity) {
		this.downloadCapacity = downloadCapacity;
	}
	public int getUploadCapacity() {
		return uploadCapacity;
	}
	public int setUploadCapacity(int uploadCapacity) {
		this.uploadCapacity = uploadCapacity;
		return uploadCapacity;
	}
}
