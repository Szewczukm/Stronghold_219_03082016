package org.usfirst.frc.team219.robot.commands.AutonRoutines;

import org.usfirst.frc.team219.robot.commands.CommandBase;


/**
 *
 */
public class TurnWithVision extends CommandBase {
	
    public TurnWithVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(vision.turnRight()==1){
    		drivetrain.setTalonSpeed(-.2, -.2);
    	}
    	else if(vision.turnRight()==-1){
    		drivetrain.setTalonSpeed(.2, .2);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (vision.getXVal() <=330 && vision.getXVal()>=310);
		
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
