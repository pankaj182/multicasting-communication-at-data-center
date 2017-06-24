package commons;


public abstract class NodeFactory {
	
	public static User getUser(long id,int cap){
		return new User(id,cap); 
	}
	
	
	public static Switch getSwitch(long switchId){
		return new Switch(switchId);
	}
	
	public static Core getCore(long coreId){
		return  new Core(coreId);
	}
}
