package com.poc.detectcamera;

import android.app.Service;
import android.content.Intent;
import android.hardware.Camera;
import android.os.IBinder;

public class DetectService extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		
	    int cameraCount = 0;
	    Camera cam = null;
	 
	    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
	    cameraCount = Camera.getNumberOfCameras(); 
	          
	    for ( int camIdx = 0; camIdx < cameraCount;camIdx++ ) {
	        Camera.getCameraInfo( camIdx, cameraInfo ); 
	        if ( cameraInfo.facing ==Camera.CameraInfo.CAMERA_FACING_FRONT ) {
	            try {            
	                cam = Camera.open( camIdx );
	            } catch (RuntimeException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

}
