package org.usfirst.frc.team219.robot.commands.AutonRoutines;

import org.usfirst.frc.team219.robot.commands.CommandBase;
import org.usfirst.frc.team219.robot.subsystems.DriveTrain.Talon;

import edu.wpi.first.wpilibj.DriverStation;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class Hopper extends CommandBase {
	
	Waypoint[] points = new Waypoint[]{
			new Waypoint(-4, -1, Pathfinder.d2r(-45)),
			new Waypoint(-2, -2, 0),
			new Waypoint(0,0,0)
	};
	
	Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
	Trajectory trajectory = Pathfinder.generate(points, config);
	TankModifier modifier = new TankModifier(trajectory).modify(0.5);
	EncoderFollower left = new EncoderFollower(modifier.getLeftTrajectory());
	EncoderFollower right = new EncoderFollower(modifier.getRightTrajectory());
	
	double startTime;
	
	public Hopper(){
		left.configureEncoder(drivetrain.getEncoderPos(drivetrain.getTalon(Talon.FRONT_LEFT)), 4096, 6);
		right.configureEncoder(drivetrain.getEncoderPos(drivetrain.getTalon(Talon.FRONT_RIGHT)), 4096, 6);
		left.configurePIDVA(1, 0, 0, 1/1.7, 0);
	}
	
	protected void initialize(){
	}
	
	protected void execute(){
		double leftSpeed = left.calculate(drivetrain.getEncoderPos(drivetrain.getTalon(Talon.FRONT_LEFT)));
		double rightSpeed = right.calculate(drivetrain.getEncoderPos(drivetrain.getTalon(Talon.FRONT_RIGHT)));
		double angle = drivetrain.getGyroAngle();
		double desiredAngle = Pathfinder.r2d(left.getHeading());
		double deltaAngle = Pathfinder.boundHalfDegrees(desiredAngle - angle);
		double turn = 0.8 * (-1.0/80) * deltaAngle;
		drivetrain.setTalonSpeed(leftSpeed + turn, rightSpeed - turn);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	protected void end(){
		
	}
	
	protected void interrupted(){
		end();
	}

}



