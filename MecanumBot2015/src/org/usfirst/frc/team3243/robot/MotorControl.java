package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;

public class MotorControl {
	
	//Create Motor objects here.
	//protected static RobotDrive drv;//creates an instance of the frc class RobotDrive called drv
	//private static Sensors S;//instance of the class Sensors
	protected static double angle;//angle
	protected static Victor elevator;//motor in charge of elevator
	protected static  Solenoid solenoid1, solenoid2;//solenoid motors
	protected static Talon topleft, bottomright, bottomleft, topright;
	protected static Compressor comp;
	
	//static double[] drive= new double[4];
	
	public MotorControl(){
		
	//	drv = new RobotDrive(0,1,2,3);//constructor 
		topleft = new Talon(0);
		bottomleft = new Talon(1);
		topright = new Talon(2);
		bottomright = new Talon(3);
	//	S = new Sensors();//instance of sensors is created
	//	angle = S.readgy();//calls upon the lass readgy which is located in sensors
		elevator = new Victor(4);
		solenoid1 = new Solenoid(0);
		solenoid2 = new Solenoid(1);
		comp = new Compressor(0);
		
		
	}

	public double[] finaldrv(double[] driv){
		double[] drive = new double[4]; 
		drive[0] = (driv[0] * .75) + (driv[1] * .75) - (driv[2]);
		drive[1] = (driv[0] * .75) + (driv[1] * .75) + (driv[2]);
		drive[2] = -(driv[0] * .75) + (driv[1] * .75) + (driv[2]);
		drive[3] = -(driv[0] * .75) + (driv[1] * .75) - (driv[2]);//This part of the function goes positive or negative based upon the movement each motor does in a given situation. Paper with where MArk worked this out should be with the project sheet.
		return drive;
		
	}
	
public void driveomni(double[] driv){
		finaldrv(driv);
			topleft.set(driv[0]);
			bottomright.set(driv[1]);
			bottomleft.set(driv[2]);
			topright.set(driv[3]);
		
	}
	public void getGrabberMethod(double[] solenoidInput){//if open is pressed
		if(solenoidInput[0] == 1 && solenoidInput[1] == 0){
			solenoid1.set(true);
			solenoid2.set(false);
			
		}
		if (solenoidInput[0] == 0 && solenoidInput[1] == 1){//if close is pressed
			solenoid1.set(false);
			solenoid2.set(true);
		}
	}
	public void Elevate(double[] elev){
		elevator.set(elev[0]);//Raises/lowers the elevator.
	}
	public void Compress(){
		if(comp.getPressureSwitchValue()==true){
			comp.start();
		}else if(comp.getPressureSwitchValue()==false){
			comp.stop();
		}
	}
	
	
}
