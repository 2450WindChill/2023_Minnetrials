// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class DriveySubsystem extends SubsystemBase {

  public final CANSparkMax motorROne = new CANSparkMax(1, MotorType.kBrushed);
  public final CANSparkMax motorRTwo = new CANSparkMax(2, MotorType.kBrushed);
  public final CANSparkMax motorLOne = new CANSparkMax(3, MotorType.kBrushed);
  public final CANSparkMax motorLTwo = new CANSparkMax(4, MotorType.kBrushed);

  //public final RelativeEncoder legEncoder = motorROne.getEncoder();
  //REVISE LATER RAAAH (rewrite without encoder bc that is illegal to use with brushed) :(

  public final MotorControllerGroup leftMotor = new MotorControllerGroup(motorLOne, motorLTwo);
  public final MotorControllerGroup rightMotor = new MotorControllerGroup(motorROne, motorRTwo);

  public DifferentialDrive mDrive = new DifferentialDrive(leftMotor, rightMotor);
  
  /** Creates a new ExampleSubsystem. */
  public DriveySubsystem() {
    motorROne.setInverted(true);
    motorLOne.setInverted(true);
    motorRTwo.setInverted(true);
    motorLTwo.setInverted(true);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void drive(XboxController controller) {
    mDrive.arcadeDrive(controller.getLeftY() * 0.6, controller.getLeftX() * 0.75);
  }

    

  public void fullSendYeetGo() {
    mDrive.arcadeDrive(0.3, 0);
  }

  public void itsJoever() {
    mDrive.arcadeDrive(0.0, 0);
  }

}
