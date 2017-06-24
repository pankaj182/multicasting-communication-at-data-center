package mobility;

abstract class Result {

	/*
	 * @param distance : total distance travelled by all packets
	 * @param hops     : the total hops all packets have made
	 * @param energy   : the total energy spent while transmiting all packets
	 * @param sumDelay : sum of the delay between each hop.
	 */
	private static double distance=0;
	private static long hops=0;
	private static double energy=0;
	private static double sumDelay=0;
	
	// increases the distance by dis
		public static void increaseDistance(double dis){
			setDistance(distance+dis);
		}
		
		public static double getDistance() {
			return distance;
		}

		
		public static void setDistance(double distance) {
			Result.distance = distance;
		}
		
		public static long getHops() {
			return hops;
		}
		
		public static void setHops(long hops) {
			Result.hops = hops;
		}
		
		// increase the #hops by i
		public static void increaseHops(long i){
			setHops(hops+i);
		}
		
		//increase energy by d units
		public static void increaseEnergy(double d) {
			setEnergy(energy+d);
		}
		
		public static double getEnergy() {
			return energy;
		}
		
		public static void setEnergy(double energy) {
			Result.energy = energy;
		}
		
		public static double getSumDelay() {
			return sumDelay;
		}

		public static void setSumDelay(double sumDelay) {
			Result.sumDelay = sumDelay;
		}
		
		//increase the delay by d units
		public static void increaseSumDelay(double d) {
			setSumDelay(sumDelay+d);
		}
}
