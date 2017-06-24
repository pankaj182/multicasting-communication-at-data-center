package mobility;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import commons.Input;

public class Controller {
	public static void control() throws InvalidFormatException, IOException{
		MakeMulticastTree.makeTree();
		resetResult();
		// array of instances of transmission class, each time its called, a packet is sent
		int numPackets=Input.getNumPACKETS();
		Transmission[] obj=new Transmission[numPackets];
		for(int k=0;k<numPackets;k++){
			obj[k]=new Transmission();
		}
		for(int k=0;k<numPackets;k++){
			obj[k].start();
		}
		
		// to write output to a file
		OutputWriter.write();
	}

	private static void resetResult() {
		Result.setDistance(0);
		Result.setEnergy(0);
		Result.setHops(0);
		Result.setSumDelay(0);
	}
}
