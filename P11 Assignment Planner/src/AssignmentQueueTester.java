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

import java.util.NoSuchElementException;

/*
 * import java.util.List; import java.util.Arrays;
 */

/**
 * Tester class for the AssignmentQueue implementation of PriorityQueueADT
 */
public class AssignmentQueueTester
{
  /**
   * Tests the functionality of the constructor for AssignmentQueue Should implement at least the
   * following tests:
   *
   * - Calling the AssignmentQueue with an invalid capacity should throw an IllegalArgumentException
   * - Calling the AssignmentQueue with a valid capacity should not throw any errors, and should
   * result in a new AssignmentQueue which is empty, and has size 0
   *
   * @return true if the constructor of AssignmentQueue functions properly
   * @see AssignmentQueue#AssignmentQueue(int)
   */
  public static boolean testConstructor()
  {
    try
    {
      AssignmentQueue AQ1 = new AssignmentQueue(-1); // should throw an Exception
      return false;
    } catch (IllegalArgumentException e)
    {
      // expected
    } catch (Exception e)
    {
      return false; // shouldn't throw any other Exception
    }
    try
    {
      AssignmentQueue AQ2 = new AssignmentQueue(5); // should not throw an Exception
      if (!AQ2.isEmpty())
      {
        return false;
      }
      if (AQ2.size() != 0)
      {
        return false;
      }
    } catch (IllegalArgumentException e)
    {
      return false; // shouldn't throw any other Exception
    } catch (Exception e)
    {
      return false; // shouldn't throw any other Exception
    }

    return true;
  }

  /**
   * Tests the functionality of the enqueue() and peek() methods Should implement at least the
   * following tests:
   *
   * - Calling peek on an empty queue should throw a NoSuchElementException - Calling enqueue on a
   * queue which is empty should add the Assignment, and increment the size of the queue - Calling
   * enqueue on a non-empty queue should add the Assignment at the proper position, and increment
   * the size of the queue. Try add at least 5 assignments - Calling peek on a non-empty queue
   * should always return the Assignment with the earliest due date - Calling enqueue on a full
   * queue should throw an IllegalStateException - Calling enqueue with a null Assignment should
   * throw a NullPointerException
   *
   * @return true if AssignmentQueue.enqueue() and AssignmentQueue.peek() function properly
   */
  public static boolean testEnqueue()
  {
    try
    {
      // creates new variables
      AssignmentQueue AQ1 = new AssignmentQueue(10);
      AssignmentQueue AQ2 = new AssignmentQueue(5);

      Assignment a1 = new Assignment("one", 1, 1, 1);
      Assignment a2 = new Assignment("two", 2, 2, 2);
      Assignment a3 = new Assignment("three", 3, 3, 3);
      Assignment a4 = new Assignment("four", 4, 4, 4);
      Assignment a5 = new Assignment("five", 5, 5, 5);
      Assignment a6 = null;

      // Calling peek on an empty queue should throw a NoSuchElementException
      try
      {
        AQ1.peek(); // should throw a NoSuchElementException, AQ1 is empty
        return false; // shouldn't be reached
      } catch (NoSuchElementException e)
      {
        // Expected
      } catch (Exception e) // if a different Exception is thrown, return false
      {
        e.printStackTrace(System.out);
        return false; // shouldn't throw any other Exception
      }

      // Calling enqueue on a queue which is empty should add the Assignment, and increment the size
      // of the queue
      AQ1.enqueue(a1);
      // AQ1 should have one assignment in it and size should be one
      if (AQ1.size() != 1)
      {
        return false;
      }
      if (AQ1.peek() != a1)
      {
        System.out.println("1");
        return false;
      }

      // Calling enqueue on a non-empty queue should add the Assignment at the proper position, and
      // increment the size of the queue. Try add at least 5 assignments
      // clears queue
      AQ1.clear();
      // fills queue
      AQ1.enqueue(a2);
      AQ1.enqueue(a5);
      AQ1.enqueue(a3);
      AQ1.enqueue(a1);
      AQ1.enqueue(a4);

      // checks if everything is where it should be
      if (!AQ1.toString().equals(
          "one (Due 01-01 1AM)\ntwo (Due 02-02 2AM)\nthree (Due 03-03 3AM)\nfive (Due 05-05 5AM)\nfour (Due 04-04 4AM)\n"))
      {
        return false;
      }



      // Calling peek on a non-empty queue should always return the Assignment with the earliest due
      // date
      // clears queue
      AQ1.clear();
      // fills queue
      AQ1.enqueue(a5);
      AQ1.enqueue(a4);
      AQ1.enqueue(a3);
      AQ1.enqueue(a2);
      AQ1.enqueue(a1);

      // if peek doesn't return the newest assignment, return false
      if (AQ1.peek() != a1)
      {
        return false;
      }

      // checks that it doesn't remove a1 from AQ1
      if (AQ1.peek() != a1)
      {
        return false;
      }

      // Calling enqueue on a full queue should throw an IllegalStateException
      // fills queue
      try
      {
        AQ2.enqueue(a1);
        AQ2.enqueue(a2);
        AQ2.enqueue(a3);
        AQ2.enqueue(a4);
        AQ2.enqueue(a5);
      } catch (Exception e)
      {
        e.printStackTrace(System.out);
        // an error thrown when none expected
        return false;
      }
      // checks if adding to a full queue throws a IllegalStateException
      try
      {
        AQ2.enqueue(a1); // should throw an error, added more than the max to AQ2
      } catch (IllegalStateException e)
      {
        // Expected
      } catch (Exception e)
      {
        e.printStackTrace(System.out);
        // wrong error thrown
        return false;
      }

      // Calling enqueue with a null Assignment should throw a NullPointerException
      try
      {
        AQ2.enqueue(a6); // should throw an error, adding null Assignment
      } catch (NullPointerException e)
      {
        // Expected
      } catch (Exception e)
      {
        e.printStackTrace(System.out);
        // wrong error thrown
        return false;
      }
    } catch (Exception e)
    {
      e.printStackTrace(System.out);
      return false;
    }

    return true; // return true if all tests passed
  }

