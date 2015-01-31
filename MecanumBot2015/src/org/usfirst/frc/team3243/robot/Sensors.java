package org.usfirst.frc.team3243.robot;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.vision.AxisCamera;


public class Sensors {
	protected static AxisCamera cam;
	protected static Gyro G;

	public Sensors(){
		
		G = new Gyro(3);
		cam = new AxisCamera("10.32.43.9");
	}

	public double readgy(){
		
		double fin = G.getAngle();
		
		return fin;
	}
	
}
