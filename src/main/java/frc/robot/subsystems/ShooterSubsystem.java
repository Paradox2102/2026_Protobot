// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private SparkFlex m_leader = new SparkFlex(Constants.CANIDConstants.shooterLeader, MotorType.kBrushless);
  private SparkFlex m_follower = new SparkFlex(Constants.CANIDConstants.shooterFollower, MotorType.kBrushless);
  RelativeEncoder m_encoder = m_leader.getEncoder();
  /** Creates a new RackPinionSubsystem. */
  public ShooterSubsystem() {
    m_leader.configure(Constants.ShooterConstants.leaderConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_follower.configure(Constants.ShooterConstants.followConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public Command run(double voltage) {
    return Commands.runEnd(() -> {
      m_leader.setVoltage(voltage);
    }, () -> {
      m_leader.setVoltage(0);
    });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("speed", m_encoder.getVelocity());
  }
}
