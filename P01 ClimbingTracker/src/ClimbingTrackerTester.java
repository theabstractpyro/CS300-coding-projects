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

public class ClimbingTrackerTester 
{
  /**
   * this class tests SendClimb in ClimbingTracker.java
   */
	public static boolean testSendClimb()
	{
		/*System.out.println(Arrays.toString(test));
		System.out.println(ClimbingTracker.sendClimb(test, testSize, "V2"));
		*/
		String[] empty = new String[5];
		int emptySize = 0;
		
		String[] half = new String[] {"V0", "V1", "V3", null, null};
		int halfSize = 3;
		
		String[] full = new String[] {"V0", "V1", "V3", "V3", "V2"};
		int fullSize = 5;
		
		String[] test = new String[] {"V0", "V3", null, null, null};
		int testSize = 2;
		
		if (ClimbingTracker.sendClimb(empty, emptySize, "V1") != 1)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed1!");
		if (ClimbingTracker.sendClimb(half, halfSize, "V2") != 4)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed2!");
		if (ClimbingTracker.sendClimb(full, fullSize, "V4") != 5)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed3!");
		if (ClimbingTracker.sendClimb(test, testSize, "v4") != 2)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed4!");
		if (ClimbingTracker.sendClimb(test, testSize, "V43") != 2)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed5!");
		if (ClimbingTracker.sendClimb(test, testSize, "Vv") != 2)
		{
			System.out.println("Failed!");
			return false;
		}
		return true;
	}
	
	/**
	* this class tests FailClimb in ClimbingTracker.java
	*/
	public static boolean testFailClimb()
	{
		String[] empty = new String[5];
		int emptySize = 0;
		
		String[] half = new String[] {"V0", "V1", "V3", null, null};
		int halfSize = 3;
		
		String[] full = new String[] {"V0", "V1", "V3", "V3", "V2"};
		int fullSize = 5;
		
		String[] test = new String[] {"V0", "V3", null, null, null};
		int testSize = 2;
		
		if (ClimbingTracker.failClimb(empty, emptySize, "V1") != 1)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed1!");
		if (ClimbingTracker.failClimb(half, halfSize, "V2") != 4)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed2!");
		if (ClimbingTracker.failClimb(full, fullSize, "V4") != 5)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed3!");
		if (ClimbingTracker.failClimb(test, testSize, "v4") != 2)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed4!");
		if (ClimbingTracker.failClimb(test, testSize, "V43") != 2)
		{
			System.out.println("Failed!");
			return false;
		}
		System.out.println("Passed5!");
		if (ClimbingTracker.failClimb(test, testSize, "Vv") != 2)
		{
			System.out.println("Failed!");
			return false;
		}
		return true;
	}
	
	/**
	* this class tests GetStats in ClimbingTracker.java
	*/
	public static boolean testGetStats()
	{
		String[] fail1 = new String[] {"V1", "V0", "V3", "V2", null};
		int fail1size = 4;
		
		String[] send1 = new String[] {"V2", "V4", null, null, null};
		int send1size = 2;
		
		String[] fail2 = new String[] {"V0", "V1", "V3", null, null};
		int fail2size = 3;
		
		String[] send2 = new String[] {"V0", "V2", "V1", "V4", "V3"};
		int send2size = 5;
		
		String[] fail3 = new String[] {null, null, null, null, null};
		int fail3size = 0;
		
		String[] send3 = new String[] {"V0", "V2", "V3", "V4", null};
		int send3size = 4;
		
		String[] send4 = new String[] {null, null, null, null, null};
		int send4size = 0;
		
		String[] send5 = new String[] {"V0", "V1", "V0", "V2", "V0"};
		int send5size = 5;
		
		String[] fail5 = new String[] {"V3", "V3", "V3", "V2", null};
		int fail5size = 4;
		
		if(!(ClimbingTracker.getStats(send1, send1size, fail1, fail1size, 2).equals("send: 3.0\nfail: 2.5")))
		{
			System.out.println(ClimbingTracker.getStats(send1, send1size, fail1, fail1size, 2));
			System.out.println("Failed1!");
			return false;
		}
		System.out.println("Passed1!");
		
		if(!(ClimbingTracker.getStats(send2, send2size, fail2, fail2size, 5).equals("send: 2.0\nfail: 1.3333333333333333")))
		{
			System.out.println(ClimbingTracker.getStats(send2, send2size, fail2, fail2size, 5));
			System.out.println("Failed2!");
			return false;
		}
		System.out.println("Passed2!");
		
		if(!(ClimbingTracker.getStats(send3, send3size, fail3, fail3size, 0).equals("send: --\nfail: --")))
		{
			System.out.println(ClimbingTracker.getStats(send3, send3size, fail3, fail3size, 0));
			System.out.println("Failed3!");
			return false;
		}
		System.out.println("Passed3!");
		
		if(!(ClimbingTracker.getStats(send2, send2size, fail3, fail3size, 4).equals("send: 2.5\nfail: --")))
		{
			System.out.println(ClimbingTracker.getStats(send2, send2size, fail3, fail3size, 4));
			System.out.println("Failed4!");
			return false;
		}
		System.out.println("Passed4!");
		
		if(!(ClimbingTracker.getStats(send4, send4size, fail1, fail1size, 4).equals("send: --\nfail: 1.5")))
		{
			System.out.println(ClimbingTracker.getStats(send4, send4size, fail1, fail1size, 4));
			System.out.println("Failed5!");
			return false;
		}
		System.out.println("Passed5!");
		
		if(!(ClimbingTracker.getStats(send5, send5size, fail5, fail5size, 5).equals("send: 0.6\nfail: 2.75")))
		{
			System.out.println(ClimbingTracker.getStats(send5, send5size, fail5, fail5size, 5));
			System.out.println("Failed6!");
			return false;
		}
		System.out.println("Passed6!");
		
		return true;
	}
	
