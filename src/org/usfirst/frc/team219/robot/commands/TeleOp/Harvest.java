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
		roller.setRollerSpeed(-.7);
		SmartDashboard.putString("Is Harvesting", "HARVESTING");
		
	}

	@Override
	protected boolean isFinished()
	{	
		return isTimedOut();
	}

	@Override
	protected void end() {
		SmartDashboard.putString("Is Harvesting", "NOT HARVESTING");
		roller.setRollerSpeed(0);
	}

	@Override
	protected void interrupted() {
		
	}

}
