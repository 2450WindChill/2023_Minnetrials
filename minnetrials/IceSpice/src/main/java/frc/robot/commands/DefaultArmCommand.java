package frc.robot.commands;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//CommandSparkMaxMotors


import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LumpySubsystem;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class DefaultArmCommand extends CommandBase {
  private final LumpySubsystem m_LumpySubsystem;

    public DefaultArmCommand(LumpySubsystem lumpySubsystem) {
      m_LumpySubsystem = lumpySubsystem;
    
      addRequirements(lumpySubsystem);
    }

    @Override
    public void execute() {
      m_LumpySubsystem.armMotor.set(0);

    }

        
    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
      return false;
  }
}
