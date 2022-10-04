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

import processing.core.PImage;

/**
 * TankObject class, everything in the tank is a subclass of this
 *
 * @author Ash W-C
 */
public class TankObject implements TankListener
{
  protected static FishTank tank; // PApplet object which represents the display window
  protected PImage image; // image of this tank object

  private float x; // x-position of this tank in the display window
  private float y; // y-position of this tank in the display window

  private boolean isDragging; // indicates whether this tank object is being dragged or not
  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse

  /**
   * constructor
   * 
   * @param x             x pos of the object
   * @param y             y pos of the object
   * @param imageFileName name of the image file to be used
   */
  public TankObject(float x, float y, String imageFileName)
  {
    this.image = tank.loadImage(imageFileName);
    this.x = x;
    this.y = y;

    isDragging = false;
  }

  /**
   * Sets the PApplet graphic display window for all TankObjects
   * 
   * @param tank the fishtank to set tank to
   */
  public static void setProcessing(FishTank tank)
  {
    TankObject.tank = tank;
  }

  /**
   * Moves this tank object with dx and dy
   * 
   * @param dx move to the x-position of this tank object
   * @param dy move to the y-position of this tank object
   */
  public void move(int dx, int dy)
  {
    this.x += dx;
    this.y += dy;
    if (this.x < 0)
    {
      this.x = ((this.x) + tank.width);
    }
    if (this.y < 0)
    {
      this.y = ((this.y) + tank.height);
    }
    if (this.x > tank.width)
    {
      this.x = ((this.x) - tank.width);
    }
    if (this.y > tank.height)
    {
      this.y = ((this.y) - tank.height);
    }
  }

  /**
   * @return the x-position of this tank object
   */
  public float getX()
  {
    return this.x;
  }

  /**
   * @return the y-position of this tank object
   */
  public float getY()
  {
    return this.y;
  }

  /**
   * Sets the x-position of this object
   * 
   * @param x x val to set
   */
  public void setX(float x)
  {
    this.x = x;
  }

  /**
   * Sets the y-position of this object
   * 
   * @param y y val to set
   */
  public void setY(float y)
  {
    this.y = y;
  }

  /**
   * @return the image of this tank object
   */
  public PImage getImage()
  {
    return image;
  }

  /**
   * Getter of the isDragging field.
   * 
   * @return true if this object is being dragged, false otherwise
   */
  public boolean isDragging()
  {
    return isDragging;
  }

  /**
   * Starts dragging this tank object
   */
  public void startDragging()
  {
    oldMouseX = tank.mouseX;
    oldMouseY = tank.mouseY;
    this.isDragging = true;
  }

  /**
   * Stops dragging this tank object
   */
  public void stopDragging()
  {

    this.isDragging = false;
  }

  /**
   * overridden draw method. moves the position if it is being dragged and updates the pos in the
   * tank
   */
  @Override
  public void draw()
  {
    // if this object is dragging, set its position to follow the mouse moves
    if (this.isDragging)
    {
      int dx = tank.mouseX - oldMouseX;
      int dy = tank.mouseY - oldMouseY;
      move(dx, dy);
      oldMouseX = tank.mouseX;
      oldMouseY = tank.mouseY;
    }
    // draw this decoration object at its current position
    tank.image(this.image, this.x, this.y);
  }

  /**
   * mousepressed override, starts dragging
   */
  @Override
  public void mousePressed()
  {
    startDragging();
  }

  /**
   * mouseReleased override, stops dragging
   */
  @Override
  public void mouseReleased()
  {
    stopDragging();
  }

  /**
   * isMouseOver override, checks if the mouse is over this object
   */
  @Override
  public boolean isMouseOver()
  {
    return tank.mouseX >= x - image.width / 2 && tank.mouseX <= x + image.width / 2
        && tank.mouseY >= y - image.height / 2 && tank.mouseY <= y + image.height / 2;
  }
}
