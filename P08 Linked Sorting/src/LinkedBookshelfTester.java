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
 * LinkedNode and LinkedBookersheld tester class
 * 
 * @author ash wc
 *
 */
public class LinkedBookshelfTester
{

  /**
   * test LinkedNode class
   * 
   * @return true if all test passed. false if not
   */
  public static boolean testLinkedNode()
  {
    try
    {
      Book.resetGenerator();
      // creates nodes
      LinkedNode<Integer> one = new LinkedNode<Integer>(1);
      LinkedNode<Integer> two = new LinkedNode<Integer>(2);
      LinkedNode<Integer> three = new LinkedNode<Integer>(3);

      // tests getdata
      if (one.getData() != 1)
      {
        return false;
      }

      // tests getnext
      if (one.getNext() != null)
      {
        return false;
      }

      // tests setnext
      one.setNext(two);
      if (one.getData() != 1)
      {
        return false;
      }
      if (one.getNext() != two)
      {
        return false;
      }

      // tests getnext of getnext
      two.setNext(three);
      if (one.getNext().getNext() != three)
      {
        return false;
      }
    } catch (Exception e)
    {
      System.out.println("error: ");
      System.out.println(e);
      return false;
    }

    // return true. all tests passed.
    return true;
  }

  /**
   * tests the correctness of LinkedBookshelf’s clear() method
   * 
   * @return true if all tests passed. false if not
   */
  public static boolean testClear()
  {
    // try to getfirst after clearing and it should throw an exception
    try
    {
      Book.resetGenerator();
      // add books
      Book one = new Book("title1", 100);
      Book two = new Book("title2", 200);
      Book three = new Book("title3", 300);

      LinkedBookshelf b1 = new LinkedBookshelf();
      b1.appendBook(two);
      b1.appendBook(one);
      b1.appendBook(three);

      // clears b1
      b1.clear();

      // checks if anything is in b1
      if (!b1.isEmpty())
      {
        return false;
      }
      try
      {
        b1.getFirst();
        return false;
      } catch (NullPointerException e)
      {
      }
      try
      {
        b1.getLast();
        return false;
      } catch (NullPointerException e)
      {
      }
    } catch (Exception e)
    {
      return false;
    }

    return true;
  }

  /**
   * tests the getData() method
   * 
   * @return true if all tests passed, false if they didn't
   */
  public static boolean testGetNode()
  {
    try
    {
      Book.resetGenerator();
      // add books
      Book one = new Book("title1", 100);
      Book two = new Book("title2", 200);
      Book three = new Book("title3", 300);

      LinkedBookshelf b1 = new LinkedBookshelf();
      b1.appendBook(two);
      b1.appendBook(one);
      b1.appendBook(three);

      if (b1.getNode(1).getData() != one)
      {
        return false;
      }
    } catch (Exception e)
    {
      System.out.println(e);
      return false;
    }
    return true;
  }

  /**
   * tests the correctness of LinkedBookshelf’s appendBook() method
   * 
   * @return true if all tests passed. false if not
   */
  public static boolean testAddBooks()
  {
    try
    {
      Book.resetGenerator();
      // add books
      Book one = new Book("title1", 100);
      Book two = new Book("title2", 200);
      Book three = new Book("title3", 300);

      LinkedBookshelf b1 = new LinkedBookshelf();
      b1.appendBook(two);
      b1.appendBook(one);
      b1.appendBook(three);

      // checks if everything is where it is suppose to be
      if (b1.getNode(0).getData() != two)
      {
        return false;
      }
      if (b1.getNode(1).getData() != one)
      {
        return false;
      }
      if (b1.getNode(2).getData() != three)
      {
        return false;
      }
      if (b1.size() != 3)
      {
        return false;
      }
      // should throw an IndexOutOfBoundsException
      try
      {
        b1.getNode(5);
        return false;
      } catch (IndexOutOfBoundsException e)
      {
      }
    } catch (Exception e)
    {
      System.out.println(e);
      return false;
    }
    return true;
  }

