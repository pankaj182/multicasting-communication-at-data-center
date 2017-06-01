package iitkgp;

public abstract class NodeFactory {
	public static User getUser(int id,int u,int d){
		return new User(id,u,d);
	}
	public static Switch getSwitch(int id){
		return new Switch(id);
	}
	public static Core getCore(int id){
		return  new Core(id);
	}
}
