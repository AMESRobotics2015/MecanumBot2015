package org.usfirst.frc.team3243.robot;

import edu.wpi.first.wpilibj.Gyro;

public class Sensors {
	
	protected static Gyro G;

	public Sensors(){
		
		G = new Gyro(3);
		
	}
	
	public double readgy(){
		
		double fin = G.getAngle();
		
		return fin;
	}
	
}
