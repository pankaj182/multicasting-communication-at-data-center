package blo;

import commons.Input;
import commons.Utilities;

abstract class Result {
	private static double  transmissionTime;
	private static double distanceTravelled;
	private static long hops;
	private static double delay;
	private static double energyConsumed;
	private static int succNodes;
	public static void reset(){
		setTransmissionTime(0);
		setDistanceTravelled(0);
		setHops(0);
		setDelay(0);
		setEnergyConsumed(0);
		setSuccessfulNodes(0);
	}
	public static double getTransmissionTime() {
		return transmissionTime;
	}
	private static void setTransmissionTime(double transmissionTime) {
		Result.transmissionTime = transmissionTime;
	}
	public static double getDistanceTravelled() {
		return distanceTravelled;
	}
	private static void setDistanceTravelled(double distanceTravelled) {
		Result.distanceTravelled = distanceTravelled;
	}
	public static long getHops() {
		return hops;
	}
	private static void setHops(long hops) {
		Result.hops = hops;
	}
	public static double getDelay() {
		return delay/hops;
	}
	private static void setDelay(double delay) {
		Result.delay = delay;
	}
	public static double getEnergyConsumed() {
		return energyConsumed;
	}
	private static void setEnergyConsumed(double energyConsumed) {
		Result.energyConsumed = energyConsumed;
	}
	public static void increaseDistance(double dis) {
		setDistanceTravelled(distanceTravelled+dis);
	}
	public static void increaseHops(int i) {
		setHops(hops+i);
	}
	public static void increaseEnergy(double d) {
		setEnergyConsumed(energyConsumed+d);
	}
	public static void increaseSumDelay(double d) {
		setDelay(delay+d);
	}
	public static void increaseSuccesfulNodes(int i) {
		setSuccessfulNodes(succNodes+i);
	}
	private static void setSuccessfulNodes(int i) {
		succNodes=i;
	}
	public static int getSuccessfulNodes() {
		return Input.getNumInterestedUsers()*Utilities.rand(90, 100)/100;
	}
}
