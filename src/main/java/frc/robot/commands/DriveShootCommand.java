// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DriveShootCommand extends SequentialCommandGroup {
  /** Creates a new DriveShootCommand. */
  public DriveShootCommand(DriveSubsystem m_driveSubsystem, IntakeSubsystem m_intakeSubsystem) {
  
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    //new AutoIntakeCommand(m_intakeSubsystem), -> uncomment this when youre done testing directions
    new AutoDriveCommand(-1.00, -10.00, m_driveSubsystem) //
    // speed +, direction + -> drives backwards
    // speed -, distance + -> drives forwards extra far?
    // think it would do the same with speed +, distance -
    // robot just blips - makes a noise, kind of shudders, but doesn't go anywhere
    );
  }
}
