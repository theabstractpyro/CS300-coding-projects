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

import java.util.Random;

/**
 * lockBox class, to be hacked
 * 
 * @author ash WC
 *
 */
public class LockBox
{
  protected static Random randGen;
  private String password;
  private boolean isOpen;

  /**
   * Initializes randGen if it hasn't been, and sets the password to a random number with the length
   * of passwordLength
   * 
   * @param passwordLength length of the randomly generated password
   */
  public LockBox(int passwordLength)
  {

    if (randGen == null)
    {
      randGen = new Random();
      // System.out.println("new rand");
    }
    if (passwordLength <= 0)
    {
      throw new IllegalArgumentException("Invalid password length");
    }
    char[] chars = new char[passwordLength];

    for (int i = 0; i < passwordLength; i++)
    {
      chars[i] = (char) (randGen.nextInt(10) + '0');
    }
    password = String.valueOf(chars);
  }

  /**
   * checks the guess against the stored pass, sets isOpen to true if they are the same
   * 
   * @param guess password guess
   */
  public void authenticate(String guess)
  {
    // System.out.println("pass = " + password);
    if (guess.equals(password))
    {
      // System.out.println("isOpen = true");
      isOpen = true;
    }
  }

  /**
   * returns the password in plain text
   * 
   * @return the password in plain text
   */
  public String hackMe()
  {
    return password;
  }

  /**
   * isOpen getter
   * 
   * @return isOpen
   */
  public boolean isOpen()
  {
    return isOpen;
  }

  /**
   * sets isOpen to false
   */
  public void reset()
  {
    isOpen = false;
  }
}
