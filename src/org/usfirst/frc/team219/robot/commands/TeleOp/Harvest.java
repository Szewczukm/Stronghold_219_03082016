package org.usfirst.frc.team219.robot.commands.TeleOp;

import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Harvest extends CommandBase
{

	public Harvest(){
		requires(roller);
		setTimeout(5);
	}
	
	@Override
	protected void initialize()
	{
		roller.setRollerSpeed(.7);
	}

	@Override
	protected void execute()
	{
		SmartDashboard.putString("Roller", "HARVESTING");
	}

	@Override
	protected boolean isFinished()
	{	
		return isTimedOut();
	}

	@Override
	protected void end() {
		SmartDashboard.putString("Roller", "Z z z");
		roller.setRollerSpeed(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