  /**
   * tests the correctness of LinkedBookshelf’s sort() method
   * 
   * @return true if all tests passed. false if not
   */
  public static boolean testSortBooks()
  {
    try
    {
      Book.resetGenerator();
      // add books
      Book one = new Book("title1", 600);
      Book two = new Book("title2", 500);
      Book three = new Book("title3", 400);
      Book four = new Book("title4", 300);
      Book five = new Book("title5", 200);
      Book six = new Book("title6", 100);

      LinkedBookshelf b1 = new LinkedBookshelf();
      b1.appendBook(five);
      b1.appendBook(two);
      b1.appendBook(six);
      b1.appendBook(four);
      b1.appendBook(one);
      b1.appendBook(three);

      // sort by title
      LinkedBookshelf.sort(b1, Attribute.TITLE);

      // checks if everything is where it is suppose to be
      if (b1.getNode(0).getData() != one && b1.getNode(1).getData() != two
          && b1.getNode(2).getData() != three && b1.getNode(3).getData() != four
          && b1.getNode(4).getData() != five && b1.getNode(5).getData() != six && b1.size() != 6
          && b1.getFirst() != one && b1.getLast() != six)
      {
        System.out.println("testSortBooks failed at point 1. printing the list: ");
        b1.printAll();
        return false;
      }

      // sort by title
      LinkedBookshelf.sort(b1, Attribute.PAGECOUNT);

      // checks if everything is where it is suppose to be
      if (b1.getNode(0).getData() != six && b1.getNode(1).getData() != five
          && b1.getNode(2).getData() != four && b1.getNode(3).getData() != three
          && b1.getNode(4).getData() != two && b1.getNode(5).getData() != one && b1.size() != 6
          && b1.getFirst() != six && b1.getLast() != one)
      {
        System.out.println("testSortBooks failed at point 2. printing the list: ");
        b1.printAll();
        return false;
      }
    } catch (Exception e)
    {
      System.out.println(e);
      return false;
    }


    return true;
  }

  /**
   * runs all test methods (including any custom methods which you have defined) and returns true if
   * and only if all test methods return true
   * 
   * @return true if all tests passed. false if not
   */

  public static boolean runAllTests()
  {
    try
    {
      Book.resetGenerator();
      // prints results of all tests
      if (!testLinkedNode())
      {
        System.out.println("test LinkedNode: false");
        return false;
      }
      System.out.println("test LinkedNode: passed");
      if (!testClear())
      {
        System.out.println("test clear: false");
        return false;
      }
      System.out.println("test clear: passed");
      if (!testGetNode())
      {
        System.out.println("test getNode: false");
        return false;
      }
      System.out.println("test getNode: passed");
      if (!testAddBooks())
      {
        System.out.println("test appendBook: false");
        return false;
      }
      System.out.println("test appendBook: passed");
      if (!testSortBooks())
      {
        System.out.println("test sortBooks: false");
        return false;
      }
      System.out.println("test sortBooks: passed");
    } catch (Exception e)
    {
      System.out.println(e);
      return false;
    }
    // returns true if all tests return true
    return true;
  }

  /**
   * main method which calls all test methods
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    System.out.println("test all: " + runAllTests());
    /*
     * Book one = new Book("title1", 100); Book two = new Book("title2", 200); Book three = new
     * Book("title3", 300); Book four = new Book("title4", 400); Book five = new Book("title5",
     * 500); Book six = new Book("title6", 600);
     * 
     * LinkedBookshelf b1 = new LinkedBookshelf(); b1.appendBook(five); b1.appendBook(two);
     * b1.appendBook(six); b1.appendBook(four); b1.appendBook(one); b1.appendBook(three);
     * 
     * System.out.println(b1.toString());
     */
  }

}
