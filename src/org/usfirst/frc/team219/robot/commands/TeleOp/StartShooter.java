package org.usfirst.frc.team219.robot.commands.TeleOp;

import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StartShooter extends CommandBase{

	public StartShooter(){
		this.setTimeout(5);
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		shooter.setShooterSpeed(-.90);
	}

	@Override
	protected void execute()
	{
		SmartDashboard.putString("Shooter", "FIRE UP THE BURNERS MAN");
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		SmartDashboard.putString("Shooter", "Z z z");
		shooter.setShooterSpeed(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}