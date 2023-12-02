package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveySubsystem;


// Calls DriveBackward when the autonomous phase begins
public class AutonomousCommand extends SequentialCommandGroup {
  public DriveySubsystem m_driveTrainSub;
  public AutonomousCommand(RobotContainer robotContainer, DriveySubsystem subsystem) {
    m_driveTrainSub = subsystem;
    addRequirements(m_driveTrainSub);

    addCommands(
        // new DriveForward(m_driveTrainSub),
        // new WaitCommand(3),
        // new StopMoving(m_driveTrainSub)
    );
  }
}