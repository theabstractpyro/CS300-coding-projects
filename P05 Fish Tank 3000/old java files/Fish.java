//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Fall 2020
//
// Author:   Ash Weber-Campbell
// Email:    webercampbel@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Class Header comes here
 *
 */
public class Fish {

  private static PApplet processing; // PApplet object that represents the display window

  private PImage image; // fish's image

  private int speed; // swimming speed of this fish
  private float x; // x-position of this fish in the display window
  private float y; // y-position of this fish in the display window

  private boolean isDragging; // indicates whether this fish is being dragged or not
  private boolean isSwimming; // indicates whether this fish is swimming or not

  private static int oldMouseX; // old x-position of the mouse
  private static int oldMouseY; // old y-position of the mouse


  /**
   * Creates a new fish object positioned at the center of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Fish(PApplet processing) {
    this(processing, processing.width / 2.0f, processing.height / 2.0f, 5,
        "images" + File.separator + "orange.png");

  }

  /**
   * Creates a new fish object positioned at a specific position of the display window
   * 
   * @param processing        PApplet object that represents the display window
   * @param x                 x-coordinate of the image of this fish in the display window
   * @param y                 y-coordinate of the image of this fish in the display window
   * @param speed             the swimming speed of this fish
   * @param fishImageFileName file name of the image of this fish
   */
  public Fish(PApplet processing, float x, float y, int speed, String fishImageFileName) {
    // Set fish draw parameters
    Fish.processing = processing; // set the PApplet Object where this fish will be drawn
    this.image = processing.loadImage(fishImageFileName);
    // sets the position of this fish
    this.x = x;
    this.y = y;
    this.speed = speed;
    isDragging = false; // initially the fish is not dragging
  }

  /**
   * Draws this fish to the display window.
   */
  public void draw() {
    // if the fish is dragging, set its position to follow the mouse moves
    if (this.isDragging) {
      int dx = processing.mouseX - oldMouseX;
      int dy = processing.mouseY - oldMouseY;
      move(dx, dy);
      oldMouseX = processing.mouseX;
      oldMouseY = processing.mouseY;
    }
    // if the fish is swimming, call its swim() method
    if (isSwimming) {
      swim();
    }
    // draw the fish at its current position
    processing.image(this.image, this.x, y);

  }


  /**
   * Moves this fish with dx and dy
   * 
   * @param dx move to the x-position of this fish
   * @param dy move to the y-position of this fish
   */
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }


  /**
   * Returns the image of this fish
   * 
   * @return the image of type PImage of the fish object
   */
  public PImage getImage() {
    return image;
  }


  /**
   * Returns the x-position of this fish in the display window
   * 
   * @return the X coordinate of the fish position
   */
  public float getPositionX() {
    return x;
  }

  /**
   * Returns the y-position of this fish in the display window
   * 
   * @return the Y coordinate of the fish position
   */
  public float getPositionY() {
    return y;
  }

  /**
   * Checks whether this fish is being dragged
   * 
   * @return true if the fish is being dragged, false otherwise
   */
  public boolean isDragging() {
    return isDragging;
  }

  /**
   * Starts dragging this fish
   * 
   */
  public void startDragging() {
    oldMouseX = processing.mouseX;
    oldMouseY = processing.mouseY;
    this.isDragging = true;
  }

  /**
   * Stops dragging this fish
   * 
   */
  public void stopDragging() {
    this.isDragging = false;
  }

  /**
   * Starts swimming this fish
   * 
   */
  public void startSwimming() {
    this.stopDragging();
    this.isSwimming = true;
  }

  /**
   * Stops swimming this fish
   * 
   */
  public void stopSwimming() {
    this.isSwimming = false;
  }

  /**
   * Checks if the mouse is over this fish
   * 
   * @return true if the mouse is over this fish object (i.e. over the image of this fish), false
   *         otherwise
   */
  public boolean isMouseOver() {
    int fishWidth = image.width;
    int fishHeight = image.height;

    // checks if the mouse is over this fish
    return processing.mouseX >= x - fishWidth / 2 && processing.mouseX <= x + fishWidth / 2
        && processing.mouseY >= y - fishHeight / 2 && processing.mouseY <= y + fishHeight / 2;
  }

  /**
   * Moves horizontally the fish one speed step from left to right. Note that x-position of the fish
   * is bounded by the width of the display window. If the x-position of this fish reaches the width
   * of the display window, it is going to be set to zero. You may think of using the modulo
   * operator.
   */
  public void swim() {
    
  }

}