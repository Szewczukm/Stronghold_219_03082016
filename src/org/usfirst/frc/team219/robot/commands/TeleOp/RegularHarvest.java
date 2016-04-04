package org.usfirst.frc.team219.robot.commands.TeleOp;

import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RegularHarvest extends CommandBase
{

	public RegularHarvest(){
		requires(roller);
		setTimeout(5);
	}
	
	@Override
	protected void initialize()
	{
		roller.setRollerSpeed(.9);
	}

	@Override
	protected void execute()
	{
	}

	@Override
	protected boolean isFinished()
	{	
		return isTimedOut();
	}

	@Override
	protected void end() {
		roller.setRollerSpeed(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}