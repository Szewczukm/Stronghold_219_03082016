package org.usfirst.frc.team219.robot.commands.TeleOp;

import org.usfirst.frc.team219.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StartRoller extends CommandBase{

	public StartRoller(){
		this.setTimeout(5);
		requires(roller);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		roller.setRollerSpeed(-.5);
	}

	@Override
	protected void execute()
	{
		SmartDashboard.putString("Roller", "FIRE UP THE BURNERS MAN");
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		SmartDashboard.putString("Roller", "Z z z");
		roller.setRollerSpeed(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}