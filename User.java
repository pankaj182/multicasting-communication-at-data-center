package iitkgp;

/**
 * User class is an entity with its attributes,getters and setters.
 * A User is the end host with unique identifier, which will have its characterstic
 *  like upload and download capacity,residual energy. </p>
 * @since  27/05/2017 Saturday
 * @author pankaj
 * @location Indian Institute of Technology, Kharagpur
 */
public class User {
	
	private  int uploadCapacity;
	private  int downloadCapacity;
	private double resenergy;
	private   int id;
	private boolean status;
	/**
	 * Parameterized Cosntructor to initialize the attributes with passed parameters
	 * @param id : the unique identity of the node
	 * @param  uploadCapacity : stores the node's uploading capacity.
	 * @param downloadCapacity : stores the nodes's download capacity.
	 * @param resenergy :it stands for residual energy.
	 *  It is initially at its maximum value when no packet transfer is taking place.
	 * @param status : a boolean variable which stores the information whether
	 *  it is used by other nodes to receive data or not.
	 */
	User(int id, int uploadCapacity, int downloadCapacity, double energy){
		setUploadCapacity(uploadCapacity);
		setDownloadCapacity(downloadCapacity);
		this.id=id;
		setEnergy(energy);
		status=false;
	}
	
	/**
	 * Default constructor
	 * initializing with default value of 0 ,0.0 ,null or  false accordingly.
	 */
	User(){
		uploadCapacity=0;
		downloadCapacity=0;
		status=false;
		resenergy=0.0;
	}
	
	/**
	 * Getter method to get the unique ID of this User Node
	 * @return id : the ID of the node
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * Getter method to get the uploading capacity of the Node
	 * @return integer 
	 */
	public int getUploadCapacity() {
		return uploadCapacity;
	}
	
	/**
	 * Setter method to set the uploading capacity of the Node
	 * @param  to set the uploading Capacity of node.
	 * @return void 
	 */
	public  void setUploadCapacity(int upload) {
		uploadCapacity = upload;
	}
	
	/**
	 * Getter method to get the downloading capacity of the Node
	 * @return integer 
	 */
	public int getDownloadCapacity() {
		return downloadCapacity;
	}
	
	/**
	 * Setter method to set the downloading capacity of the Node
	 * @param downloadCapacity : to set the downloading Capacity of node.
	 * @return void 
	 */
	public void setDownloadCapacity(int downloadCapacity) {
		this.downloadCapacity = downloadCapacity;
	}
	
	/**
	 * Getter method to return the residual Energy of this Node.
	 * @return residual Energy.
	 * @see Transmission
	 */
	public double getEnergy() {
		return resenergy;
	}
	
	/**
	 * Setter method to set residual energy. The energy of the node decreses while transmission of packets
	 * @param energy : to set the residual energy of the node.
	 * @see Transmission#deliver()
	 */
	public void setEnergy(double energy) {
		this.resenergy = energy;
	}
	
	/**
	 * Getter method to return the usability status of the node. 
	 * Return true if this node has been earlier for transferring packts.
	 *  If so, it has high chances of being selected for packet transmission again. 
	 *  It returns false in other case.
	 * @return Boolean Value
	 */
	public boolean getUsabilityStatus() {
		// TODO Auto-generated method stub
		return status;
	}
	
	/**
	 * Setter method to set the usability status of the node.
	 * It is set to true if this node is used earlier for transmission of packet,
	 *  else it is set to false.
	 */
	public void setUsabilityStatus() {
		// TODO Auto-generated method stub
		status=true;
	}

}
