package org.usfirst.frc.team219.robot.commands.TeleOp;

import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StartShooterWheels extends CommandBase{

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		this.setTimeout(5);
	}

	@Override
	protected void execute()
	{
//		Timer.delay(.5);
		SmartDashboard.putString("Is Shooting", "FIRE UP THE BURNERS MAN");
		arm.setShootSpeed(.8,-.8);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		SmartDashboard.putString("Is Shooting", "Zzz");
		arm.setShootSpeed(0,0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}