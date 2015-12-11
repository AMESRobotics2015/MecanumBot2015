
package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;

//Testing GitHub

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first star1ted up and should be
     * used for any initialization code.
     */
	
	//Example
	
	private static InputManager IM;
	private static MotorControl MC;
	private static Sensors S;
	private static Recorder R;
	private static Writer WR;
	private static MasterTimer T;
	private static Reader RE;
	private static RobotMap RM;
	
	

    public void robotInit() {
    	IM = new InputManager();//IM is the master instance of input manager
    	MC = new MotorControl();//MC is the master instance of motorcontrol
    	R = new Recorder();
    	WR = new Writer();
    	T = new MasterTimer();
    	T.Init();
    	T.Freset();
    	RE = new Reader();
    	//MC.forcestart();
    	RM = new RobotMap();
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	double velocity = 6.6;
    	double angularVelocity = 2.5;
    	MC.Move(3000, angularVelocity);
    	//MC.moveDegree(360);
    	/**MC.moveDistance(10);
    	MC.moveDegree(90);
    	MC.moveDistance(10);
    	MC.moveDegree(-90);
    	//To do: fire
    	MC.moveDegree(-90);
    	MC.moveDistance(10);
    	MC.moveDegree(-90);
    	MC.moveDistance(10);
    	//To do: reload
    	MC.moveDegree(-90);
    	MC.moveDistance(10);
    	MC.moveDegree(-90);
    	//Fire
    	MC.moveDegree(-90);
    	MC.moveDistance(10);
    	//Reload
    	MC.moveDegree(-90);
    	MC.moveDistance(10);
    	MC.moveDistance(-90);
    	MC.moveDistance(10);
    	MC.moveDistance(-90);
    	//Fire
    	MC.moveDistance(10);
    	MC.moveDegree(-90);
    	MC.moveDistance(10);
    	//Done**/
    	MC.CompressorCheck();
    	//CalibrateDrive();    	
    	/*
    	if(!Recorder.isRead){
    		RE.readData(R);
    	}
    	MC.driveomni(R.playBackDrive(),IM.getwat(11));
    	MC.getGrabberMethod(R.playBackGrabber());
    	MC.Elevate(R.playBackElevator());
    	*/
    }
    
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	//double gyangle = S.gyread();
    	//System.out.println(T.gdt(1));
    	if(T.gdt(1) >= .2 && IM.getAdamButton()){
			T.sc(1);
			IM.togAdamButton();
		}
    	//MC.driveomni(IM.adjustGetAngle(gyangle));
    	MC.driveomni(IM.getAxisValue(),IM.getwat(8));
    	//System.out.println("Closed loop?: " + MC.comp.getClosedLoopControl());
    	//if(!MC.comp.getClosedLoopControl()){
    	MC.Compress(MC.Elevate(IM.elevatorInput()));
    //	}
    //	else{
    //		MC.Elevate(IM.elevatorInput());
    	//}
    	//IM.adjustGetAngle(gyangle);
    	//MC.DriveMec(IM.getFinalAxis(gyangle)); //Driving for FRC function.
    	//IM.grabber(); - I don't think we need that here.
        MC.getGrabberMethod(IM.grabber());//grabber functions ater a button is pressed
        //sends input from joystick to elevator function in motor control.
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	double gyangle = S.gyread();
    	//System.out.println("Are we even running?");
    	MC.driveomni(IM.getAxisValue(),IM.getwat(11));
    	//MC.DriveMec(IM.getFinalAxis(gyangle)); //Driving for FRC function.
        MC.getGrabberMethod(IM.grabber());//grabber functions ater a button is pressed
        MC.Elevate(IM.elevatorInput());//sends input from joystick to elevator function in motor control.
    	R.getData(IM.getAxisValue(), IM.elevatorInput(), IM.grabber());
	//	}
		if(Recorder.writeToFile){
			WR.writeData(R);
			WR.setCounter();
		}
    }
    
}
