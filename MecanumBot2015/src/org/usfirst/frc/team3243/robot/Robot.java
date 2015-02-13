
package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	private static InputManager IM;
	private static MotorControl MC;
	private static Sensors S;
	private static Recorder R;
	private static Writer WR;
	private static MasterTimer T;
	
    public void robotInit() {
    	IM = new InputManager();//IM is the master instance of input manager
    	MC = new MotorControl();//MC is the master instance of motor control
    	S = new Sensors(); //S is the master instance of Sensors
    	R = new Recorder();
    	WR = new Writer();
    	T = new MasterTimer();
    	T.Init();
    	T.Freset();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	MC.driveomni(R.playBackDrive());
    	MC.getGrabberMethod(R.playBackGrabber());
    	MC.Elevate(R.playBackElevator());
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	double gyangle = S.gyread();
    	//System.out.println("Are we even running?");
    	MC.driveomni(IM.getAxisValue());
    	//MC.DriveMec(IM.getFinalAxis(gyangle)); //Driving for FRC function.
    	//IM.grabber(); - I don't think we need that here.
        MC.getGrabberMethod(IM.grabber());//grabber functions ater a button is pressed
        MC.Elevate(IM.elevatorInput());//sends input from joystick to elevator function in motor control.
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	double gyangle = S.gyread();
    	//System.out.println("Are we even running?");
    	MC.driveomni(IM.getAxisValue());
    	//MC.DriveMec(IM.getFinalAxis(gyangle)); //Driving for FRC function.
    	//IM.grabber(); - I don't think we need that here.
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
