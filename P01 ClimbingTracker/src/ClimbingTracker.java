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

public class ClimbingTracker 
{
	//this is used by sendClimb and failClimb because they are so similar
	// stringArr is an oversized array, and num is the size of that array
	public static int helper (String[] stringArr, int num, String grade)
	{
		//if statement checks if the array is full, if its not it checks if the grade string is formatted correctly
		if (num != stringArr.length && grade.charAt(0) == 'V' && grade.length() == 2 && Character.isDigit(grade.charAt(1)))
		{
			stringArr[num+1] = grade;
			num++;
		}
		return num;
	}
	
	public static int sendClimb (String[] send, int numSend, String grade)
	{
		return helper(send, numSend, grade);
	}
	
	public static int failClimb (String[] fail, int numFail, String grade)
	{
		return helper(fail, numFail, grade);
	}
	
	public static String getStats (String[] send, int numSend, String[] fail, int numFail, int historyLength)
	{
		//average of climb grades to return
		double sendAvg = 0;
		double failAvg = 0;
		
		//sum of climbs grades to be divided by historylength
		double sendTotal = 0;
		double failTotal = 0;

		int sendHistory = historyLength;
		int failHistory = historyLength;
		
		//what to return
		String sendReturn = "";
		String failReturn = "";
		if (historyLength > numSend)
		{
			//System.out.println("reset numsend");
			sendHistory = numSend;
		}
		if (historyLength > numFail)
		{
			//System.out.println("reset numfail");
			failHistory = numFail;
		}
		if (historyLength > 0)
		{
			if (numSend > 0)
			{
				for (int i = 0; i < sendHistory; i++)
				{
					//idk if this will work, to test
					//assumes fail array has properly formatted grades
					sendTotal += send[numSend - 1 - i].charAt(1) - '0';
				}
				//avg calculation
				sendAvg = sendTotal/sendHistory;
				
				sendReturn = "send: " + String.valueOf(sendAvg);
			}
			else
			{
				sendReturn = "send: --";
			}
			if (numFail > 0)
			{
				for (int i = 0; i < failHistory; i++)
				{
					//idk if this will work, to test
					//assumes fail array has properly formatted grades
					failTotal += fail[numFail - 1 - i].charAt(1) - '0';
				}
				//average calculation
				failAvg = failTotal/failHistory;
				
				failReturn = "fail: " + String.valueOf(failAvg);
			}
			else
			{
				failReturn = "fail: --";
			}
			
		}
		else
		{
			sendReturn = "send: --";
			failReturn = "fail: --";
		}
		/*System.out.println("total");
		System.out.println(failTotal);
		System.out.println(sendTotal);
		System.out.println("history");
		System.out.println(failHistory);
		System.out.println(sendHistory);*/
		return sendReturn + "\n" + failReturn;
	}
	
	public static String getHistogram (String[] send, int numSend, String[] fail, int numFail)
	{
		int gradeMax = 0;
		
		String returnString = "";
		
		//checks if there is no data
		if (numSend <= 0 && numFail <= 0)
		{
			return "Error: no data to display";
		}
		
		//this finds the highest grade in either array
		//not sure if this if statement is needed
		if (numSend > 0)
		{
			for (int i = 0; i < numSend; i++)
			{
				if (send[i].charAt(1) - '0' > gradeMax)
				{
					gradeMax = send[i].charAt(1) - '0';
				}
			}
		}
		//not sure if this if statement is needed
		if (numFail > 0)
		{
			for (int i = 0; i < numFail; i++)
			{
				if (fail[i].charAt(1) - '0' > gradeMax)
				{
					gradeMax = fail[i].charAt(1) - '0';
				}
			}
		}
		//System.out.println("grademax: " + gradeMax);
		
		//this for loop creates V0-V grademax
		for (int i = 0; i < gradeMax + 1; i++)
		{
			returnString = returnString + 'V' + i + ':';
			
			for (int j = 0; j < numFail; j++)
			{
				if (fail[j].charAt(1) - '0' == i)
				{
					returnString = returnString + " -";
				}
			}
			
			for (int j = 0; j < numSend; j++)
			{
				if (send[j].charAt(1) - '0' == i)
				{
					returnString = returnString + " +";
				}
			}
			returnString = returnString + "\n";
		}
		//System.out.println("returnString:");
		//System.out.println(returnString);
		//this takes off the last \n
		return returnString.substring(0, returnString.length()-1);
	}
}
