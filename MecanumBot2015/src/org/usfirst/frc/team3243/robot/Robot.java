
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
	
    public void robotInit() {
    	IM = new InputManager();//IM is the master instance of input manager
    	MC = new MotorControl();//MC is the master instance of motor control
   
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	MC.DriveMec(IM.getFinalAxis());//in order to drive
    	IM.grabber();
        MC.getGrabberMethod(IM.grabber());//grabber functions ater a button is pressed
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
