// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmCommand;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ShmooveCommand;
import frc.robot.commands.TestMotorsCommand;
import frc.robot.commands.VroomCommand;
import frc.robot.subsystems.DriveySubsystem;
import frc.robot.subsystems.DumpySubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LumpySubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
 private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();



  // Replace with CommandPS4Controller or CommandJoystick if needed
  

  static CommandXboxController m_driverController = new CommandXboxController(0);
  // private final DumpySubsystem dumpySubsystem = new DumpySubsystem();
  // private final LumpySubsystem lumpySubsystem = new LumpySubsystem();
  private final DriveySubsystem driveySubsystem = new DriveySubsystem();

  private ShmooveCommand m_shmooveCommand = new ShmooveCommand(driveySubsystem, 10.0);

  public void containerTeleopPeriodic() {
    // Tank drive with a given left and right rates
    // driveySubsystem.mDrive.tankDrive(-leftStick.getY(), -rightStick.getY());

    // Arcade drive with a given forward and turn rate
    driveySubsystem.drive(m_driverController);

    // Curvature drive with a given forward and turn rate, as well as a button for turning in-place.
    // myDrive.curvatureDrive(-driveStick.getY(), -driveStick.getX(), driveStick.getButton(1));
}

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings(); 

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.a().whileTrue(new TestMotorsCommand(dumpySubsystem));
    // m_driverController.b().whileTrue(new ArmCommand(lumpySubsystem, 0.1));
    // m_driverController.x().whileTrue(new ArmCommand(lumpySubsystem, -0.1));
    // WITH SHMOOVECOMMAND, USE NEGATIVE NUMBERS OR THE ROBOT WILL BREAK AND THAT IS NOT GOOD
    // m_driverController.rightBumper().onTrue(new ShmooveCommand(lumpySubsystem, -51.0, -49.0));
    // m_driverController.leftBumper().onTrue(new ShmooveCommand(lumpySubsystem, -91.0, -89.0));
    // m_driverController.rightTrigger().whileTrue(new VroomCommand(driveySubsystem, 0.5));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return m_shmooveCommand;
  }
}
