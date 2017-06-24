package commons;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Driver {
	public static void main(String[] args) throws InvalidFormatException, IOException {
		int test=5;
		int[] users=new int[]{100}; //,400,500,600,700,800,900,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,20000,30000,40000,50000
		int[] packets=new int[]{1000,2000,3000};
		int[] velocity=new int[]{5,10,15};
		boolean model=false;
		for(int t=1;t<=test;t++){
			Input.reset();
			Input.setSequencNumber(t);
			System.out.println("Test case : "+t);
			for(int u=0;u<users.length;u++){
				System.out.println("\t#user index: "+u);
				Input.setNumUSERS(users[u]);
				Database.reset();
				//Allocates memory and assigns their respective parameters
				Allocator.locateCores();
				Allocator.locateSwitches();
				Allocator.locateUsers();
				Allocator.pickInterestedUsers();
				
				for(int p=0;p<packets.length;p++){
					System.out.println("\t\t#packet index: "+p);
					Input.setNumPACKETS(packets[p]);
					
					for(int v=0;v<velocity.length;v++){
						System.out.println("\t\t\tvelocity index :"+v);
						Input.setVelocity(velocity[v]);
						for(int m=0;m<2;m++){
							model=!model;
							if(model){
								Input.setModel("waypoint");
								RelocateUsers_Waypoint.relocate();
								System.out.println("executing Waypoint model");
								System.out.println("\t\t\t\tRunning lsbt model");
								lsbt.Controller.control();
//								System.out.println("\t\t\t\tRunning mobility model");
//								mobility.Controller.control();
//								System.out.println("\t\t\t\tRunning oversubscription model");
//								blo.Controller.control();
								
								
							}
							else{
								Input.setModel("markov");
								RelocateUsers_Markov.relocate();
								System.out.println("executing markov model");
								System.out.println("\t\t\t\tRunning lsbt model");
								lsbt.Controller.control();
//								System.out.println("\t\t\t\tRunning mobility model");
//								mobility.Controller.control();
//								System.out.println("\t\t\t\tRunning oversubscription model");
//								blo.Controller.control();
							}
						}
						
							
						
//						HashMap<Long,Switch> hm=Database.getSwitches();
//						for(Switch s:hm.values()){
//							System.out.println(s.getId()+" "+s.getConnectedUser().toString());
//						}
						
						//relocating users
						
					} // velocity loop ends
				}  //packets loop ends
			} // users loop ends
		} // test loop ends
	}
}
