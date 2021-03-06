package org.usfirst.frc.team3243.robot;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class Writer implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int outputCounter = 0;
	FileOutputStream FileOut;
	ObjectOutputStream fileout;
	public void writeData(Recorder r){//writes data to file
		try
	     {
			
			
			try {
				 FileOut = new FileOutputStream("/home/lvuser/auto/Recording " + Recorder.counter + ".JSON");//outputs recording and # to a json
		         fileout = new ObjectOutputStream(FileOut);
		         fileout.writeObject(r);//writes recorder object to file
		         fileout.close();
		         Recorder.writeToFile = false;
				++Recorder.counter;//increments # of recording
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	     }finally{
				if(FileOut !=null){
					try {
						FileOut.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}if(fileout !=null){
					try {
						fileout.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
	}
	         
	       
	public void setCounter(){
		
		FileOutputStream counterOut;
		try {
			outputCounter = Recorder.counter;
			counterOut = new FileOutputStream("/home/lvuser/auto/Counter.JSON");
	         ObjectOutputStream counterFile = new ObjectOutputStream(counterOut);
	         counterFile.writeObject(outputCounter);
	         counterFile.close();
	         counterOut.close();
		} catch (FileNotFoundException e) {		
			
		}catch(IOException i){}
    
	}
	
}
