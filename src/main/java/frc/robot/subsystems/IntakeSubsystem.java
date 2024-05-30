
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intakeSubsystem extends SubsystemBase {


// declare all of our motors. use the constants for the port
 CANSparkMax leftIntake = new CANSparkMax(7, MotorType.kBrushed);
 CANSparkMax rightIntake = new CANSparkMax(8, MotorType.kBrushed);



 
  /** Creates a new ExampleSubsystem. */
  public intakeSubsystem() {
     
    // set motor inversion 
  rightIntake.setInverted(false);
  leftIntake.setInverted(true);
   
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
 
  

  private void intake(double speed) {
    rightIntake.set(speed);
    leftIntake.set(speed);
  }   // end intake

    
  private void intakeStop(double speed) {
    rightIntake.set(0);
    leftIntake.set(0);
  }   // end intake

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}