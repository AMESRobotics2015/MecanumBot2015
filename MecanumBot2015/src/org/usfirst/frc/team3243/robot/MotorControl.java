package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;

public class MotorControl {
	
	//Create Motor objects here.
	protected static RobotDrive drv;
	private static Sensors S;
	protected static double angle;
	protected static Victor elevator;
	protected static Relay solenoid1, solenoid2;
	
	public MotorControl(){
		
		drv = new RobotDrive(0,1,2,3);
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
