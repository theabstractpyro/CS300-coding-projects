//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Course: CS 300 Fall 2021
//
// Author: Ash weber-campbell
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
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;


// TODO: write proper javadoc comments for each method/constructor

/**
 * 
 * @author ash WC fish class
 */
public class Fish
{
  private static PApplet processing; // PApplet object that represents the graphic
  // interface of the JunglePark application.
  private PImage image; // stores the reference to the image object of this fish.
  private float x; // represents the x-position of this fish.
  private float y; // represents the y-position of this fish.
  private int speed; // represents the swimming speed of this fish.
  private boolean isDragging; // indicated whether this fish is being dragged or not.
  private boolean isSwimming; // indicated whether this fish is swimming (moving) or not.
  private static int oldMouseX; // t stores the old x-position of the mouse.
  private static int oldMouseY; // t stores the old y-position of the mouse.

  /**
   * Creates a new fish object located at a specific (x, y) position of the display window
   * 
   * @param processing        PApplet object that represents the display window
   * @param x                 x-position of the image of this fish in the display window
   * @param y                 y-position of the image of this fish in the display window
   * @param speed             the swimming speed of this fish
   * @param fishImageFileName file name of the image of the fish to be created
   */
  public Fish(PApplet processing, float x, float y, int speed, String fishImageFileName)
  {
    Fish.processing = processing;
    this.x = x;
    this.y = y;
    this.speed = speed;
    image = processing.loadImage(fishImageFileName);
    isDragging = false;
    isSwimming = false;
  }

  //
  /**
   * Creates a new fish object positioned at the center of the display window. This constructor sets
   * the image instance field to a PImage whose file name is "images" + File.separator +
   * "orange.png" Sets speed instance field to 5 Sets the x and y position of the fish to the center
   * of the display window The created fish won't be dragging nor swimming.
   * 
   * @param processing PApplet object that represents the display window
   */
  public Fish(PApplet processing)
  {
    Fish.processing = processing;
    image = processing.loadImage("images" + File.separator + "orange.png");
    speed = 5;
    x = processing.width / 2;
    y = processing.height / 2;
    isDragging = false;
    isSwimming = false;
  }

  /**
   * getter of the image instance field
   * 
   * @return the image of type PImage of this fish
   */
  public PImage getImage()
  {
    return image;
  }

  /**
   * getter of the x-position of this fish
   * 
   * @return the x-position of this fish in the display window
   */
  public float getPositionX()
  {
    return x;
  }

  /**
   * getter of the y-position of this fish
   * 
   * @return the y-position of this fish in the display window
   */
  public float getPositionY()
  {
    return y;
  }

  /**
   * Moves this fish with dx and dy adds dx move to the x-position of this fish adds dy move to the
   * y-position of this fish
   * 
   * @param dx how much to move this fish's x by
   * @param dy how much to move this fish's y by
   */
  public void move(int dx, int dy)
  {
    x += dx;
    y += dy;
  }

  /**
   * a getter for the isDragging instance field Checks whether this fish is being dragged
   * 
   * @return true if fish is being dragged, false if not
   */
  public boolean isDragging()
  {
    return isDragging;
  }

  /**
   * Starts dragging this fish
   */
  public void startDragging()
  {
    // sets oldMouseX data field to the current x-position of the mouse
    oldMouseX = processing.mouseX;
    // sets oldMouseY data field to the current y-position of the mouse
    oldMouseY = processing.mouseY;
    // sets the isDragging data field of this fish to true
    isDragging = true;
  }

  /**
   * Stops dragging this fish
   */
  public void stopDragging()
  {
    // sets the isDragging data field of this fish to false
    isDragging = false;
  }

  /**
   * Checks if the mouse is over a specific Fish whose reference is provided as input parameter
   *
   * @param Fish reference to a specific fish
   * @return true if the mouse is over the specific Fish object (i.e. over the image of the Fish),
   *         false otherwise
   */
  public boolean isMouseOver()
  {
    // this if checks if the mouse's x is within the Fish's width
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
   * Starts swimming this fish
   */
  public void startSwimming()
  {
    // 1. stops dragging the fish
    // 2. sets the isSwimming instance field to true
    stopDragging();
    isSwimming = true;
  }

  /**
   * Stops swimming this fish
   */
  public void stopSwimming()
  {
    // Sets the isSwimming instance field of this fish to false
    isSwimming = false;
  }

  /**
   * Moves horizontally the fish one speed step from left to right
   */
  public void swim()
  {
    // The speed step is the instance field speed defined for each fish
    // The x-position of the fish is bounded by the width of the display
    // window. If the x-position of this fish exceeds the width of the display
    // window, it is going to be set to zero.
    if (x <= processing.width - speed)
    {
      // added this so it wouldn't move while swimming and trying to drag it
      if (!isDragging)
      {
        x += speed;
      }
    } else
    {
      x = processing.width % x;
    }
    // System.out.println(x);
  }

  /**
   * Draws this fish to the display window. This method sets also the position of this fish to
   * follow the moves of the mouse if it is being dragged
   */
  public void draw()
  {
    // moves the fish if it is being dragged
    if (isDragging)
    {
      move(processing.mouseX - oldMouseX, processing.mouseY - oldMouseY);
      oldMouseX = processing.mouseX;
      oldMouseY = processing.mouseY;
    }

    // makes the fish swim if its swimming
    if (isSwimming)
    {
      swim();
    }

    // updates the image
    processing.image(image, x, y);
  }

}
