package lsbt;
import commons.*;

import java.util.Comparator;

public class Sorting implements Comparator<User> {

	@Override
	public int compare(User a, User b) {
		if(a.getCapacity()<b.getCapacity()) return 1;
		else if(a.getCapacity()>b.getCapacity()) return -1; 
		else return 0;
	}

}
