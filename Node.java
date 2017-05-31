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
public class Node {
	
	private int uploadCapacity,downloadCapacity;
	/**
	 * Parameterized Cosntructor to initialize the attributes with passed parameters
	 * @param  uploadCapacity : stores the node's uploading capacity.
	 * @param downloadCapacity : stores the nodes's download capacity.
	 */
	Node(int uploadCapacity,int downloadCapacity){
		this.setUploadCapacity(uploadCapacity);
		this.setDownloadCapacity(downloadCapacity);
	}
	
	/**
	 * Default constructor
	 * initializing with default value of 0
	 */
	Node(){
		uploadCapacity=0;
		downloadCapacity=0;
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
	public void setUploadCapacity(int uploadCapacity) {
		this.uploadCapacity = uploadCapacity;
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
}
