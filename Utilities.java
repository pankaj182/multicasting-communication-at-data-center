package iitkgp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @since     27/05/2017 Saturday
 * @author   pankaj
 * @location Indian Institute of Technology, Kharagpur
 * <h3>Description</h3>
 * <p>This class provides basic utilities which might be required in some operations.</p>
 * @see Utilities#rand(int)
 * @see Utilities#rand(int, int)
 * @see Utilities#rand(int, int, int, boolean)
 * @see Utilities#setPorts(int)
 */
public class Utilities {
	
	static int PORTS=8;
	/**<h3>Description</h3>
	 * This method is used to set the number of ports a switch can have.
	 * i.e it will restricts the number of users that can connect to a switch.
	 * @param ports Integer mentioning the number of ports in a switch
	 */
	public static void setPorts(int ports){
		PORTS=ports;
	}
	
	/**
	 * <p>this utility method returns random numbers in range[0,max]</p>
	 * @param max the range's upper bound
	 * @return a random number from a range of 0 to max
	 * @see java.util.Random
	 */
	@SuppressWarnings({ "unused", "null" })
	public static int rand(int max){
		Random rand = null;
	    int randomNum = rand.nextInt((max - 0) + 1);
	    return randomNum;
	}
	
	/**
	 * This utility method returns a single random number in range [min,max]
	 * @param min : range's lower bound
	 * @param max :the range's upper bound
	 * @return a random integer in range[min,max]
	 * @see ThreadLocalRandom
	 */
	@SuppressWarnings({ "null" })
	public static int rand(int min,int max){
		ThreadLocalRandom tr = null;
		return tr.nextInt(min, max+1); // second parameter is exclusive
	}
	
	/**
	 * This function returns an array of random numbers in a given range.
	 * @param min    :  range's lower bound
	 * @param max    : the range's upper bound
	 * @param n      : number of random values required
	 * @param unique :  to check whether random numbers generated can repeat or not
	 * 				<p> if <code>true</code>, then all random numbers generated will be unique</p>
	 * 				<p><code>else</code> random numbers may not be unique.
	 * @return array of n random integers in the range [min,max]
	 */
	@SuppressWarnings("unused")
	public static int[] rand(int min,int max,int n,boolean unique){
		int[] result=new int[n];
		if(!unique){
			for(int i =0;i<n;i++){
				result[i]=rand(min,max);
			}
		}
		else{
			/*
			 * Add each number in the range sequentially in a list structure.
			 * Shuffle it.
			 * Take the first n numbers.
			 * Assumption : n is less than the width of range
			 */
			ArrayList<Integer> al=new ArrayList<>();
			for(int i=min;i<=max;i++){
				al.add(i);
			}
			Collections.shuffle(al);
			for(int i=0;i<n;i++){
				result[i]=al.get(i);
			}
		}
		return result;
	}
}

