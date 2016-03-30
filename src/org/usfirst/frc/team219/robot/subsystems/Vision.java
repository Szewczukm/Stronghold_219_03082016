package org.usfirst.frc.team219.robot.subsystems;

import org.usfirst.frc.team219.robot.RobotMap;
import org.usfirst.frc.team219.robot.commands.AutonRoutines.PullData;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Vision extends Subsystem {
	
	private CameraServer camera;
    private NetworkTable table;

	private double[] centerXs;
	
	private double[] defaultValue = new double[0];
    
	public Vision(){
		/*
		 * USB Camera creation
		 */
		camera = CameraServer.getInstance();
		camera.setQuality(50);
		camera.startAutomaticCapture("cam1");
	}
	
	
	/**
	 * Updates network tables with GRIP's vision values
	 */
	public void post(){
	    table = NetworkTable.getTable("GRIP/myContoursReport");
	    centerXs = table.getNumberArray("centerX", defaultValue);
	    SmartDashboard.putNumber("Turn Right?", turnRight());
	    try {
	    	SmartDashboard.putNumber("X Num", centerXs[0]);
	    	SmartDashboard.putString("Target", "I SEE IT!");
	    	if(getXVal() <=112 && getXVal()>=100){
	    		SmartDashboard.putString("At Good Angle?", "FIRE AWAY");
	    	}
	    	else{
	    		SmartDashboard.putString("At Good Angle?", "DON'T SHOOT");
	    	}
	    }
	    catch(ArrayIndexOutOfBoundsException q) {
	    	SmartDashboard.putString("Target", "Can't See Target...");
	    }
	    	    
	}
	
	/**
	 * 
	 * @return 1 if has to turn right, -1 if has to turn left, 0 if nothing found
	 */
	public int turnRight(){
		try{
			if((RobotMap.CENTER_GOAL - (centerXs[0])) <= 0)
			{
				return 1; 
			}
			else
			{
				if(RobotMap.CENTER_GOAL - centerXs[0] >= 0)
				{
					return -1;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e){

		}
		
		return 0;
	}
	
	/**
	 * 
	 * @return current center x value of target, or w/e vision camera sees
	 */
	public double getXVal()
	{
		try{
			return centerXs[0];
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Target not found: "+e);
		}
		return RobotMap.CENTER_GOAL;
	}
	
	/**
	 * Starts updating centerX values
	 */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new PullData());
    	
    }

}

