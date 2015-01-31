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
		S = new Sensors();
		angle = S.readgy();
		elevator = new Victor(4);
		solenoid1 = new Relay(5);
		solenoid2 = new Relay(6);
		
	}
	
	public void DriveMec(double[] axis){
	
		drv.mecanumDrive_Cartesian(axis[1], axis[0], axis[2], S.readgy());
		System.out.println(angle);
		
	}

}
