package commons;

/**
 * This class contains parameters which are feeded as Input to Simulation.
 * This class cannot be instantiated.
 * @since June 7 2017 
 * @author pankaj
 * @location IITKGP
 */
public abstract class Input {
	/*
	 * @param numUSERS : number of users in the network
	 * @param numSWITCHES : number of switches in the network
	 * @param numCORES    : number of Core switches in the network
	 * @param numPACKETS  : number of packets to be transmitted
	 */
//	public static double LOSSRATE ;
	private static int numUSERS;
	private static final int numSWITCHES=100;
	private static final int numCORES=25;
	private static int numPACKETS;
	private static int numInterestedUsers;
	private static int velocity;
	private static int seq;
	private static String model;
	
	public static int getNumUSERS() {
		return numUSERS;
	}
	
	public static void setNumUSERS(int numUSERS) {
		Input.numUSERS = numUSERS;
	}
	public static int getNumPACKETS(){
		return numPACKETS;
	}
	public static void setNumPACKETS(int num){
		numPACKETS=num;
	}
	
	public static int getNumCORES() {
		return numCORES;
	}
	
	public static int getNumSWITCHES() {
		return numSWITCHES;
	}

	public static int getNumInterestedUsers() {
		return numInterestedUsers;
	}

	public static void setNumInterestedUsers(int numInterestedUsers) {
		Input.numInterestedUsers = numInterestedUsers;
	}

	public static void setVelocity(int i) {
		velocity=i;
	}
	public static int getVelocity() {
		return velocity;
	}

	public static int getSequenceNumber() {
		return seq;
	}

	public static void setSequencNumber(int seq) {
		Input.seq = seq;
	}

	public static void reset() {
		seq=0;
		numUSERS=0;
		numPACKETS=0;
		numInterestedUsers=0;
		velocity=0;
	}

	public static String getModel() {
		return model;
	}

	public static void setModel(String model) {
		Input.model = model;
	}
}
