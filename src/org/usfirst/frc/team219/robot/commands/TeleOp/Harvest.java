package org.usfirst.frc.team219.robot.commands.TeleOp;

import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Harvest extends CommandBase
{

	@Override
	protected void initialize()
	{
		this.setTimeout(5);
	}

	@Override
	protected void execute()
	{
		arm.setShootSpeed(-.7, .7);
		SmartDashboard.putBoolean("shooter limit", arm.getLimitShoot());
		SmartDashboard.putString("Is Harvesting", "HARVESTING");
		
	}

	@Override
	protected boolean isFinished()
	{
		return (!arm.getLimitShoot() || isTimedOut());
	}

	@Override
	protected void end() {
		SmartDashboard.putString("Is Harvesting", "NOT HARVESTING");
		arm.setShootSpeed(0, 0);
	}

	@Override
	protected void interrupted() {
		
	}

}
