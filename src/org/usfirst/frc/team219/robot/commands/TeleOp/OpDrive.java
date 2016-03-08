package org.usfirst.frc.team219.robot.commands.TeleOp;

import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class OpDrive extends CommandBase {
	private double speedModifier = .6;

    public OpDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	System.out.println("driving");
    	if(oi.getButtonLB()){
    		speedModifier += .1;
    	}
    	if(oi.getButtonRB()){
    		speedModifier -= .1;
    	}
    	drivetrain.tankDrive(-(oi.getLeftYDrive())*speedModifier, oi.getRightYDrive()*speedModifier);
//    	System.out.println(oi.getLeftYDrive());
//    	System.out.println(drivetrain.getGyroAngle());
    	SmartDashboard.putNumber("Speed Modifier", speedModifier);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("ended");
    	drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
