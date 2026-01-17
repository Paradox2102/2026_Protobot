// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkFlexConfig;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{

  public static final double k_robotMass = (148 - 20.3) * 0.453592; // 32lbs * kg per pound
  public static final Matter k_chassis    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), k_robotMass);
  public static final double k_loopTime  = 0.13; //s, 20ms + 110ms sprk max velocity lag
  public static final double k_maxSpeed  = Units.feetToMeters(14.5);
  // Maximum speed of the robot in meters per second, used to limit acceleration.

//  public static final class AutonConstants
//  {
//
//    public static final PIDConstants TRANSLATION_PID = new PIDConstants(0.7, 0, 0);
//    public static final PIDConstants ANGLE_PID       = new PIDConstants(0.4, 0, 0.01);
//  }

  public static final class DrivebaseConstants
  {

    // Hold time on motor brakes when disabled
    public static final double k_wheelLockTime = 10; // seconds

    public static final double k_alignTolerance = 0.5125;
    public static final double k_alignP = 2.5;
    public static final double k_alignI = 0;
    public static final double k_alignD = 0;

    public static final double k_rotateP = 0.05;
    public static final double k_rotateI = 0.1;
    public static final double k_rotateD = 0.0008;

    public static final double k_rotateIZone = 20;
  }

  public static class IntakeConstants{
    public static final SparkFlexConfig rollerConfig = new SparkFlexConfig();

    static {
      rollerConfig.idleMode(IdleMode.kBrake).smartCurrentLimit(80);
      rollerConfig.inverted(false);
    }
  }

  public static class ShooterConstants{
    public static final SparkFlexConfig leaderConfig = new SparkFlexConfig();
    public static final SparkFlexConfig followConfig = new SparkFlexConfig();

    static {
      leaderConfig.idleMode(IdleMode.kBrake).smartCurrentLimit(80);
      followConfig.apply(leaderConfig).follow(CANIDConstants.shooterLeader, true);
    }
  }

  public static class OperatorConstants
  {

    // Joystick Deadband
    public static final double k_deadBand        = 0.1;
    public static final double k_leftYDeadBand = 0.1;
    public static final double k_rightXDeadBand = 0.1;
    public static final double k_turnConstant    = 6;
  }

  public static class CANIDConstants {
    public static final int gyro = 0;
    public static final int fl_drive = 7;
    public static final int fl_turn = 8; 
    public static final int fr_drive = 5; 
    public static final int fr_turn = 6; 
    public static final int bl_drive = 3; 
    public static final int bl_turn = 4; 
    public static final int br_drive = 1; 
    public static final int br_turn = 2;
    public static final int shooterLeader = 10;
    public static final int shooterFollower = 11;
    public static final int intakeRoller = 12;
  }
}