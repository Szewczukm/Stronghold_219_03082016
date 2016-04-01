package org.usfirst.frc.team219.robot.commands.AutonRoutines;

import org.usfirst.frc.team219.robot.commands.CommandBase;

/**
 *
 */
public class DriveToDistance extends CommandBase {
	private double distanceInInches, totalDistance;
	private double trimInches = 1.5;
	private double startAngle;
	private double speed;
	
    public DriveToDistance(double distanceInInches, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    	this.distanceInInches = distanceInInches;
    	this.speed = speed;
    	totalDistance = this.distanceInInches - trimInches;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetEncoders();
    	startAngle = drivetrain.getGyroAngle();
    	drivetrain.autonDrive(speed, -speed, startAngle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return drivetrain.isAtDistance(totalDistance);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
