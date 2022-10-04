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
import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * FishTank class, this creates the window with the fish tank in it
 *
 * @author Ash W-C
 */
public class FishTank extends PApplet
{
  private PImage backgroundImage; // PImage object which represents the background image
  protected ArrayList<TankListener> objects; // list storing interactive objects
  protected Random randGen; // Generator of random numbers

  private TankObject flower;
  private TankObject log;
  private TankObject shell;
  private TankObject ship;

  /**
   * sets the size of this PApplet to 800 width x 600 height
   */
  @Override
  public void settings()
  {
    size(800, 600);
  }

  /**
   * Defines initial environment properties such as screen size and loads the background image and
   * fonts as the program starts. It also initializes all data fields.
   */
  @Override
  public void setup()
  {
    // Set and display the title of the display window
    this.getSurface().setTitle("Fish Tank 3000");
    // Set the location from which images are drawn to CENTER
    this.imageMode(PApplet.CENTER);
    // Set the location from which rectangles are drawn.
    this.rectMode(PApplet.CORNERS);
    // rectMode(CORNERS) interprets the first two parameters of rect() method
    // as the location of one corner, and the third and fourth parameters as
    // the location of the opposite corner.
    // rect() method draws a rectangle to the display window

    this.focused = true; // Confirms that our Processing program is focused,
    // meaning that it is active and will accept mouse or keyboard input.

    // sets the text alignment to center
    this.textAlign(PApplet.CENTER, PApplet.CENTER);

    // TODO load the background image and store the loaded image to backgroundImage
    // Note that you can call the loadImage() method directly (this.loadImage())
    backgroundImage = loadImage("images" + File.separator + "background.png");

    // TODO create an empty array list of objects
    objects = new ArrayList<TankListener>();

    // TODO set randGen to the reference of a new Random objects
    randGen = new Random();

    TankObject.setProcessing(this);
    Button.setProcessing(this);

    // adds buttons to objects array
    objects.add(new AddBlueFishButton(42, 16));
    objects.add(new AddOrangeFishButton(129, 16));
    objects.add(new AddYellowFishButton(215, 16));
    objects.add(new ClearTankButton(301, 16));

    // declares decorations
    flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
    log = new TankObject(580, 470, "images" + File.separator + "log.png");
    shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
    ship = new TankObject(280, 535, "images" + File.separator + "ship.png");

    // adds decorations to objects array
    objects.add(flower);
    objects.add(log);
    objects.add(shell);
    objects.add(ship);

    // adds 2 black fish to objects array
    objects.add(new BlackFish(log, flower));
    objects.add(new BlackFish(shell, flower));
  }

  /**
   * Continuously draws and updates the application display window
   * 
   */
  @Override
  public void draw()
  {
    // TODO clear the display window by drawing the background image
    image(backgroundImage, width / 2, height / 2);

    // TODO traverse the objects list and draw each of the objects to this display
    // window
    for (int i = 0; i < objects.size(); i++)
    {
      objects.get(i).draw();
    }
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  @Override
  public void mousePressed()
  {
    // TODO traverse the objects list and call mousePressed method
    // of the first object being clicked in the list
    for (int i = 0; i < objects.size(); i++)
    {
      if (objects.get(i).isMouseOver())
      {
        objects.get(i).mousePressed();
        return;
        // only the fish at the lowest index will call mousePressed if there are fishes or other
        // objects
        // overlapping
      }
    }

  }

  /**
   * Callback method called each time the mouse is released
   */
  @Override
  public void mouseReleased()
  {
    // TODO traverse the objects list and call each object's mouseReleased() method
    for (int i = 0; i < objects.size(); i++)
      objects.get(i).mouseReleased();
  }

  /**
   * adds an instance of TankListener passed as input to the objects arraylist
   * 
   * @param object adds object to objects arraylist
   */
  public void addObject(TankListener object)
  {
    objects.add(object);
  }

  /**
   * Callback method called each time the user presses a key
   */
  @Override
  public void keyPressed()
  {
    switch (Character.toUpperCase(key))
    {
      case 'O': // adds a new orange fish to arraylist
        objects.add(new Fish());
        break;
      case 'Y': // adds a new yellow fish to arraylist
        objects.add(new Fish(2, "images" + File.separator + "yellow.png"));
        break;
      case 'R': // removes selected fish, if the mouse is over any
        for (int i = 0; i < objects.size(); i++)
        {
          if (objects.get(i).isMouseOver() && objects.get(i) instanceof Fish)
          {
            objects.remove(i);
            break;
          }
        }
        break;
      case 'S': // start swimming
        for (int i = 0; i < objects.size(); i++)
        {
          if (objects.get(i) instanceof Fish)
          {
            // downcasts to fish
            ((Fish) objects.get(i)).startSwimming();
          }
        }
        break;
      case 'X': // freeze (stop swimming)
        for (int i = 0; i < objects.size(); i++)
        {
          if (objects.get(i) instanceof Fish)
          {
            // downcasts to fish
            ((Fish) objects.get(i)).stopSwimming();
          }
        }
        break;
      case 'C': // clears all fish from the tank
        this.clear();
        break;
      case 'B':
        objects.add(new BlueFish());
    }
  }

  /**
   * Removes instances of the class Fish from this tank
   */
  public void clear()
  {
    for (int i = 0; i < objects.size(); i++)
    {
      if (objects.get(i) instanceof Fish)
      {
        objects.remove(i);
        i--;
      }
    }
  }

  /**
   * main method
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    PApplet.main("FishTank"); // do not add any other statement to the main method
    // The PApplet.main() method takes a String input parameter which represents
    // the name of your PApplet class.
  }

}
