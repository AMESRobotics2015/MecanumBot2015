package org.usfirst.frc.team3243.robot;

import com.ni.vision.NIVision.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.vision.*;

public class VisionProcessing {

	RobotMap r = new RobotMap();
	
	AxisCamera cam = new AxisCamera(r.cameraHost);
	Image image;
	
	public void image(){
		cam.getImage(image);
		
	}
	
}
