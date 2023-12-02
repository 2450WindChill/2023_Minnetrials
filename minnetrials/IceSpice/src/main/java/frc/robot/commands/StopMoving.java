package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveySubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class StopMoving extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DriveySubsystem m_drivetrain;

  public StopMoving(DriveySubsystem subsystem) {
    m_drivetrain = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements();
  }

  @Override
  public void initialize() {
    System.out.println("STOPPING ROBOT DRIVE FORWARDS");
    
  }

  @Override
  public void execute() {
    //System.out.println("Executing robot drive forward");
    m_drivetrain.leftMotor.set(0);
    m_drivetrain.rightMotor.set(0);
  }

  @Override
  public void end(boolean interrupted) {
    //System.out.println("STOPPING ROBOT");
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}