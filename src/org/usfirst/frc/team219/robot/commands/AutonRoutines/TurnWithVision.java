package org.usfirst.frc.team219.robot.commands.AutonRoutines;

import org.usfirst.frc.team219.robot.RobotMap;
import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;


/**
 *
 */
public class TurnWithVision extends CommandBase {
	
	private double startX,currX;
	private int leftRight;
    private boolean endRange;
	
    public TurnWithVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	endRange = false;
    	startX = vision.getXVal();
    
    }
    
    private double outsideSpeed = .2;
    private double middleSpeed = .15;
    private double insideSpeed = .11;
    private int center = 145;

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftRight = vision.turnRight();
    	currX = vision.getXVal();
    	
		if(Math.abs(currX - center) > 70){
			drivetrain.setTalonSpeed(leftRight* outsideSpeed, leftRight*outsideSpeed);
		}
		else if(Math.abs(currX - center) > 45){
			drivetrain.setTalonSpeed(leftRight*middleSpeed, leftRight*middleSpeed);
		}
		else if(Math.abs(currX - center) > 3){
			drivetrain.setTalonSpeed(leftRight*insideSpeed, leftRight*insideSpeed);
			System.out.println("");
			endRange = true;
		}
	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean x = ((Math.abs(currX - center) <= 5) && endRange);
		if(x)
			System.out.println("finished: "+currX);
		return x;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.setTalonSpeed(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
