package frc.robot.commands.PID_ARM;

import frc.robot.RobotContainer;
import frc.robot.subsystems.LumpySubsystem;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class NonRatchetArmSequentialCommand extends SequentialCommandGroup {
  public LumpySubsystem m_LumpySubsystem;
  public double m_targetPosition;

  public NonRatchetArmSequentialCommand(LumpySubsystem LumpySubsystem, double targetPosition) {
    m_LumpySubsystem = LumpySubsystem;
    m_targetPosition = targetPosition;

    addRequirements(LumpySubsystem);

      addCommands(
        new MoveToPositionNoPID(m_LumpySubsystem, m_targetPosition)
        );
}
}
