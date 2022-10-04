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
 * BlackFish class. is a fish.
 *
 * @author Ash W-C
 */
public class BlackFish extends Fish
{
  private TankObject source;
  private TankObject destination;
  private int speed = 2;

  /**
   * BlackFish constructor
   * 
   * @param source      TankObject that the fish moves from
   * @param destination TankObject that the fish moves to
   */
  public BlackFish(TankObject source, TankObject destination)
  {
    super(2, "images" + File.separator + "black.png");
    this.source = source;
    this.destination = destination;
    startSwimming();
  }

  /**
   * makes one speed move towards destination
   */
  public void moveTowardsDestination()
  {
    float dx = destination.getX() - getX();
    float dy = destination.getY() - getY();
    int d = (int) Math.sqrt((dx * dx) + (dy * dy));
    float newX = (getX() + (speed * (destination.getX() - getX())) / (d));
    float newY = (getY() + (speed * (destination.getY() - getY())) / (d));
    setX(newX);
    setY(newY);
  }

  /**
   * checks if this is over the TankObject other
   * 
   * @param other object to check if this is over
   * @return true if this black fish is over another tank object, and false otherwise
   */
  public boolean isOver(TankObject other)
  {
    // pos of each corner of this object
    float x1 = getX() - image.width / 2;
    float y1 = getY() - image.height / 2;
    float x2 = getX() + image.width / 2;
    float y2 = getY() + image.height / 2;

    // pos of each corner of the tankObject other
    float x3 = other.getX() - other.getImage().width / 2;
    float y3 = other.getY() - other.getImage().height / 2;
    float x4 = other.getX() + other.getImage().width / 2;
    float y4 = other.getY() + other.getImage().height / 2;

    // calculations, returns true if over
    return (x1 < x4) && (x3 < x2) && (y1 < y4) && (y3 < y2);
  }


  /**
   * Moves the fish between the source and destination. Overrides Fish.swim() method
   */
  @Override
  public void swim()
  {
    // move the fish towards its destination
    // if destination is reached (meaning this fish is over its destination,
    // switch source and destination
    moveTowardsDestination();
    if (isOver(destination))
    {
      TankObject temp = source;
      source = destination;
      destination = temp;
    }
  }
}
