
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

public class ShootSubsystem extends SubsystemBase {


// declare all of our motors. use the constants for the port

  // declare shooter motors
  CANSparkMax leftShoot = new CANSparkMax(kLeftShootPort, MotorType.kBrushless);
  CANSparkMax rightShoot = new CANSparkMax(kRightShootPort, MotorType.kBrushless);
  CANSparkMax rightShoot2 = new CANSparkMax(kRightShootPort2, MotorType.kBrushed);
  CANSparkMax leftShoot2 = new CANSparkMax(kLeftshootPort2, MotorType.kBrushed);

//declare shoot encoders
  RelativeEncoder leftShootEncoder;
  RelativeEncoder rightShootEncoder;

 

  /** Creates a new ExampleSubsystem. */
  public ShootSubsystem() {
     
    rightShootEncoder = rightShoot.getEncoder(Type.kHallSensor, 42);
    leftShootEncoder = leftShoot.getEncoder(Type.kHallSensor, 42);

//set motor inversions
    leftShoot.setInverted(true);
    rightShoot.setInverted(false);
    leftShoot2.setInverted(true);
    rightShoot2.setInverted(false);


  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

  public boolean getShootSpeed(double threshold){
    return (leftShoot.get() == threshold) && (rightShoot.get() == threshold);
  }

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
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
