//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Course: CS 300 Fall 2020
//
// Author: Ash Weber-Campbell
// Email: webercampbel@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;

/**
 * Fish class. is a TankObject and the different fishes are subclasses of this
 *
 * @author Ash W-C
 */
public class Fish extends TankObject
{
  private int speed;
  private boolean isSwimming;

  /**
   * Fish constructor
   * 
   * @param speed             speed of the fish
   * @param fishImageFileName name of file of the image to be used
   */
  public Fish(int speed, String fishImageFileName)
  {
    super(tank.randGen.nextInt(tank.width), tank.randGen.nextInt(tank.height), fishImageFileName);
    if (speed < 0)
    {
      throw new IllegalArgumentException("Warning: speed cannot be negative");
    }
    this.speed = speed;
  }

  /**
   * no param constructor, calls the other constructor with a speed of 5 and orange.png filename
   */
  public Fish()
  {
    this(5, "images" + File.separator + "orange.png");
  }


  /**
   * Overrides the draw() method implemented in the parent class. This method sets the position of
   * this fish to follow the mouse moves if it is dragging, calls its swim() method if it is
   * swimming, and draws it to the display window. You can use a partial overriding (call draw()
   * method of the super class and adds the behavior specific to drawing a fish.
   */
  @Override
  public void draw()
  {
    // if the fish is swimming, call its swim() method
    if (isSwimming)
    {
      swim();
    }
    super.draw();
  }

  /**
   * Checks whether this fish is swimming
   * 
   * @return true if swimming
   */
  public boolean isSwimming()
  {
    return isSwimming;
  }

  /**
   * Starts swimming this fish
   */
  public void startSwimming()
  {
    isSwimming = true;
  }

  /**
   * Stops swimming this fish
   */
  public void stopSwimming()
  {
    isSwimming = false;
  }

  /**
   * Gets the speed of this fish
   * 
   * @return speed int
   */
  public int speed()
  {
    return speed;
  }

  /**
   * Moves horizontally the fish one speed step from left to right.
   */
  public void swim()
  {
    // setX((getX() + speed) % tank.width);
    move(speed, 0);
  }


}
