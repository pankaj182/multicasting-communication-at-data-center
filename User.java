package iitkgp;
/**
 * @since  27/05/2017 Saturday
 * @author pankaj
 * @location Indian Institute of Technology, Kharagpur
 * <h3>Description</h3>
 * <p>
 * Nodes class is an entity with its attributes,getters and setters.
 * A Node is the end users which will have its fixed characterstic upload and download capacity. </p>
 */
public class User {
	
	private  int uploadCapacity;
	private  int downloadCapacity;
	private double resenergy;
	private   int id;
	private boolean status=false;
	/**
	 * Parameterized Cosntructor to initialize the attributes with passed parameters
	 * @param  uploadCapacity : stores the node's uploading capacity.
	 * @param downloadCapacity : stores the nodes's download capacity.
	 */
	User(int id,int uploadCapacity,int downloadCapacity,double energy){
		setUploadCapacity(uploadCapacity);
		setDownloadCapacity(downloadCapacity);
		this.id=id;
		setEnergy(energy);
	}
	
	/**
	 * Default constructor
	 * initializing with default value of 0
	 */
	User(){
		uploadCapacity=0;
		downloadCapacity=0;
	}
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

	public double getEnergy() {
		return resenergy;
	}

	public void setEnergy(double energy) {
		this.resenergy = energy;
	}

	public boolean getUsabilityStatus() {
		// TODO Auto-generated method stub
		return status;
	}
	public void setUsabilityStatus() {
		// TODO Auto-generated method stub
		status=true;
	}

}
