package iitkgp;

import java.util.Comparator;

public class PairSorting implements Comparator<Pair> {

	public int compare(Pair o1, Pair o2) {
		// TODO Auto-generated method stub
		if(o1.dist<o2.dist) return -1;
		else if(o1.dist>o2.dist) return 1;
		else return 0;
	}
}
