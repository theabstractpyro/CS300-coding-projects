//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    this program creates a window with a fish tank in it, and the user can add and move fishes around in the tank
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

//fish class documentation can be found here: (ctrl click)
//https://cs300-www.cs.wisc.edu/wp/wp-content/uploads/2020/12/fall2021/p2/doc/Fish.html

//P02 can be found here: (I'm on step 3)
//https://cs300-www.cs.wisc.edu/wp/wp-content/uploads/2020/12/fall2021/p2/p02FishTank1000.pdf

import java.util.Random;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class FishTank 
{
  private static PApplet processing; // PApplet object that represents the graphic
  //interface of the JunglePark application
  private static PImage backgroundImage; // PImage object that represents the
  //background image
  private static Fish[] fishes; // perfect size array storing the different fish present
  //in the fish tank. These fish can be of different species.
  private static Random randGen; // Generator of random numbers
  
  /**
  * Defines the initial environment properties of this application
  * @param processingObj a reference to the graphic display window of this application
  */
  public static void setup(PApplet processingObj) 
  {
    processing = processingObj;
    
    //do in need Fish[] before this?
    fishes = new Fish[8];
    // do i need Random before this?
    randGen = new Random();
    
    // load the image of the background
    backgroundImage = processing.loadImage("images/background.png");
  }
  
  /**
  * Checks if the mouse is over a specific Fish whose reference is provided
  * as input parameter
  *
  * @param Fish reference to a specific fish
  * @return true if the mouse is over the specific Fish object (i.e. over
  * the image of the Fish), false otherwise
  */
  public static boolean isMouseOver(Fish Fish) 
  {
    //this if checks if the mouse's x is within the Fish's width
    if (processing.mouseX >= Fish.getPositionX() - Fish.getImage().width / 2 && processing.mouseX <= Fish.getPositionX() + Fish.getImage().width / 2)
    {
      if (processing.mouseY >= Fish.getPositionY() - Fish.getImage().height / 2 && processing.mouseY <= Fish.getPositionY() + Fish.getImage().height / 2)
      {
        return true;
      }
    }
    return false;
  }

  /**
  * Callback method called each time the user presses the mouse
  */
  public static void mousePressed() 
  {
    for (int i = 0; i < fishes.length; i++)
    {
      if (fishes[i] != null)
      {
        if (isMouseOver(fishes[i]))
        {
          fishes[i].setDragging(true);
          break;
        }
      }
    }
  }
  
  /**
  * Callback method called each time the mouse is released
  */
  public static void mouseReleased() 
  {
    for (int i = 0; i < fishes.length; i++)
    {
      if (fishes[i] != null)
      {
        fishes[i].setDragging(false);
      }
    }
  }
  
  /**
  * Callback method called each time the user presses a key
  */
  public static void keyPressed() 
  {
    //add fish with F key
    if (processing.key == 'f' || processing.key == 'F')
    {
      for (int i = 0; i < fishes.length; i++)
      {
        if (fishes[i] == null)
        {
          fishes[i] = new Fish(processing, (float)randGen.nextInt(processing.width), (float)randGen.nextInt(processing.height));
          break;
        }
      }
    }
    //remove fish with r key
    if (processing.key == 'r' || processing.key == 'R')
    {
      for (int i = 0; i < fishes.length; i++)
      {
        //checks if the spot at index i has a fish in it, and if the mouse is over it
        if (fishes[i] != null && isMouseOver(fishes[i]))
        {
          fishes[i] = null;
          break;
        }
      }
    }
  }
  
  /**
  * Draws and updates the application display window.
  * This callback method called in an infinite loop.
  */
  public static void draw() 
  {
    // Draw the background image at the center of the screen
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    // width [resp. height]: System variable of the processing library that stores
    // the width [resp. height] of the display window.
    
    //for loop cycles backwards through array. this makes it so that if you click on overlapping fishes,
    //the one on top is dragged,while still following the rules set forth in the guide
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
