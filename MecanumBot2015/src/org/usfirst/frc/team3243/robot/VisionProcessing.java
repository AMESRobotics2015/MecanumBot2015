package org.usfirst.frc.team3243.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.vision.*;

public class VisionProcessing {
	
	AxisCamera cam;
	//Declare new AxisCamera.
	Image image;
	Image binaryImage;
	// Declare new image.
	
	public void camSetup(String host){
		cam = new AxisCamera(host);
		//Setting up the camera.
		image = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		//Setting up the image to an RGB image.
		binaryImage = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
		//Setting up a second image that is grayscaled.
	}
	
	public void recieveImage() {
		cam.getImage(image);//Gets image from AxisCamera and puts it into our RGBImage
        CameraServer.getInstance().setImage(image);//Sends image to the RobotDriver.
        
      //Threshold the image looking for black and white.
		//NIVision.imaqColorThreshold(binaryImage, image, 255, NIVision.ColorMode.HSL, TOTE_HUE_RANGE, TOTE_SAT_RANGE, TOTE_VAL_RANGE);
        
	}
	
}
