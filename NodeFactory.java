package iitkgp;
/**
 * This abstract class is a factory class used to return instance of a class.
 * Since it an abstract class, Hence it can't be instantiated.
 * @since 02/06/2017
 * @author pankaj
 * @location Indian Institute of Technology,Kharagpur
 * @see Switch
 * @see Core
 * @see User
 * @see NodeFactory#getUser(int, int, int)
 * @see NodeFactory#getSwitch(int)
 * @see NodeFactory#getCore(int)
 * @see GraphMaker#makeGraph()
 */
public abstract class NodeFactory {
	
	/**
	 * This method return instance of a User class. The parameters defines the characterstics of a user.
	 * @param id The identity given to a user.The location is its ID= 100*x+y
	 * @param u The uploading capacity of a user
	 * @param d the downloading capacity of the user.
	 * @return instance of User class
	 * @see User
	 * @see Utilities : for logic for ID allocation
	 * Energy is the initial energy of a Node.
	 * It can be modified in Database class.
	 * @see Database
	 */
	public static User getUser(int id,int u,int d){
		return new User(id,u,d,Database.getEnergy());
	}
	
	/**
	 * This method is used to return instance of Switch class
	 * @param id The identity given to a switch.The location is its ID= 100*x+y
	 * @return instance of Switch class
	 * @see Switch
	 * @see Utilities#rand(int, int, int, boolean)
	 */
	public static Switch getSwitch(int id){
		return new Switch(id);
	}
	
	/**
	 * This method is used to return instance of Core class
	 * @param id The identity given to a core.The location is its ID= 100*x+y
	 * @return instance of Core class.
	 * @see Core
	 * @see Utilities#rand(int, int, int, boolean) see this for ID allocation logic
	 */
	public static Core getCore(int id){
		return  new Core(id);
	}
}
