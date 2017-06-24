package commons;
import java.util.HashMap;
import java.util.Map;

public abstract class RelocateUsers_Markov{
	
	public static void relocate(){
		HashMap<Long,User> users=Database.getUsers();
		HashMap<Long,Switch> switches=Database.getSwitches();
		double x,y,alpha=0.5,vector_v,dir,vm,dm;
		int v=Input.getVelocity();
		for(Map.Entry<Long,User> i:users.entrySet()){
			User u=i.getValue();
			x=u.getX();
			y=u.getY();
			vm=Utilities.rand(0,v);
			dm=u.getAngle();
			vector_v=alpha*vm+(1-alpha)*vm+Math.sqrt(1-(alpha*alpha))*v;
			dir=alpha*dm+(1-alpha)*dm+Math.sqrt(1-(alpha*alpha))*(2*Math.PI);
			x=(x+vector_v*Math.cos(dir));
			y=(y+vector_v*Math.sin(dir));
			u.setX(x);
			u.setY(y);
			
		}
		Database.setUsers(users);
		Database.setSwitches(switches);
	}
}