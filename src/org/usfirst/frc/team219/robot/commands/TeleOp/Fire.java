package org.usfirst.frc.team219.robot.commands.TeleOp;

import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Fire extends CommandBase {

	private String fireType;
	
    public Fire(String fT)
    {
    	fireType = fT.toLowerCase();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	switch(fireType)
    	{
    		case "shooter":
    			pneumatics.retractShooter();
    			Timer.delay(.5);
    			pneumatics.extendShooter();
    			break;
    		case "climber":
    			pneumatics.extendClimbers();
    			break;
    		case "portcullis":
    			pneumatics.extendPortcullis();
    			break;
    	}
    	
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
  
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
