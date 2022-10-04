import java.util.NoSuchElementException;

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
 * class to test Tile
 * 
 * @author ash wc
 *
 */
public class TileMatchingTester
{

  /**
   * check the correctness of any implementation of the Tile.equals() method
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean tileEqualsTester()
  {
    String string = "test";
    Tile tile = new Tile(Color.BLACK);
    Tile tile2 = new Tile(Color.YELLOW);
    Tile tile3 = new Tile(Color.BLACK);
    Tile tile4 = new Tile(null);
    try
    {
      // should return false, because string is not a Tile
      if (tile.equals(string))
      {
        return false;
      }
      // should return false, tile's color is different that tile2's color
      if (tile.equals(tile2))
      {
        return false;
      }
      // should return true, tile's color is the same as tile3's color
      if (!tile.equals(tile3))
      {
        return false;
      }
      // should return false, because tile4's color is null
      if (tile4.equals(tile3))
      {
        return false;
      }
      // should return true, because tile2's color is the same as tile2's color
      if (!tile2.equals(tile2))
      {
        return false;
      }
    } catch (Exception e) // unexpected exception caught -- bug detected
    {
      // print stack of method calls to help debugging the error within the broken implementation
      e.printStackTrace();
      return false;
    }
    // returns true when all tests have passed
    return true;
  }

  /**
   * check the correctness of any implementation of the Tile.tileListIterator() method
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean tileListIteratorTester()
  {
    // creates new tiles to be used
    Tile t1 = new Tile(Color.ORANGE);
    Tile t2 = new Tile(Color.YELLOW);
    Tile t3 = new Tile(Color.BLUE);
    Tile t4 = new Tile(Color.BLACK);

    // creates a linked list with n1 -> n2 -> n3 -> n4
    Node n4 = new Node(t4);
    Node n3 = new Node(t3, n4);
    Node n2 = new Node(t2, n3);
    Node n1 = new Node(t1, n2);

    TileListIterator one = new TileListIterator(n1);
    try
    {
      // checks hasNext() should be true right now
      if (!one.hasNext())
      {
        System.out.println("1");
        return false;
      }
      // checks .next() should return t1 right now
      if (one.next() != t1)
      {
        System.out.println("2");
        return false;
      }
      // checks hasNext() should be true right now
      if (!one.hasNext())
      {
        System.out.println("3");
        return false;
      }
      if (one.next() != t2)
      {
        System.out.println("4");
        return false;
      }
      // checks hasNext() should be true right now
      if (!one.hasNext())
      {
        System.out.println("5");
        return false;
      }
      if (one.next() != t3)
      {
        System.out.println("6");
        return false;
      }
      // checks hasNext() should be true right now
      if (!one.hasNext())
      {
        System.out.println("7");
        return false;
      }
      if (one.next() != t4)
      {
        System.out.println("8");
        return false;
      }
      // checks hasNext() should be false right now
      if (one.hasNext())
      {
        System.out.println("9");
        return false;
      }
    } catch (Exception e)
    {
      // no exceptions should be thrown, so returns false
      System.out.println(e);
      System.out.println("10");
      return false;
    }
    try
    {
      one.next(); // should thrown a NoSuchElementException
      System.out.println("11");
      return false;
    } catch (NoSuchElementException e)
    {
      // expected behavior
    }

    // returns true when all tests have passed
    return true;
  }

  /**
   * check the correctness of any implementation of the Tile.tileStack() method
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean tileStackTester()
  {
    // calls all helper methods. if any are false, it returns false. if all are true, it returns
    // true
    if (!isEmptyHelper())
    {
      System.out.println("1");
      return false;
    }
    if (!sizeHelper())
    {
      System.out.println("2");
      return false;
    }
    if (!pushHelper())
    {
      System.out.println("3");
      return false;
    }
    if (!peekHelper())
    {
      System.out.println("4");
      return false;
    }
    if (!popHelper())
    {
      System.out.println("5");
      return false;
    }
    if (!iteratorHelper())
    {
      System.out.println("6");
      return false;
    }
    // returns true when all tests have passed
    return true;
  }

  /**
   * tileStackTester helper, tests tileStackTester.isEmpty()
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean isEmptyHelper()
  {
    TileStack test = new TileStack();
    TileStack test2 = new TileStack();
    test2.push(new Tile(Color.ORANGE));

    // should be true, test is empty
    if (!test.isEmpty())
    {
      return false;
    }
    // should be false, test is not empty
    if (test2.isEmpty())
    {
      return false;
    }
    // returns true when all tests have passed
    return true;
  }

  /**
   * tileStackTester helper, tests tileStackTester.size()
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean sizeHelper()
  {
    Tile t1 = new Tile(Color.ORANGE);
    TileStack test = new TileStack();
    if (test.size() != 0)
    {
      return false;
    }
    test.push(t1);
    if (test.size() != 1)
    {
      return false;
    }
    test.push(t1);
    if (test.size() != 2)
    {
      return false;
    }
    // returns true when all tests have passed
    return true;
  }

  /**
   * tileStackTester helper, tests tileStackTester.push()
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean pushHelper()
  {
    Tile t1 = new Tile(Color.ORANGE);
    TileStack test = new TileStack();
    test.push(t1);

    if (test.size() != 1)
    {
      return false;
    }
    if (test.isEmpty())
    {
      return false;
    }
    if (test.peek() != t1)
    {
      return false;
    }

    // returns true when all tests have passed
    return true;
  }

  /**
   * tileStackTester helper, tests tileStackTester.peek()
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean peekHelper()
  {
    Tile t1 = new Tile(Color.ORANGE);
    TileStack test = new TileStack();
    test.push(t1);
    if (test.peek() != t1)
    {
      return false;
    }
    if (test.size() != 1)
    {
      return false;
    }
    Tile t2 = new Tile(Color.YELLOW);
    test.push(t2);
    if (test.peek() != t2)
    {
      return false;
    }
    if (test.size() != 2)
    {
      return false;
    }
    // returns true when all tests have passed
    return true;
  }

  /**
   * tileStackTester helper, tests tileStackTester.pop
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean popHelper()
  {
    Tile t1 = new Tile(Color.ORANGE);
    TileStack test = new TileStack();
    test.push(t1);
    if (test.pop() != t1)
    {
      return false;
    }
    if (test.size() != 0)
    {
      return false;
    }
    Tile t2 = new Tile(Color.YELLOW);
    test.push(t2);
    if (test.pop() != t2)
    {
      return false;
    }
    if (test.size() != 0)
    {
      return false;
    }

    // returns true when all tests have passed
    return true;
  }

  /**
   * tileStackTester helper, tests tileStackTester.iterator()
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean iteratorHelper()
  {
    // creates new tiles to be used
    Tile t1 = new Tile(Color.ORANGE);
    Tile t2 = new Tile(Color.YELLOW);
    Tile t3 = new Tile(Color.BLUE);
    Tile t4 = new Tile(Color.BLACK);

    // creates a linked list with n1 -> n2 -> n3 -> n4
    Node n4 = new Node(t4);
    Node n3 = new Node(t3, n4);
    Node n2 = new Node(t2, n3);
    Node n1 = new Node(t1, n2);

    // creates TileStack
    TileStack test = new TileStack();

    // pushes tiles to the tileStack (tilestack now has t1 on top and t4 on bottom)
    test.push(t4);
    test.push(t3);
    test.push(t2);
    test.push(t1);

    // creates iterator with TileStack.iterator()
    TileListIterator i1 = (TileListIterator) test.iterator();

    // creates iterator with TileListIterator constructor
    TileListIterator i2 = new TileListIterator(n1);

    // checks if both iterators have the same items in them
    if (i1.next() != i2.next())
    {
      return false;
    }
    if (i1.next() != i2.next())
    {
      return false;
    }
    if (i1.next() != i2.next())
    {
      return false;
    }
    if (i1.next() != i2.next())
    {
      return false;
    }
    if (i1.hasNext())
    {
      return false;
    }
    if (i2.hasNext())
    {
      return false;
    }

    // returns true when all tests have passed
    return true;
  }

  /**
   * check the correctness of any implementation of the Tile.tileMatchingGame() method
   * 
   * @return false if any bug is detected, and true otherwise.
   */
  public static boolean tileMatchingGameTester()
  {
    TileMatchingGame TM1 = new TileMatchingGame(3);

    // creates new tiles to be used
    Tile t1 = new Tile(Color.ORANGE);
    Tile t2 = new Tile(Color.YELLOW);
    Tile t3 = new Tile(Color.BLUE);
    Tile t4 = new Tile(Color.BLACK);

    // tests constructor
    if (TM1.column​(0) != "" && TM1.column​(1) != "")
    {
      System.out.println("1");
      return false;
    }

    // drops tiles
    TM1.dropTile(t4, 0);
    TM1.dropTile(t3, 0);
    TM1.dropTile(t4, 0);
    TM1.dropTile(t2, 1);
    TM1.dropTile(t1, 1);

    // tests TileMatchingGame.column
    if (!TM1.column​(0).equals("BLACK BLUE BLACK"))
    {
      System.out.println("2");
      // return false;
    }
    if (!TM1.column​(1).equals("ORANGE YELLOW"))
    {
      System.out.println("3");
      // return false;
    }

    // tests TileMatchingGame.getColumnsNumber
    if (TM1.getColumnsNumber() != 3)
    {
      return false;
    }

    // calls restatGame()
    TM1.restartGame();

    // tests TileMatchingGame.restatGame
    if (TM1.getColumnsNumber() != 3 && TM1.column​(0) != "" && TM1.column​(1) != ""
        && TM1.column​(2) != "")
    {
      System.out.println("4");
      return false;
    }

    // drops tiles
    TM1.dropTile(t4, 0);
    TM1.dropTile(t3, 0);
    TM1.dropTile(t4, 0);
    TM1.dropTile(t2, 1);
    TM1.dropTile(t1, 1);

    // tests TileMatchingGame.toString
    if (!TM1.toString().equals("GAME COLUMNS:\n0: BLACK BLUE BLACK\n1: ORANGE YELLOW\n2: "))
    {
      System.out.println("5");
      return false;
    }

    // printouts for testing
    // System.out.println(TM1.getColumnsNumber());
    // System.out.println(TM1.column​(0));
    // System.out.println(TM1.column​(1));
    // System.out.println(TM1.toString());
    // returns true when all tests have passed
    return true;
  }

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    System.out.println("tileEqualsTester: " + tileEqualsTester());
    System.out.println("tileListIteratorTester: " + tileListIteratorTester());
    System.out.println("tileStackTester: " + tileStackTester());
    System.out.println("tileMatchingGameTester: " + tileMatchingGameTester());
  }
}
