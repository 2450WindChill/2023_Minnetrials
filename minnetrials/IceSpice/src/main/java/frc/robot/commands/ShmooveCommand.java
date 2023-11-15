// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LumpySubsystem;

import org.ejml.dense.block.MatrixOps_MT_DDRB;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** This command takes the input from an encoder, and moves the arm via lumpysubsystem to 
 *  a certian angle */

public class ShmooveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final LumpySubsystem m_subsystem;
  private Double m_armAngleMax = 0.0;
  private Double m_armAngleMin = 0.0;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ShmooveCommand(LumpySubsystem subsystem, Double armAngleMax, Double armAngleMin) {
    m_subsystem = subsystem;
    m_armAngleMax = armAngleMax;
    m_armAngleMin = armAngleMin;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    double armPosition = m_subsystem.armEncoder.getPosition();
    if (armPosition > m_armAngleMin) {
      m_subsystem.armMotor.set(-0.1);
    } else if (armPosition < m_armAngleMax) {
      m_subsystem.armMotor.set(0.1);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.armMotor.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double armPosition = m_subsystem.armEncoder.getPosition();

    if (armPosition > m_armAngleMin || armPosition < m_armAngleMax) {
      return false;
    } else {
      return true;
    }
  }
}
