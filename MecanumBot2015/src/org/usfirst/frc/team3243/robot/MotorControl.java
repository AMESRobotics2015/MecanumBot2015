package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;

public class MotorControl {
	
	//Create Motor objects here.
	protected static RobotDrive drv;
	private static Sensors S;
	
	public MotorControl(){
		
		drv = new RobotDrive(0,1,2,3);
		S = new Sensors();
		
	}
	
	public void DriveMec(double[] axis){
	
		drv.mecanumDrive_Cartesian(axis[1], axis[0], axis[2], S.readgy());
		
	}

}
