package org.usfirst.frc.team219.robot.commands.AutonRoutines;

import org.usfirst.frc.team219.robot.commands.TeleOp.Harvest;
import org.usfirst.frc.team219.robot.commands.TeleOp.StartShooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveShoot extends CommandGroup {
	
    public  DriveShoot(double speed) {
//    	addSequential(new DriveToDistance(160, speed));
    	addSequential(new TurnWithVision());
    	addSequential(new StartShooter());
    	Timer.delay(1);
    	addParallel(new Harvest());
    }
}
