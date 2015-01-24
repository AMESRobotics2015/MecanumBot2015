package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;

public class MotorControl {
	
	//Create Motor objects here.
	protected static RobotDrive drv;
	protected static Gyro G;
	
	public MotorControl(){
		
		drv = new RobotDrive(0,1,2,3);
		G = new Gyro(3);
		
	}
	
	public void DriveMec(double[] axis){
	
		drv.mecanumDrive_Cartesian(axis[1], axis[0], axis[2], G.getAngle());
		
	}

}
