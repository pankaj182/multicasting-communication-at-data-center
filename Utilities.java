package iitkgp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class provides basic utilities which might be required in some operations.
 * Functions like getting random numbers,getting random location(x,y) or getting random list of coordinates.</p>
 * @since     27/05/2017 Saturday
 * @author   pankaj
 * @location Indian Institute of Technology, Kharagpur
 * @see Utilities#rand(int)
 * @see Utilities#rand(int, int)
 * @see Utilities#rand(int, int, int, boolean)
 * @see Utilities#setPorts(int)
 * @see GraphMaker
 */
public class Utilities {
	
	/**
	 * This function returns an array of random numbers in a given range.
	 * Each number represents a coordinate.
	 * e.g. 1234
	 * then 1234/100 = 12 represents x-coordinate
	 * and  1234%100 = 34 represents y-coordinate
	 * hence if N=1234, it means (x,y)=(12,34)
	 * @param min    :  range's lower bound
	 * @param max    : the range's upper bound
	 * @param n      : number of random values required
	 * @param unique :  to check whether random numbers generated can repeat or not
	 * 				<p> if <code>true</code>, then all random numbers generated will be unique</p>
	 * 				<p><code>else</code> random numbers may not be unique.
	 * @return array of n random integers in the range [min,max]
	 * @see Utilities#rand(int,int)
	 */
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
			 * Assumption : n is less than the width of range.
			 * x represents the x coodinate ,
			 * y represents the y coordinate
			 */
			ArrayList<Integer> al=new ArrayList<>();
			for(int x=0;x<max;x++){
				for(int y=0;y<max;y++)
				al.add(x*100+y);
			}
			Collections.shuffle(al);
			for(int i=0;i<n;i++){
				result[i]=al.get(i);
			}
		}
		return result;
	}
	
	/**
	 * <p>this utility method returns random numbers in range[0,max]</p>
	 * @param max the range's upper bound
	 * @return a random number from a range of 0 to max
	 * @see java.util.Random
	 */
	@SuppressWarnings({ "unused","null" })
	private static int rand(int max){
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
	private static int rand(int min,int max){
		ThreadLocalRandom tr = null;
		return tr.nextInt(min, max+1); // second parameter is exclusive
	}
}

