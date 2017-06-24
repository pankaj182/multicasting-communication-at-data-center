package commons;

import java.util.HashMap;
import java.util.Map;

public abstract class RelocateUsers_Waypoint{
	
	public static void relocate(){
		HashMap<Long,User> users=Database.getUsers();
		HashMap<Long,Switch> switches=Database.getSwitches();
		double x,y;
		int v=Input.getVelocity();
		for(Map.Entry<Long,User> i:users.entrySet()){
			User u=i.getValue();
			x=u.getX();
			y=u.getY();
			x=(x+v*Math.cos(u.getAngle()));
			y=(y+v*Math.sin(u.getAngle()));
			u.setX(x);
			u.setY(y);
			
		}
		Database.setUsers(users);
		Database.setSwitches(switches);
	}
}