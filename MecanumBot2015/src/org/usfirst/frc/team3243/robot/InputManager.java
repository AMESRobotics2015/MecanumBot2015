package org.usfirst.frc.team3243.robot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.RobotDrive.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class InputManager extends Robot{
		static double[] axis = new double [4];//holds the input value from our left/right controllers
		static double[] solenoidInput = new double [2];//holds input for the solenoid motors
		static double[] gameaxis = new double [2];
		protected static Joystick ps2controller;//our controller
		protected static Joystick gameController;
		protected static JoystickButton open;
		protected static JoystickButton close;
		protected static JoystickButton record;
		//initializes the controller
		public InputManager() {
			
			ps2controller = new Joystick(0);//driving joystick
			gameController = new Joystick(1);//gampiece joystick
			open = new JoystickButton(gameController, 2);
			close = new JoystickButton(gameController, 3);
			record = new JoystickButton(ps2controller, 4);
			//rampUpNum = int
			
		}
		/**
		 * 
		 * It retrieves the getAxisValue class's values, deadzones, and then it calls the ramp method, which regresses it to be a cubu=ic function rather than a line
		 * @return
		 */
		
		public double [] getFinalAxis(double gyro){//If we switch to FRC function take out the double in the function argument - If we use backup throw double Gyro in there.
			return (ramp(adjustGetAngle(gyro)));
			//return (ramp(getAxisValue()));
			//three things happen in this class.
			//1)you get axis values
			//2)then you deadzone the values
			//3) You transform the deadzoned values into a cubic equation
		}
		
		public double [] adjustGetAngle(double angle){
			double controllerangle = 0;
			double mag;
			
			axis[0] = ps2controller.getRawAxis(3);// y axis
			axis[1] = ps2controller.getRawAxis(2);// x axis
			axis[3] = ps2controller.getRawAxis(0);//rotation.
			deadZone(axis);//deadzones the values.
		/*	
			if(axis[1] < 0){
				controllerangle = Math.PI + Math.atan(axis[0]/axis[1]);//get the angle that the joystick is pointing facing, in case the angle is in the second or third quadrant
			}else{
				controllerangle = Math.atan(axis[0]/axis[1]);//get angle if it's in the first or fourth quadrant
			}
			*/
			controllerangle = Math.atan2(axis[0],axis[1]);//agnle joystick is at
			mag = Math.sqrt(Math.pow(axis[0], 2)*Math.pow(axis[1], 2));//find magnitude of controller
			
			axis[1] = mag*Math.cos(angle+controllerangle); // using the equation kole gave where our final inputs include MAGNITUDE
			axis[0] = mag*Math.sin(angle+controllerangle); 
			
			
			return axis;
		}
		
		public static double[] getAxisValue(){
			
			axis[0] = ps2controller.getRawAxis(1);//y axis 
			axis[1] = ps2controller.getRawAxis(0);//x axis
			axis[2] = ps2controller.getRawAxis(2);//pivioting
			//axis[3] = gameController.getRawAxis(1);
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
				axis[x] = (0.6667 * (Math.pow(axis[x], 3))+(0.333 * axis[x]));//ramps tthe function and returns it to getFinalAxis
			}
			return (axis);
		}
		public static double[] grabber(){
			if(open.get() == true){//if open or close is pressed store info into an array with respective information
				solenoidInput[0]= 1;
				solenoidInput[1] = 0;
			}
			if(close.get() == true){
				solenoidInput[0] = 0;
				solenoidInput[1] = 1;
			}
			return solenoidInput;//return the array
		}
		
		public static double[] elevatorInput(){
			gameaxis[0] = gameController.getRawAxis(3);//y axis 
			//gameaxis[1] = gameController.getRawAxis(2);//x axis -- we don't need this...
			gameaxis = ramp(deadZone(gameaxis));//transforms the array to deadzone to round values as necessary (ex. -0.03 to 0)
			return gameaxis;
		}
		public void record() {
			if(record.get() == true){
				Recorder.isRecording = true;
				System.out.println("Successful button press");
				Recorder.timerOn = true;
			}
			
		}

	}


