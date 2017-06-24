package lsbt;

abstract class Result {
	private static double distance;
	private static double hopCount;
	private static double transmissionTime;
	private static double energySpent;
	private static double delay;
	private static double successfulNodes;
	
	public static void reset(){
		setTransmissionTime(0);
		setDelay(0);
		getSuccessfulNodes();
		setDistance(0);
		setEnergySpent(0);
		setHopCount(0);
	}
	public static double getDistance() {
		return distance;
	}
	public static void setDistance(double distance) {
		Result.distance = distance;
	}
	public static double getHopCount() {
		return hopCount;
	}
	public static void setHopCount(double hopCounts) {
		Result.hopCount = hopCounts;
	}
	public static double getTransmissionTime() {
		return transmissionTime;
	}
	public static void setTransmissionTime(double transmissionTime) {
		Result.transmissionTime = transmissionTime;
	}
	public static double getEnergySpent() {
		return energySpent;
	}
	public static void setEnergySpent(double energySpent) {
		Result.energySpent = energySpent;
	}
	public static double getDelay() {
		return delay;
	}
	public static void setDelay(double delay) {
		Result.delay = delay;
	}
	public static void setSuccessfulNodes(double succ) {
		successfulNodes=succ;
	}
	public static int getSuccessfulNodes() {
		return (int)successfulNodes;
	}
}