  /**
   * Tests the functionality of dequeue() and peek() methods. The peek() method must return without
   * removing the assignment with the highest priority in the queue. The dequeue() method must
   * remove, and return the assignment with the highest priority in the queue. The size must be
   * decremented by one, each time the dequeue() method is successfully called. Try to check the
   * edge cases (calling peek and dequeue on an empty queue, and calling dequeue on a queue of size
   * one). For normal cases, try to consider dequeuing from a queue whose size is at least 6. Try to
   * consider cases where percolate-down recurses on left and right.
   * 
   * @return true if AssignmentQueue.dequeue() and AssignmentQueue.peek() function properly
   */
  public static boolean testDequeuePeek()
  {
    try
    {
      // creates new variables
      AssignmentQueue AQ1 = new AssignmentQueue(20);

      Assignment a1 = new Assignment("one", 1, 1, 1);
      Assignment a2 = new Assignment("two", 2, 2, 2);
      Assignment a3 = new Assignment("three", 3, 3, 3);
      Assignment a4 = new Assignment("four", 4, 4, 4);
      Assignment a5 = new Assignment("five", 5, 5, 5);
      Assignment a6 = new Assignment("six", 6, 6, 6);
      Assignment a7 = new Assignment("seven", 7, 7, 7);
      Assignment a8 = new Assignment("eight", 8, 8, 8);

      // tests on an empty queue
      try
      {
        AQ1.peek(); // should throw a NoSuchElementException
      } catch (NoSuchElementException e)
      {
        // expected
      } catch (Exception e)
      {
        return false; // shouldn't throw any other Exception
      }
      try
      {
        AQ1.dequeue(); // should throw a NoSuchElementException
      } catch (NoSuchElementException e)
      {
        // expected
      } catch (Exception e)
      {
        return false; // shouldn't throw any other Exception
      }

      // adds assignments to aq1
      AQ1.enqueue(a4);
      AQ1.enqueue(a7);
      AQ1.enqueue(a5);
      AQ1.enqueue(a3);
      AQ1.enqueue(a1);
      AQ1.enqueue(a8);
      AQ1.enqueue(a6);
      AQ1.enqueue(a2);


      // checks if peek returns the right thing and doesn't increment size
      if (AQ1.peek() != a1)
      {
        return false;
      }
      if (AQ1.size() != 8)
      {
        return false;
      }

      System.out.println();
      System.out.println("next to dequeue: " + AQ1.peek());
      System.out.println();
      System.out.println(AQ1);

      // checks if dequeue works and increments size
      if (AQ1.dequeue() != a1)
      {
        System.out.println("1");
        return false;
      }
      if (AQ1.size() != 7)
      {
        System.out.println("2");
        return false;
      }
      System.out.println("next to dequeue: " + AQ1.peek());
      System.out.println();
      System.out.println(AQ1);
      System.out.println();
      if (AQ1.dequeue() != a2)
      {
        System.out.println("3");
        return false;
      }
      System.out.println("next to dequeue: " + AQ1.peek());
      System.out.println();
      System.out.println(AQ1);
      System.out.println();
      if (AQ1.dequeue() != a3)
      {
        System.out.println("4");
        return false;
      }
      System.out.println("next to dequeue: " + AQ1.peek());
      System.out.println();
      System.out.println(AQ1);
      System.out.println();
      if (AQ1.dequeue() != a4)
      {
        System.out.println("5");
        return false;
      }
      System.out.println("next to dequeue: " + AQ1.peek());
      System.out.println();
      System.out.println(AQ1);
      System.out.println();
      if (AQ1.dequeue() != a5)
      {
        System.out.println("6");
        return false;
      }
      System.out.println("next to dequeue: " + AQ1.peek());
      System.out.println();
      System.out.println(AQ1);
      System.out.println();
      if (AQ1.dequeue() != a6)
      {
        System.out.println("7");
        return false;
      }
      System.out.println("next to dequeue: " + AQ1.peek());
      System.out.println();
      System.out.println(AQ1);
      System.out.println();
      if (AQ1.dequeue() != a7)
      {
        System.out.println("8");
        return false;
      }
      System.out.println("next to dequeue: " + AQ1.peek());
      System.out.println();
      System.out.println(AQ1);
      System.out.println();
      if (AQ1.dequeue() != a8)
      {
        System.out.println("9");
        return false;
      }

    } catch (Exception e)
    {
      e.printStackTrace(System.out);
      return false; // shouldn't throw any other Exception
    }
    // TODO complete the implementation of this tester method

    return true;
  }

