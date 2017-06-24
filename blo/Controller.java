package blo;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import commons.Input;

public class Controller {
	public static void control() throws InvalidFormatException, IOException{
		Result.reset();
		MakeMulticastTree.makeTree();
		int numPackets=Input.getNumPACKETS();
		Transmission[] obj=new Transmission[numPackets];
		for(int k=0;k<numPackets;k++){
			obj[k]=new Transmission();
		}
		for(int k=0;k<numPackets;k++){
			obj[k].start();
		}
		OutputWriter.write();
	}
}
