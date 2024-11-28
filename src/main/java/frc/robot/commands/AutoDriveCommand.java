// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDriveCommand extends Command {

public final DriveSubsystem m_driveSubsystem;
public final double m_speed;
public final double m_distance;
  /** Creates a new AutoDriveCommand. */
  public AutoDriveCommand(Double speed, Double distance, DriveSubsystem driveSubsystem) {
    m_driveSubsystem = driveSubsystem;
    m_speed = speed;
    m_distance = distance;
    addRequirements(driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_driveSubsystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveSubsystem.drive(m_speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSubsystem.stopDriving();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_driveSubsystem.getEncoderPosition() >= m_distance;
  }
}
