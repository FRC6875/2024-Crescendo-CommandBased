// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootSubsystem;

public class AutoShootCommand extends Command {

  private final ShootSubsystem m_shootSubsystem;
 Timer shootTimer = new Timer();


  /** Creates a new AutoShootCommand. */
  public AutoShootCommand(ShootSubsystem shootSubsystem) {
    m_shootSubsystem = shootSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shootSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shootTimer.reset();
    shootTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shootSubsystem.runNeos(0.7);
    if(m_shootSubsystem.getShootSpeed(0.65)){
      m_shootSubsystem.runSims(0.7);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return shootTimer.hasElapsed(10);
  }
}
