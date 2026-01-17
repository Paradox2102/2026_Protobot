// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private SparkFlex m_motor = new SparkFlex(Constants.CANIDConstants.intakeRoller, MotorType.kBrushless);
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    m_motor.configure(Constants.IntakeConstants.rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public Command run(double voltage) {
    return Commands.runEnd(() -> {
      m_motor.setVoltage(voltage);
    }, () -> {
      m_motor.setVoltage(0);
    });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
