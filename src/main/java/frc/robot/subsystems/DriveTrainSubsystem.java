// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {
  // Defines real objects to the code
  private static final Talon leftFrontMotor = new Talon(devicenumber:1);
  private static final Talon rightFrontMotor = new Talon(devicenumber:2);
  private static final Talon leftBackMotor = new Talon(devicenumber:3);
  private static final Talon rightBacktMotor = new Talon(devicenumber:4);

/**Creates a differential Drive Variable */  
  private DifferentialDrive driveTrain;
  /** Creates a new DriveTrainSubsystem. */
  public DriveTrainSubsystem() {

    // makes the back motors do the same thing as the front motors (for tank drive or similar)
    leftFrontMotor.addFollower(leftBackMotor);
    rightFrontMotor.addFollower(rightBacktMotor);

    //Inverts right motors
    rightFrontMotor.setInverted(isInverted:true);

    //creates class called "driveTrain"
    driveTrain = new DifferentialDrive(leftFrontMotor, rightFrontMotor);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    driveTrain.tankDrive(leftSpeed, rightSpeed);
  }
}
