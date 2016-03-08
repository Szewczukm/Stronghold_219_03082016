package org.usfirst.frc.team219.robot.commands.TeleOp;

import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Harvest extends CommandBase
{

	@Override
	protected void initialize()
	{
		// TODO Auto-generated method stub
		this.setTimeout(5);
	}

	@Override
	protected void execute()
	{
		arm.setShootSpeed(-.7, .7);
		SmartDashboard.putBoolean("shooter limit", arm.getLimitShoot());
		// TODO Auto-generated method stub
		SmartDashboard.putString("Is Harvesting", "HARVESTING");
		
	}

	@Override
	protected boolean isFinished()
	{
		return (!arm.getLimitShoot() || isTimedOut());
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		SmartDashboard.putString("Is Harvesting", "NOT HARVESTING");
		arm.setShootSpeed(0, 0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
