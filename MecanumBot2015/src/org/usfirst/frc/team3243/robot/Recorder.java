package org.usfirst.frc.team3243.robot;

import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.io.*;


public class Recorder implements java.io.Serializable {
	ArrayList<Double> Data0 = new ArrayList<Double>();//creates 3 object-specific arraylists
	ArrayList<Double> Data1 = new ArrayList<Double>();
	ArrayList<Double> Data2 = new ArrayList<Double>();	
	ArrayList<Double> ElevData = new ArrayList<Double>();//gets joystick input for elevator
	ArrayList<Double> GrabberData0 = new ArrayList<Double>();	
	ArrayList<Double> GrabberData1 = new ArrayList<Double>();
	static transient Timer stopRecord= new Timer(); //creates timer object to stop recording after 15 seconds
	static transient int counter = Reader.getCounter();//sets value of recording counter to the last recording value
	static transient int planNumber = 1;//number of plan to execute on playback
	static transient boolean isRead= false;//checks to see if the file was correctly read
	static transient boolean startRecord = false;
	static transient boolean writeToFile =false;
	public static boolean isRecording = false;
	public static int playIncrement=0;
	public static boolean clearData = false;
	public static boolean timerOn = false;
	transient InputManager IM = new InputManager();
	
	private class recordingTimer extends TimerTask{//creates task to run after15 seconds

		@Override
		public void run() {
			
			isRecording = false;//stops recording
			startRecord = false;			
			writeToFile = true;
			System.out.println("timer ran");
		}
		
	}	
	
	public void getDriveData(double[] drive, double[] elevator, double[] solenoid){//gets data from joystick array
		
		IM.record();
		if(clearData){//clears data if not already cleared
			this.Data0.clear();
			this.Data1.clear();
			this.Data2.clear();
			this.ElevData.clear();
			this.GrabberData0.clear();
			this.GrabberData1.clear();
			clearData = false;//stops clearing of data
		}else if (isRecording /*&& startRecord */){//starts recording if button is pressed and joystick has been changed
			
		this.Data0.add(drive[0]);//records data to static arraylists
		this.Data1.add(drive[1]);
		this.Data2.add(drive[2]);
		this.ElevData.add(elevator[0]);
		this.GrabberData0.add(solenoid[0]);
		this.GrabberData1.add(solenoid[1]);
		//this.ElevData.add(array[3]);
		if (timerOn){//starts timer if told to do so
			stopRecord.schedule(new recordingTimer(), 15000);//schedules stop in 15 seconds     
			timerOn = false;//stops timer
			System.out.println("timer started");
			}
		}
		
	}
	
	
	
	public double[] playBackDrive(){//plays back recording		
		double[]playArray = new double[3];
		if(playIncrement > this.Data0.size()-1){//if it keeps reading larger than the size for any reason, this stops the robot
			playArray[0]=0;
			playArray[1]=0;
			playArray[2]=0;
			
		}else
		{
			playArray[0]=this.Data0.get(playIncrement);//sets array elements to saved ones
			playArray[1]=this.Data1.get(playIncrement);
			playArray[2]=this.Data2.get(playIncrement);			
			++playIncrement;//increments element of arraylist
		}		
		return playArray;
		}
		public double[] playBackElevator(){
			double[]playArray = new double[3];
			if(playIncrement > this.ElevData.size()-1){//if it keeps reading larger than the size for any reason, this stops the robot
				playArray[0]=0;
				
			}else
			{
				playArray[0]=this.ElevData.get(playIncrement);		
			}	
			return playArray;			
		}
		public double[] playBackGrabber(){
			double[]playArray = new double[2];
			if(playIncrement > this.GrabberData0.size()-1){//if it keeps reading larger than the size for any reason, this stops the robot
				playArray[0]=0;
				playArray[1]=0;
				
				
			}else
			{
				playArray[0]=this.GrabberData0.get(playIncrement);//sets array elements to saved ones
				playArray[1]=this.GrabberData1.get(playIncrement);
			}	
			return playArray;
		}
}