  /**
   * Tests the functionality of the clear() method Should implement at least the following
   * scenarios: - clear can be called on an empty queue with no errors - clear can be called on a
   * non-empty queue with no errors - After calling clear, the queue should contain no Assignments
   *
   * @return true if AssignmentQueue.clear() functions properly
   */
  public static boolean testClear()
  {
    try
    {
      // creates new variables
      AssignmentQueue AQ1 = new AssignmentQueue(10);

      Assignment a1 = new Assignment("one", 1, 1, 1);
      Assignment a2 = new Assignment("two", 2, 2, 2);
      Assignment a3 = new Assignment("three", 3, 3, 3);
      Assignment a4 = new Assignment("four", 4, 4, 4);
      Assignment a5 = new Assignment("five", 5, 5, 5);

      AQ1.clear(); // shouldn't thrown an Exception

      // enqueues the assignments
      AQ1.enqueue(a1);
      AQ1.enqueue(a2);
      AQ1.enqueue(a3);
      AQ1.enqueue(a4);
      AQ1.enqueue(a5);
      // System.out.println(AQ1.size());

      AQ1.clear(); // shouldn't thrown an Exception

      if (!AQ1.isEmpty())
      {
        System.out.println("1");
        return false; // if its not empty after it has been cleared, return false
      }
      // System.out.println(AQ1.size());
    } catch (Exception e)
    {
      e.printStackTrace(System.out);
      return false; // shouldn't throw any other Exception
    }


    return true;
  }

  /**
   * Tests all the methods of the AssignmentQueue class
   * 
   */
  public static boolean runAllTests()
  {
    // sets a Boolean to true or false depending on what the test returns and then prints the return
    // (done this way so the method is only called once)
    Boolean testConstructor = testConstructor();
    System.out.println("testConstructor returns: " + testConstructor);
    Boolean testEnqueue = testEnqueue();
    System.out.println("testEnqueue returns: " + testEnqueue);
    Boolean testDequeuePeek = testDequeuePeek();
    System.out.println("testDequeuePeek returns: " + testDequeuePeek);
    Boolean testClear = testClear();
    System.out.println("testClear returns: " + testClear);

    // return true if all are true and false if any arn't
    return testConstructor && testEnqueue && testDequeuePeek && testClear;
  }

  /**
   * Main method
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args)
  {
    System.out.println("runAllTests returns: " + runAllTests());
  }
}
