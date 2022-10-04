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
 * benchmarker class, which benchmarks the time it takes for passwordHacker to run
 * 
 * @author ash wc
 *
 */
public class Benchmarker
{

  /**
   * returns the time it took for ph's bruteForce() method to run
   * 
   * @param ph PasswordHacker to test
   * @return the time it took for bruteForce() to run
   */
  public static long timeBruteForce(PasswordHacker ph)
  {
    long time1 = System.currentTimeMillis();
    ph.bruteForce();
    long time2 = System.currentTimeMillis() - time1;
    return time2;
  }

  /**
   * returns the time it took for ph's hack() method to run
   * 
   * @param ph PasswordHacker to test
   * @return the time it took for hack() to run
   */
  public static long timeHack(PasswordHacker ph)
  {
    long time1 = System.currentTimeMillis();
    ph.hack();
    long time2 = System.currentTimeMillis() - time1;
    return time2;
  }

  /**
   * Race the two approaches against each other, using the previous two methods. calculates the MEAN
   * (average) time for each method over numRuns runs
   * 
   * @param passwordLength the length of the password to use for LockBox
   * @param numRuns        the number of runs to get the adverage time from
   * @return the results of this race as a String with the following format: "Brute force N:
   *         time\nHack N: time"
   */
  public static String race(int passwordLength, int numRuns)
  {
    long bfTime = 0; // time it took for bruteForce to run
    long hTime = 0; // time it took for hack to run

    for (int i = 0; i < numRuns; i++)
    {
      bfTime += timeBruteForce(new PasswordHacker(passwordLength));
      hTime += timeHack(new PasswordHacker(passwordLength));
    }

    bfTime = bfTime / numRuns;
    hTime = hTime / numRuns;

    return "Brute force " + passwordLength + ": " + bfTime + "\nHack " + passwordLength + ": "
        + hTime;
  }

  /**
   * main method
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    // System.out.print(race(6, 2));
  }

}
