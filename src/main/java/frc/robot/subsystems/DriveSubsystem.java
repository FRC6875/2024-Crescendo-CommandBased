
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.SparkRelativeEncoder.Type;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import java.lang.Math;


public class DriveSubsystem extends SubsystemBase {


// declare all of our motors. use the constants for the port

  CANSparkMax frontLeftDriveMotor = new CANSparkMax(Constants.DriveConstants.kFrontLeftDrivePort, MotorType.kBrushless);
  CANSparkMax backLeftDriveMotor = new CANSparkMax(Constants.DriveConstants.kBackLeftDrivePort, MotorType.kBrushless);
  CANSparkMax frontRightDriveMotor = new CANSparkMax(Constants.DriveConstants.kFrontRightDrivePort, MotorType.kBrushless);
  CANSparkMax backRightDriveMotor = new CANSparkMax(Constants.DriveConstants.kBackRightDrivePort, MotorType.kBrushless);

   //declare Encorders
  RelativeEncoder frontLeftEncoder;
  RelativeEncoder frontRightEncoder;
  RelativeEncoder backLeftEncoder;
  RelativeEncoder backRightEncoder;
  RelativeEncoder leftShootEncoder;
  RelativeEncoder rightShootEncoder;

  // delcare gyro
  AHRS gyro = new AHRS(SPI.Port.kMXP);

  DifferentialDrive m_robotDrive;


  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
     
    // initialize motors
    frontLeftDriveMotor.restoreFactoryDefaults();
    frontRightDriveMotor.restoreFactoryDefaults();
    backRightDriveMotor.restoreFactoryDefaults();
    backLeftDriveMotor.restoreFactoryDefaults();
    
    // set motor idle mode to brake
    frontLeftDriveMotor.setIdleMode(IdleMode.kBrake);
    frontRightDriveMotor.setIdleMode(IdleMode.kBrake);
    backRightDriveMotor.setIdleMode(IdleMode.kBrake);
    backLeftDriveMotor.setIdleMode(IdleMode.kBrake);
   
    // set ramp rate to 1 s
    frontLeftDriveMotor.setClosedLoopRampRate(1);
    frontRightDriveMotor.setClosedLoopRampRate(1);
    backRightDriveMotor.setClosedLoopRampRate(1);
    backLeftDriveMotor.setClosedLoopRampRate(1);

    // initialize encoders
    backLeftEncoder = backLeftDriveMotor.getEncoder(Type.kHallSensor, 42);
    backRightEncoder = backRightDriveMotor.getEncoder(Type.kHallSensor, 42);
    frontLeftEncoder = frontLeftDriveMotor.getEncoder(Type.kHallSensor, 42);
    frontRightEncoder = frontRightDriveMotor.getEncoder(Type.kHallSensor, 42);

    // set for the wheel motors as we want to know the positions
    //  PI * WheelDiameter / GearRatio --WheelDiameter is in inches
    frontLeftEncoder.setPositionConversionFactor(Math.PI*6/8.45);
    frontRightEncoder.setPositionConversionFactor(Math.PI*6/8.45);
    backLeftEncoder.setPositionConversionFactor(Math.PI*6/8.45);
    backRightEncoder.setPositionConversionFactor(Math.PI*6/8.45);
    
      // set leader/followers - this connects the front and back motors to drive together
    backLeftDriveMotor.follow(frontLeftDriveMotor);
    backRightDriveMotor.follow(frontRightDriveMotor);
    //.

    // set motor inversion (may not have to do this - test without it later)
    frontLeftDriveMotor.setInverted(true);
    backLeftDriveMotor.setInverted(true);
    frontRightDriveMotor.setInverted(false);
    backRightDriveMotor.setInverted(false); // have to do seperate for each motor

      // burn settings into memory
    frontLeftDriveMotor.burnFlash();
    frontRightDriveMotor.burnFlash();
    backRightDriveMotor.burnFlash();
    backLeftDriveMotor.burnFlash();
        
    m_robotDrive = new DifferentialDrive(frontLeftDriveMotor,frontRightDriveMotor); //all motors connected


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
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }
  public void drive(double forward, double rotation){
    m_robotDrive.arcadeDrive(forward, rotation);
  }

  public void resetEncoders(){
    backLeftEncoder.setPosition(0);
     backRightEncoder.setPosition(0);
     frontLeftEncoder.setPosition(0);
     frontRightEncoder.setPosition(0);
  }

  public void stopDriving() {
    m_robotDrive.arcadeDrive(0,0);
  }

  public void resetGyro(){
    gyro.reset();
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
