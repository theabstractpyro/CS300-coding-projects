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
 * passwordHacker class, which hacks the lockBox
 * 
 * @author ash wc
 *
 */
public class PasswordHacker
{
  private LockBox toPick;
  private int passwordLength;

  /**
   * This constructor should store the provided password length for future reference and create a
   * new LockBox with a password of the same length.
   * 
   * @param passwordLength int to store
   */
  public PasswordHacker(int passwordLength)
  {
    this.passwordLength = passwordLength;
    toPick = new LockBox(passwordLength);
  }

  /**
   * Complexity: O(1)
   * 
   * First, the method resets the LockBox so that you have something to hack into. Next, the method
   * asks it for the password. Finally, the method uses the password to open the LockBox.
   */
  public void hack()
  {
    toPick.reset();
    toPick.authenticate(toPick.hackMe());
  }

  /**
   * Complexity: O(N)
   * 
   * uses generateGuess() to guess automatically until lockbox opens
   */
  public void bruteForce()
  {
    int count = 0;
    toPick.reset();
    while (!toPick.isOpen())
    {
      toPick.authenticate(generateGuess(count));
      count++;
    }
  }

  /**
   * creates a guess at the password
   * 
   * @param count the number of times it has guessed
   * @return a password guess
   */
  public String generateGuess(int count)
  {
    String guess = "";

    for (int i = 0; i < passwordLength; i++)
    {
      guess = (count % 10) + guess;
      count = count / 10;
    }

    // System.out.println(guess);
    return guess;
  }
}
