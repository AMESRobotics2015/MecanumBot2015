package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;

public class MotorControl {
	
	//Create Motor objects here.
	protected static RobotDrive drv;//creates an instance of the frc class RobotDrive called drv
	private static Sensors S;//instance of the class Sensors
	protected static double angle;//angle
	protected static Victor elevator;//motor in charge of elevator
	protected static Relay solenoid1, solenoid2;//solenoid motors
	
	public MotorControl(){
		
		drv = new RobotDrive(0,1,2,3);//constructor 
		S = new Sensors();//instance of sensors is created
		angle = S.readgy();//calls upon the lass readgy which is located in sensors
		elevator = new Victor(4);
		solenoid1 = new Relay(5);
		solenoid2 = new Relay(6);
		
	}
	
	public void DriveMec(double[] axis){
	
		drv.mecanumDrive_Cartesian(axis[1], axis[0], axis[2], S.readgy());//frc class to allow driving
		System.out.println(angle);//to see if the gyro works
		
	}
	public void getGrabberMethod(double[] solenoidInput){//if open is pressed
		if(solenoidInput[0] == 1 && solenoidInput[1] == 0){
			solenoid1.set(Relay.Value.kForward);
			solenoid2.set(Relay.Value.kOff);
			
		}
		if (solenoidInput[1] == 0 && solenoidInput[1] == 1){//if close is pressed
			solenoid1.set(Relay.Value.kOff);
			solenoid2.set(Relay.Value.kForward);
		}
	}

}
