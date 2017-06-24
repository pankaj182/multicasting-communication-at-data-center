package lsbt;

import java.util.ArrayList;

import commons.*;

public class DBlsbt {
	private static ArrayList<User> nodes;
	private static int lowerBound,upperBound;
	public static ArrayList<User> getNodes() {
		return nodes;
	}
	public static void setNodes(ArrayList<User> nodes) {
		DBlsbt.nodes = nodes;
	}
	public static int getLowerBound() {
		return lowerBound;
	}
	public static void setLowerBound(int lowerBound) {
		DBlsbt.lowerBound = lowerBound;
	}
	public static int getUpperBound() {
		return upperBound;
	}
	public static void setUpperBound(int upperBound) {
		DBlsbt.upperBound = upperBound;
	}
}
