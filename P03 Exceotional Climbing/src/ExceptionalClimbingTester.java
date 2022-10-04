//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    (descriptive title of the program making use of this file)
// Course:   CS 300 Fall 2021
//
// Author:   Ash weber-campbell
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
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.zip.DataFormatException;

public class ExceptionalClimbingTester 
{
    /**
     * Tests sendClimb method
     * @return false if the tests failed, true if they succeeded
     */
	public static boolean testSendClimb()
	{
		String[] empty = new String[5];
		int emptySize = 0;
		
		String[] full = new String[] {"V0", "V1", "V3", "V3", "V2"};
		int fullSize = 5;
		
		String[] test = new String[] {"V0", "V3", null, "V2", null};
		int testSize = 4;
				
		//test valid input
		try
		{
			ExceptionalClimbing.sendClimb(empty, emptySize, "V3");
		}
		catch (Exception excpt)
		{
			System.out.println("other Exception: " + excpt.getMessage());
			System.out.println("failed: gave exception with valid input");
			return false;
		}
		//test invalid oversize array
		try
		{
			ExceptionalClimbing.sendClimb(test, testSize, "V2");
			return false;
		}
		catch (DataFormatException excpt)
		{
			System.out.println("DataFormatException: " + excpt.getMessage());
			if (!excpt.getMessage().equals("invalid oversize array"))
			{
				System.out.println("failed: wrong message");
				return false;
			}
		}
		catch (Exception excpt)
		{
			System.out.println("other Exception: " + excpt.getMessage());
			return false;
		}
		//test invalid grade
		try
		{
			ExceptionalClimbing.sendClimb(empty, emptySize, "V8");
			return false;
		}
		catch (IllegalArgumentException excpt)
		{
			System.out.println("IllegalArgumentException: " + excpt.getMessage());
			if (!excpt.getMessage().equals("V8 is not a valid grade"))
			{
				System.out.println("failed: wrong message");
				return false;
			}
		}
		catch (Exception excpt)
		{
			System.out.println("other Exception: " + excpt.getMessage());
			return false;
		}
		//test full array
		try
		{
			ExceptionalClimbing.sendClimb(full, fullSize, "V3");
			return false;
		}
		catch (IllegalArgumentException excpt)
		{
			System.out.println("IllegalArgumentException: " + excpt.getMessage());
			if (!excpt.getMessage().equals("cannot add new value to full length 5 array"))
			{
				return false;
			}
		}
		catch (Exception excpt)
		{
			System.out.println("other test: " + excpt.getMessage());
			return false;
		}
		
		return true;
	}
	
	/**
	 * Tests failClimb method
	 * @return false if the tests failed, true if they succeeded
	 */	
	public static boolean testFailClimb()
	{
	  String[] empty = new String[5];
      int emptySize = 0;
      
      String[] full = new String[] {"V0", "V1", "V3", "V3", "V2"};
      int fullSize = 5;
      
      String[] test = new String[] {"V0", "V3", null, "V2", null};
      int testSize = 4;
              
      //test valid input
      try
      {
          ExceptionalClimbing.failClimb(empty, emptySize, "V3");
      }
      catch (Exception excpt)
      {
          System.out.println("other Exception: " + excpt.getMessage());
          System.out.println("failed: gave exception with valid input");
          return false;
      }
      //test invalid oversize array
      try
      {
          ExceptionalClimbing.failClimb(test, testSize, "V2");
          return false;
      }
      catch (DataFormatException excpt)
      {
          System.out.println("DataFormatException: " + excpt.getMessage());
          if (!excpt.getMessage().equals("invalid oversize array"))
          {
              System.out.println("failed: wrong message");
              return false;
          }
      }
      catch (Exception excpt)
      {
          System.out.println("other Exception: " + excpt.getMessage());
          return false;
      }
      //test invalid grade
      try
      {
          ExceptionalClimbing.failClimb(empty, emptySize, "V8");
          return false;
      }
      catch (IllegalArgumentException excpt)
      {
          System.out.println("IllegalArgumentException: " + excpt.getMessage());
          if (!excpt.getMessage().equals("V8 is not a valid grade"))
          {
              System.out.println("failed: wrong message");
              return false;
          }
      }
      catch (Exception excpt)
      {
          System.out.println("other Exception: " + excpt.getMessage());
          return false;
      }
      //test full array
      try
      {
          ExceptionalClimbing.failClimb(full, fullSize, "V3");
          return false;
      }
      catch (IllegalArgumentException excpt)
      {
          System.out.println("IllegalArgumentException: " + excpt.getMessage());
          if (!excpt.getMessage().equals("cannot add new value to full length 5 array"))
          {
              return false;
          }
      }
      catch (Exception excpt)
      {
          System.out.println("other test: " + excpt.getMessage());
          return false;
      }
      
      return true;
	}
	
	/**
	 * tests getStats method
	 * @return false if the tests failed, true if they succeeded
	 */
	public static boolean testGetStats()
	{
		return true;
	}
	
	/**
	 * tests getHistogram method
	 * @return false if the tests failed, true if they succeeded
	 */
	public static boolean testGetHistogram()
	{
		return true;
	}
	
	/**
	 * runs all tests in ExceptionalClimbingTester
	 * @return false if the tests failed, true if they succeeded
	 */
	public static boolean runAllTests() 
	{
		if(!testSendClimb()) return false;
		System.out.println("testSendClimb passed");
		if(!testFailClimb()) return false;
		System.out.println("testFailClimb passed");
		if(!testGetStats()) return false;
		System.out.println("testGetStats passed");
		if(!testGetHistogram()) return false;
		System.out.println("testGetHistogram passed");
		return true;
	}
	public static void main(String[] args) 
	{
		runAllTests();
	}

}
