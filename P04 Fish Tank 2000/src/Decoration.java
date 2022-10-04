//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: this program creates a window with a fish tank in it, and the user can add and move fishes
//////////////// around in the tank
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

// TODO: write proper javadoc comments for each method/constructor

// hopefully we will be able to use super/subcalsses to no have all this repeat code in Fish.java
// and Decoration.java

import processing.core.PApplet;
import processing.core.PImage;

public class Decoration
{
  private static PApplet processing;
  private PImage image;
  private float x;
  private float y;
  private boolean isDragging;
  private int oldMouseX;
  private int oldMouseY;

  /**
   * Decoration constructor
   * 
   * @param processing    PApplet reference to the display window of the Fish Tank application
   * @param x             x-position of this decoration object
   * @param y             y-position of this decoration object
   * @param imageFileName filename of the image to be loaded for this object
   */
  public Decoration(PApplet processing, float x, float y, String imageFileName)
  {
    Decoration.processing = processing;
    this.x = x;
    this.y = y;
    image = processing.loadImage(imageFileName);
    isDragging = false;
  }

  /**
   * PImage image getter
   * 
   * @return the image of this decoration object
   */
  public PImage getImage()
  {
    return image;
  }

  /**
   * x pos getter
   * 
   * @return the x-position of this decoration object
   */
  public float getPositionX()
  {
    return x;
  }

  /**
   * y pos getter
   * 
   * @return the y-position of this decoration object
   */
  public float getPositionY()
  {
    return y;
  }

  /**
   * Checks whether this decoration object is being dragged
   * 
   * @return true if the object is being dragged, false otherwise
   */
  public boolean isDragging()
  {
    return isDragging;
  }

  /**
   * Starts dragging this decoration object, and sets oldMouseX and oldMouseY
   */

  public void startDragging()
  {
    // Sets the oldMouseX and oldMouseY to the current position of the mouse
    oldMouseX = processing.mouseX;
    oldMouseY = processing.mouseY;
    isDragging = true;
  }

  /**
   * Stops dragging this decoration object
   */
  public void stopDragging()
  {
    isDragging = false;
  }

  /**
   * Checks whether the mouse is over this decoration object
   * 
   * @return true if mouse is over decoration object, false if otherwise
   */
  public boolean isMouseOver()
  {
    // this if checks if the mouse's x is within the decoration's width
    if (processing.mouseX >= this.getPositionX() - this.getImage().width / 2
        && processing.mouseX <= this.getPositionX() + this.getImage().width / 2)
    {
      if (processing.mouseY >= this.getPositionY() - this.getImage().height / 2
          && processing.mouseY <= this.getPositionY() + this.getImage().height / 2)
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Moves this decoration object with dx and dy
   * 
   * @param dx move to the x-position of this decoration object
   * @param dy move to the y-position of this decoration object
   */
  public void move(int dx, int dy)
  {
    x += dx;
    y += dy;
  }

  /**
   * Draws this decoration object to the display window. This method also sets the position of this
   * object to follow the moves of the mouse if it is being dragged
   */
  public void draw()
  {
    // if the object is being dragged, this updates the position of the object
    if (isDragging)
    {
      move(processing.mouseX - oldMouseX, processing.mouseY - oldMouseY);
      oldMouseX = processing.mouseX;
      oldMouseY = processing.mouseY;
    }

    // update the image
    processing.image(image, x, y);
  }
}
