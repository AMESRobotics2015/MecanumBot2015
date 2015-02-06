package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.*;

public class MotorControl {
	
	//Create Motor objects here.
	protected static RobotDrive drv;//creates an instance of the frc class RobotDrive called drv
	private static Sensors S;//instance of the class Sensors
	protected static double angle;//angle
	protected static Victor elevator;//motor in charge of elevator
	protected static  Solenoid solenoid1, solenoid2;//solenoid motors
	//protected static Talon topleft, topright, bottomleft, bottomright;
	
	static double[] drv= new double[4];
	
	public MotorControl(){
		
		drv = new RobotDrive(0,1,2,3);//constructor 
		/*topleft = new Talon(0);
		topright = new Talon(1);
		bottomleft = new Talon(2);
		bottomright = new Talon(3);*/
		S = new Sensors();//instance of sensors is created
		angle = S.readgy();//calls upon the lass readgy which is located in sensors
		elevator = new Victor(4);
		solenoid1 = new Solenoid(1);
		solenoid2 = new Solenoid(2);
		
	}
	
	public void DriveMec(double[] axis){
		
		/*finaldrv(driv);
		
		topleft.set(drv[0]);
		topright.set(drv[1]);
		bottomleft.set(drv[2]);
		bottomright.set(drv[3]);*/
		drv.mecanumDrive_Cartesian(axis[1], axis[0], axis[2], S.readgy());//frc class to allow driving
		System.out.println(angle);//to see if the gyro works
		
	}
	/*public double[] finaldrv(double[] driv){
		
		drv[0] = (driv[0] * .75) - (driv[1] * .75) + (driv[2]);
		drv[1] = ((driv[0] * .75) + driv[1] * .75 + (driv[2])) * .96;
		drv[2] = -(driv[0] * .75) + (driv[1] * .75) + (driv[2]);
		drv[3] = (-(driv[0] * .75) - (driv[1] * .75) + (driv[2])) * .96;
		return drv;
		
	}*/
	public void getGrabberMethod(double[] solenoidInput){//if open is pressed
		if(solenoidInput[0] == 1 && solenoidInput[1] == 0){
			solenoid1.set(true);
			solenoid2.set(false);
			
		}
		if (solenoidInput[1] == 0 && solenoidInput[1] == 1){//if close is pressed
			solenoid1.set(false);
			solenoid2.set(true);
		}
	}
	public void Elevate(double[] elev){
		elevator.set(elev[0]);
	}

}
