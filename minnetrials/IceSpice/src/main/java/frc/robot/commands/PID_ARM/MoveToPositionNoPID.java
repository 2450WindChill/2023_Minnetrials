package frc.robot.commands.PID_ARM;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.



import frc.robot.Constants;
import frc.robot.subsystems.LumpySubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** An example command that uses an example subsystem. */
public class MoveToPositionNoPID extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private LumpySubsystem m_LumpySubsystem;
  private double currentAngle;
  private double m_targetPosition;

  private boolean movingForward;


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MoveToPositionNoPID(LumpySubsystem LumpySubsystem, double targetPosition) {
    m_LumpySubsystem = LumpySubsystem;
    m_targetPosition = targetPosition;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(LumpySubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    currentAngle = m_LumpySubsystem.armEncoder.getPosition();
    if (m_targetPosition > currentAngle) {
      movingForward = true;
    } else {
      movingForward = false;
    }
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
    if (movingForward == true){
      System.err.println("Moving foward");
      m_LumpySubsystem.armMotor.set(0.1);
    } else {
      System.err.println("Moving back");
      m_LumpySubsystem.armMotor.set(-0.1);
    }
    
    System.err.println("MovetoPosition NO PID");
    SmartDashboard.putNumber("Target", m_targetPosition);
    SmartDashboard.putNumber("Current Angle", m_LumpySubsystem.armEncoder.getPosition());
    currentAngle = m_LumpySubsystem.armEncoder.getPosition();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.err.println("STOPPPPPINGGGGGGGGGGGGGGGGGGGGGGGGGGG: Interrupted? " + interrupted );
    m_LumpySubsystem.armMotor.set(0);
    // m_LumpySubsystem.armMotor.set

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (movingForward) {
      // if (frontLimitSwitchVal){
      //   m_armSubsystem.armMotor.set(0);
      //   return true;
      // } else {
        System.err.println(" FOWARD: Target pos:  " + m_targetPosition + " Current angle: " + currentAngle);
        return (currentAngle >= (m_targetPosition - Constants.nonPidTolerance));
      }
    // } else {
    //   if (backLimitSwitchVal){
    //     m_armSubsystem.armMotor.set(0);
    //     return true;
    //   } else {
      System.err.println("BACK: Target pos:  " + m_targetPosition + " Current angle: " + currentAngle);
        return (currentAngle <= (m_targetPosition + Constants.nonPidTolerance));
      }
    }
