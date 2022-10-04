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

/**
 * ClearTankButton is a subclass of button
 * 
 * @author ash w-c
 */
public class ClearTankButton extends Button
{
  /**
   * constructor
   * 
   * @param x x pos of the button
   * @param y y pos of the button
   */
  public ClearTankButton(float x, float y)
  {
    super("Clear", x, y);
  }

  /**
   * overridden mousepressed method. clears tank when button is pressed
   */
  @Override
  public void mousePressed()
  {
    if (isMouseOver())
    {
      tank.clear();
    }
  }
}
