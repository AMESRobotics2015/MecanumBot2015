package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;

public class MotorControl {
	
	//Create Motor objects here.
	protected static RobotDrive drv;
	
	public MotorControl(){
		
		drv = new RobotDrive(0,1,2,3);
		
	}
	
	public void DriveMec(double[] axis){
		
		drv.mecanumDrive_Polar(magnitude, direction, rotation);
		
	}

}
