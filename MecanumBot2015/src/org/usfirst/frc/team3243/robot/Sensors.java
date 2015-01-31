package org.usfirst.frc.team3243.robot;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.vision.AxisCamera;


public class Sensors {
	protected static AxisCamera cam;//declare our camera
	protected static Gyro G;//our gyro

	public Sensors(){
		
		G = new Gyro(3);//port of the gyro
		cam = new AxisCamera("10.32.43.9");//ip adress of the axis camera 
	}

	public double readgy(){
		
		double fin = G.getAngle();//frc class that allows us to get the angle
		
		return fin;
	}
	
}
