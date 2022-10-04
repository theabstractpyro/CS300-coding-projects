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

import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * @author ash WC this is the FishTank program from P02
 */
public class FishTank
{
  private static PApplet processing; // PApplet object that represents the graphic interface of the
                                     // JunglePark application
  private static PImage backgroundImage; // PImage object that represents the background image
  private static Fish[] fishes; // perfect size array storing the different fish present in the fish
                                // tank. These fish can be of different species.
  private static Random randGen; // Generator of random numbers circular indexed array of fish
                                 // images names
  private static String[] images = new String[]
  {"orange.png", "blue.png", "yellow.png", "black.png"}; // string array of fish image file names
  private static int nextImageIndex; // index of next fish image index in fishes
  private static int fishSpeed; // speed of our fishes
  private static Decoration[] decorations; // array storing the decoration objects present in the
                                           // tank

  /**
   * Defines the initial environment properties of this application
   * 
   * @param processingObj a reference to the graphic display window of this application
   */
  public static void setup(PApplet processingObj)
  {
    processing = processingObj;

    // speed of all the fishes in fishes
    fishSpeed = 5;

    // creates decorations array and adds 4 decorations
    decorations = new Decoration[4];
    decorations[0] = new Decoration(processing, 430, 60, "images" + File.separator + "flower.png");
    decorations[1] = new Decoration(processing, 580, 470, "images" + File.separator + "log.png");
    decorations[2] = new Decoration(processing, 65, 520, "images" + File.separator + "shell.png");
    decorations[3] = new Decoration(processing, 280, 535, "images" + File.separator + "ship.png");
    fishes = new Fish[8];
    randGen = new Random();

    // load the image of the background
    backgroundImage = processing.loadImage("images/background.png");
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed()
  {
    breakAll:
    {
      // sets isdragging to true for fishes array
      for (int i = 0; i < fishes.length; i++)
      {
        if (fishes[i] != null)
        {
          if (fishes[i].isMouseOver())
          {
            fishes[i].startDragging();
            break breakAll;
          }
        }
      }
      // sets isdragging to true for decorations array
      for (int i = 0; i < decorations.length; i++)
      {
        if (decorations[i] != null)
        {
          if (decorations[i].isMouseOver())
          {
            decorations[i].startDragging();
            break breakAll;
          }
        }
      }
    }
  }

  /**
   * Callback method called each time the mouse is released
   */
  public static void mouseReleased()
  {
    // sets isdragging to false for fishes array
    for (int i = 0; i < fishes.length; i++)
    {
      if (fishes[i] != null)
      {
        fishes[i].stopDragging();
      }
    }
    // sets isdragging to false for decorations array
    for (int i = 0; i < decorations.length; i++)
    {
      if (decorations[i] != null)
      {
        if (decorations[i].isMouseOver())
        {
          decorations[i].stopDragging();
        }
      }
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed()
  {
    // add fish with F key
    if (processing.key == 'f' || processing.key == 'F')
    {
      for (int i = 0; i < fishes.length; i++)
      {
        if (fishes[i] == null)
        {
          fishes[i] = new Fish(processing, (float) randGen.nextInt(processing.width),
              (float) randGen.nextInt(processing.height), fishSpeed,
              "images" + File.separator + images[nextImageIndex]);
          nextImageIndex++;
          if (nextImageIndex >= images.length)
          {
            nextImageIndex = 0;
          }
          break;
        }
      }
    }
    // remove fish with r key
    if (processing.key == 'r' || processing.key == 'R')
    {
      for (int i = 0; i < fishes.length; i++)
      {
        // checks if the spot at index i has a fish in it, and if the mouse is over it
        if (fishes[i] != null && fishes[i].isMouseOver())
        {
          fishes[i] = null;
          break;
        }
      }
    }
    // start swimming with the s key
    if (processing.key == 's' || processing.key == 'S')
    {
      for (int i = 0; i < fishes.length; i++)
      {
        if (fishes[i] != null)
        {
          fishes[i].startSwimming();
        }
      }
    }
    // stop swimming with the x key
    if (processing.key == 'x' || processing.key == 'X')
    {
      for (int i = 0; i < fishes.length; i++)
      {
        if (fishes[i] != null)
        {
          fishes[i].stopSwimming();
        }
      }
    }
  }

  /**
   * Draws and updates the application display window. This callback method called in an infinite
   * loop.
   */
  public static void draw()
  {
    // Draw the background image at the center of the screen
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    // width [resp. height]: System variable of the processing library that stores
    // the width [resp. height] of the display window.

    // loops through decorations array and draws everything in the array
    for (int i = decorations.length - 1; i >= 0; i--)
    {
      if (decorations[i] != null)
      {
        decorations[i].draw();
      }
    }

    // for loop cycles backwards through array. this makes it so that if you click on overlapping
    // fishes,
    // the one on top is dragged,while still following the rules set forth in the guide
    for (int i = fishes.length - 1; i >= 0; i--)
    {
      if (fishes[i] != null)
      {
        fishes[i].draw();
      }
    }
  }


  public static void main(String[] args)
  {
    Utility.startApplication(); // starts the application
  }

}
