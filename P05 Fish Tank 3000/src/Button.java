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
 * button class that is the superclass for all other buttons
 * 
 * @author ash w-c
 */
public class Button implements TankListener
{
  private static final int WIDTH = 85; // Width of this Button
  private static final int HEIGHT = 32; // Height of this Button
  protected static FishTank tank; // PApplet object where this button will be displayed

  private float x; // x-position of this button in the display window
  private float y; // y-position of this button in the display window
  protected String label; // text/label which represents this button

  /**
   * Creates a new Button at a given position within the display window and sets its label
   */
  public Button(String label, float x, float y)
  {
    this.x = x;
    this.y = y;
    this.label = label;
  }

  /**
   * sets the PApplet display window where this button is displayed and handled
   * 
   * @param tank the tank the button is in
   */
  public static void setProcessing(FishTank tank)
  {
    Button.tank = tank;
  }

  /**
   * Overrides the TankListener.isMouseOver() method Checks whether the mouse is over this button
   * 
   * @return true if the mouse is over this button, false otherwise.
   */
  @Override
  public boolean isMouseOver()
  {
    // The implementation of this behavior must be similar to the way to check whether
    // the mouse is over an image. The button is a rectangle whose x,y position is at
    // its center. The width and height of a button are defined as static data fields.
    return tank.mouseX >= x - WIDTH / 2 && tank.mouseX <= x + WIDTH / 2
        && tank.mouseY >= y - HEIGHT / 2 && tank.mouseY <= y + HEIGHT / 2;
  }

  /**
   * Overrides TankListener.draw() method Draws this button to the display window
   */
  @Override
  public void draw()
  {
    tank.stroke(0);// set line value to black

    // TODO if the mouse is over this button, sets the fill color to dark gray.
    // Sets the fill color to light gray otherwise
    if (isMouseOver())
    {
      tank.fill(100);
    } else
    {
      tank.fill(200);
    }

    // draw the button (rectangle with a centered text)
    tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f, x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
    tank.fill(0); // set the fill color to black
    tank.text(label, x, y); // display the text of the current button
  }

  /**
   * Overrides the TankListener.mousePressed() method Implements the default behavior of this button
   * when the mouse is pressed. This method must be overridden in the sub-classes to implement a
   * specific behavior if needed.
   */
  @Override
  public void mousePressed()
  {
    // TODO if the mouse is over this button, print
    // "A button was pressed." to the console
    if (isMouseOver())
    {
      System.out.println("A button was pressed");
    }
  }

  /**
   * Overrides the TankListener.mouseReleased() method Implements the default behavior of this
   * button when the mouse is released. This method must be overridden in the sub-classes to
   * implement a specific behavior if needed.
   */
  @Override
  public void mouseReleased()
  {
    // Leave this method empty
  }
}

