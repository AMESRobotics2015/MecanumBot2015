package org.usfirst.frc.team3243.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.RobotDrive.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class InputManager extends Robot{
		static double[] axis = new double [4];//holds the input value from our left/right controllers
		static double[] solenoidInput = new double [2];//holds input for the solenoid motors
		protected static Joystick ps2controller;//our controller
		protected static Joystick gameController;
		protected static JoystickButton open;
		protected static JoystickButton close;
		//initializes the controller
		public InputManager() {
			
			ps2controller = new Joystick(1);
			gameController = new Joystick(2);
			open = new JoystickButton(gameController, 2);
			close = new JoystickButton(gameController, 3);
			//rampUpNum = int
			
		}
		/**
		 * 
		 * It retrieves the getAxisValue class's values, deadzones, and then it calls the ramp method, which regresses it to be a cubu=ic function rather than a line
		 * @return
		 */
		public double [] getFinalAxis(){
			return (ramp(getAxisValue()));
			//three things happen in this class.
			//1)you get axis values
			//2)then you deadzone the values
			//3) You transform the deadzoned values into a cubic equation
		}
		
		public static double[] getAxisValue(){
			
			axis[0] = ps2controller.getRawAxis(1);//y axis 
			axis[1] = ps2controller.getRawAxis(0);//x axis
			axis[2] = ps2controller.getRawAxis(2);//pivioting
			axis[3] = gameController.getRawAxis(1);
			axis = deadZone(axis);//transforms the array to deadzone to round values as necessary (ex. -0.03 to 0)
			return axis;
			
			
		}
		
		/**
		 * transforms the array to deadzone to round values as necessary (ex. 0.02 to 0)
		 * @param axis
		 * @return
		 */
		public static double[] deadZone(double[] axis){
			for (int i = 0; i< axis.length; i++){
				if ((axis[i] <= 0.05) && (axis[i] >= -0.05)) {//i will iterate to 0,1,2 since axis array size is 3
					axis[i] = 0;//if the condition is satisfies, round it to zero
				}
			}
			return axis;
		}
		
		public static double[] ramp(double[] axis){
			for(byte x = 0; x < 3 ; x++){
				axis[x] = (0.6667 * (Math.pow(axis[x], 3))+(0.333 * axis[x]));
			}
			return (axis);
		}
		public void grabber(){
			if(open.get() == true){
				solenoidInput
				//solenoid1.set(Relay.Value.kForward);
				//solenoid2.set(Relay.Value.kOff);
			}
			if(close.get() == true){
				solenoid1.set(Relay.Value.kOff);
				solenoid2.set(Relay.Value.kForward);
			}
		}

	}


