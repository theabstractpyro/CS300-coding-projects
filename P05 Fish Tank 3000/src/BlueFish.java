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
 * BlueFish class. is a fish.
 *
 * @author Ash W-C
 */
public class BlueFish extends Fish
{
  private int speed = 2;

  /**
   * BlueFish constructor, calls the super constructor
   */
  public BlueFish()
  {
    super(2, "images" + File.separator + "blue.png");
  }

  /**
   * Moves horizontally the fish one speed step from left to right.
   */
  @Override
  public void swim()
  {
    move(-speed, 0);
  }
}