	/**
	* this class tests GetHistogram in ClimbingTracker.java
	*/
	public static boolean testGetHistogram()
	{
		String[] fail1 = new String[] {"V1", "V0", "V3", "V2", null};
		int fail1size = 4;
		
		String[] send1 = new String[] {"V2", "V4", null, null, null};
		int send1size = 2;
		
		String[] fail2 = new String[] {"V0", "V1", "V3", null, null};
		int fail2size = 3;
		
		String[] send2 = new String[] {"V0", "V2", "V1", "V4", "V3"};
		int send2size = 5;
		
		String[] fail3 = new String[] {null, null, null, null, null};
		int fail3size = 0;
		
		String[] send3 = new String[] {"V0", "V2", "V3", "V4", null};
		int send3size = 4;
		
		String[] send4 = new String[] {null, null, null, null, null};
		int send4size = 0;
		
		String[] send5 = new String[] {"V0", "V1", "V0", "V2", "V0"};
		int send5size = 5;
		
		String[] fail5 = new String[] {"V3", "V3", "V3", "V2", null};
		int fail5size = 4;
		
		if(!(ClimbingTracker.getHistogram(send1, send1size, fail1, fail1size).equals("V0: -\nV1: -\nV2: - +\nV3: -\nV4: +")))
		{
			System.out.println(ClimbingTracker.getHistogram(send1, send1size, fail1, fail1size));
			System.out.println("Failed1!");
			return false;
		}
		System.out.println("Passed1!");
		
		if(!(ClimbingTracker.getHistogram(send4, send4size, fail2, fail2size).equals("V0: -\nV1: -\nV2:\nV3: -")))
		{
			System.out.println(ClimbingTracker.getHistogram(send4, send4size, fail2, fail2size));
			System.out.println("Failed2!");
			return false;
		}
		System.out.println("Passed2!");
		
		if(!(ClimbingTracker.getHistogram(send4, 0, send4, 0).equals("Error: no data to display")))
		{
			System.out.println(ClimbingTracker.getHistogram(send4, 0, send4, 0));
			System.out.println("Failed3!");
			return false;
		}
		System.out.println("Passed3!");
		
		if(!(ClimbingTracker.getHistogram(send1, send1size, fail1, fail1size).equals("V0: -\nV1: -\nV2: - +\nV3: -\nV4: +")))
		{
			System.out.println(ClimbingTracker.getHistogram(send1, send1size, fail1, fail1size));
			System.out.println("Failed4!");
			return false;
		}
		System.out.println("Passed4!");
		
		return true;
	}
	
	/**
	* this class runs all the other tests in ClimbingTrackerTester.java
	*/
	public static boolean runAllTests()
	{
		if(!testSendClimb())
		{
			System.out.println("Failed testSendClimb!");
			return false;
		}
		System.out.println("passed testSendClimb!");
		
		if(!testFailClimb())
		{
			System.out.println("Failed testFailClimb!");
			return false;
		}
		System.out.println("passed testFailClimb!");
		
		if(!testGetStats())
		{
			System.out.println("Failed testGetStats!");
			return false;
		}
		System.out.println("passed testGetStats!");
		
		if(!testGetHistogram())
		{
			System.out.println("Failed testGetHistogram!");
			return false;
		}
		System.out.println("passed testGetHistogram!");
		System.out.println("passed all!");
		
		return true;
	}
	
	public static void main(String[] args)
	{
		runAllTests();
	}
}
