// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class DriveConstants {
    public static final int kFrontLeftDrivePort = 1;
    public static final int kBackLeftDrivePort = 3;
    public static final int kFrontRightDrivePort = 2;
    public static final int kBackRightDrivePort = 4;
  }

  public static class ShootConstants {
    public static final int kLeftShootPort =6;
    public static final int kRightShootPort = 10;
    public static final int kLeftshootPort2 = 5;
    public static final int kRightShootPort2 = 9;
  }

  public static class IntakeConstants {
    public static final int kLeftIntakePort = 7;
    public static final int kRightIntakePort = 8;
    public static final int kIntakeSensorPort = 0;
  }

  public static class ControllerConstants {
    public static final int kXboxController1Port = 0;
    public static final int kXboxController2Port = 1;
  }

  public static class EncoderConstants{
    public static final int kDriverEncoderConvFact = (int) (Math.PI*6/8.45);
  }

}
