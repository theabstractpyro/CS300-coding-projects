import java.util.ArrayList;

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
 * BinaryBookshelfTester class which tests for proper implementation of BinaryBookshelf
 * 
 * @author ashwc
 * 
 */
public class BinaryBookshelfTester
{
  // WORKING && returns true
  /**
   * tests the implementation of the generic class treeNode()
   * 
   * @return true if all tests passed, false if any failed
   */
  public static boolean testTreeNode()
  {
    // create TreeNodes to use later
    TreeNode<Integer> t1 = new TreeNode<>(1);
    TreeNode<Integer> t2 = new TreeNode<>(2);
    TreeNode<Integer> t3 = new TreeNode<>(3);

    // Scenario 1: a single TreeNode with no children
    // tests if left and right are null and if the constructor set data and that tostring works
    if (t1.getLeft() != null)
    {
      return false;
    }
    if (t1.getRight() != null)
    {
      return false;
    }
    if (t1.getData() != 1)
    {
      return false;
    }
    if (!t1.toString().equals("1"))
    {
      System.out.println(t1.toString());
      return false;
    }

    // Scenario 2: a simple collection of TreeNodes
    // sets t1's left and right to t2 and t3
    t1.setLeft(t2);
    t1.setRight(t3);

    // checks that the accsessors return the right value
    if (t1.getLeft() != t2)
    {
      return false;
    }
    if (t1.getRight() != t3)
    {
      return false;
    }

    t1.setLeft(null);
    t1.setRight(null);

    // checks that the accsessors return null after setting left and right to null
    if (t1.getLeft() != null)
    {
      return false;
    }
    if (t1.getRight() != null)
    {
      return false;
    }

    // Scenario 3: multiple-arg constructor
    // should create a new TreeNode t4 with the leaves t2 and t3
    TreeNode<Integer> t4 = new TreeNode<>(3, t2, t3);

    // checks that the accsessors return the right value
    if (t4.getLeft() != t2)
    {
      return false;
    }
    if (t4.getRight() != t3)
    {
      return false;
    }

    return true;
  }

  // WORKING && returns true
  /**
   * tests the implementation of all basic methods in BinaryBookshelf, before any books have been
   * added to the bookshelf
   * 
   * @return true if all tests passed, false if any failed
   */
  public static boolean testEmptyTree()
  {
    // creates Attribute arrays to use later
    Attribute[] a1 =
    {};
    Attribute[] a2 =
    {Attribute.AUTHOR, Attribute.ID};
    Attribute[] a3 =
    {Attribute.AUTHOR, Attribute.ID, Attribute.PAGECOUNT, Attribute.PAGECOUNT};
    Attribute[] a4 =
    {Attribute.ID, Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.TITLE};
    Attribute[] a5 =
    {Attribute.AUTHOR, Attribute.ID, Attribute.PAGECOUNT, Attribute.TITLE};

    // Scenario 1: invalid constructor inputs
    try
    {
      BinaryBookshelf b1 = new BinaryBookshelf(a1);
      System.out.println("1");
      return false; // if this point is reached, BinaryBookshelf did not throw the proper exception
                    // when called with an invalid array
    } catch (IllegalArgumentException e)
    {
      // Expected
    } catch (Exception e)
    {
      System.out.println("2");
      return false; // wrong exception thrown
    }
    try
    {
      BinaryBookshelf b2 = new BinaryBookshelf(a2);
      System.out.println("3");
      return false; // if this point is reached, BinaryBookshelf did not throw the proper exception
                    // when called with an invalid array
    } catch (IllegalArgumentException e)
    {
      // Expected
    } catch (Exception e)
    {
      System.out.println("4");
      return false; // wrong exception thrown
    }
    try
    {
      BinaryBookshelf b3 = new BinaryBookshelf(a3);
      System.out.println("5");
      return false; // if this point is reached, BinaryBookshelf did not throw the proper exception
                    // when called with an invalid array
    } catch (IllegalArgumentException e)
    {
      // Expected
    } catch (Exception e)
    {
      System.out.println("6");
      return false; // wrong exception thrown
    }
    try
    {
      BinaryBookshelf b4 = new BinaryBookshelf(a4);
      System.out.println("7");
      return false; // if this point is reached, BinaryBookshelf did not throw the proper exception
                    // when called with an invalid array
    } catch (IllegalArgumentException e)
    {
      // Expected
    } catch (Exception e)
    {
      System.out.println("8");
      return false; // wrong exception thrown
    }

    // Scenario 2: valid input
    try
    {
      BinaryBookshelf b5 = new BinaryBookshelf(a5); // should work and not throw anything

      // tests size, isEmptry, toString, and getRoot with an empty Bookshelf
      if (b5.size() != 0)
      {
        System.out.println("9");
        return false;
      }
      if (!b5.isEmpty())
      {
        System.out.println("10");
        return false;
      }
      if (!b5.toString().equals(""))
      {
        System.out.println("11");
        return false;
      }
      if (b5.getRoot() != null)
      {
        System.out.println("12");
        return false;
      }
      // tests getAttributeOrder()
      if (!b5.getAttributeOrder().equals("1:AUTHOR 2:ID 3:PAGECOUNT 4:TITLE"))
      {
        System.out.println(b5.getAttributeOrder());
        System.out.println("13");
        return false;
      }
      // checks if contains method return false
      if (b5.contains​(new Book(" ", 1)))
      {
        System.out.println("14");
        return false;
      }
      // checks if getBooksByAuthor does not throw an error and returns an empty arraylist
      ArrayList<Book> al1 = new ArrayList<Book>();
      if (!b5.getBooksByAuthor​("author").equals(al1))
      {
        System.out.println("15");
        return false;
      }

    } catch (IllegalArgumentException e)
    {
      System.out.println("16");
      return false; // Shouldn't thrown an exception here
    } catch (Exception e)
    {
      System.out.println("17");
      System.out.println(e);
      return false; // wrong exception thrown
    }

    return true;
  }

  // WORKING && returns true
  /**
   * tests the implementation of BinaryBookshelf insertBook() method
   * 
   * @return true if all tests passed, false if any failed
   */
  public static boolean testInsertBook()
  {
    // create books to use later
    Book b1 = new Book(" ", 1, "zzz", "zzz");
    Book b2 = new Book(" ", 1, "aaa", "aaa");
    Book b3 = new Book(" ", 99, "zzz", "zzz");

    // creates variables to use later
    Attribute[] a1 =
    {Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.ID, Attribute.TITLE};
    BinaryBookshelf bb1 = new BinaryBookshelf(a1);
    try
    {
      // Scenario 1: inserting into an empty tree
      // checks if newly created BinaryBookshelf is empty
      if (!bb1.isEmpty())
      {
        System.out.println("1");
        return false;
      }
      // checks the size
      if (bb1.size() != 0)
      {
        System.out.println("2");
        return false;
      }
      // adds book
      bb1.insertBook​(b1);
      // System.out.println(bb1.getRoot());
      // shouldn't be empty anymore
      if (bb1.isEmpty())
      {
        System.out.println("3");
        return false;
      }
      // checks the size
      if (bb1.size() != 1)
      {
        System.out.println("4");
        return false;
      }
      // checks to make sure the root is the book that was just added
      if (bb1.getRoot().getData() != b1)
      {
        System.out.println("5");
        return false;
      }

      // Scenario 2: inserting a unique, smaller value into a non-empty tree
      // adds book
      bb1.insertBook​(b2);
      // checks to make sure b2 is the left child of b1
      if (bb1.getRoot().getLeft().getData() != b2)
      {
        System.out.println("6");
        return false;
      }
      // checks the size
      if (bb1.size() != 2)
      {
        System.out.println("7");
        return false;
      }

      // Scenario 3: inserting a value with a shared author attribute
      // adds book
      bb1.insertBook​(b3);
      // checks to make sure b2 is the right child of b1
      if (bb1.getRoot().getRight().getData() != b3)
      {
        System.out.println("8");
        return false;
      }
    } catch (Exception e)
    {
      System.out.println("9");
      e.printStackTrace(System.out);
      // if an exception was thrown when it shouldn't, return false
      return false;
    }
    // Scenario 4: inserting a duplicate value
    try
    {
      // adds book
      bb1.insertBook​(b2); // should throw an exception
      System.out.println("10");
      return false; // if this is reached it didn't properly throw the exception
    } catch (IllegalArgumentException e)
    {
    }

    return true;
  }

  // WORKING
  /**
   * tests the implementation of BinaryBookshelf contains() method
   * 
   * @return true if all tests passed, false if any failed
   */
  public static boolean testContains()
  {
    // create tree nodes to use later
    TreeNode<Book> a = new TreeNode<Book>(new Book(" ", 1, "aaa", "aaa"));
    TreeNode<Book> b = new TreeNode<Book>(new Book(" ", 1, "bbb", "bbb"));
    TreeNode<Book> c = new TreeNode<Book>(new Book(" ", 1, "ccc", "ccc"));
    TreeNode<Book> d = new TreeNode<Book>(new Book(" ", 1, "ddd", "ddd"));
    TreeNode<Book> e = new TreeNode<Book>(new Book(" ", 1, "eee", "eee"));
    TreeNode<Book> f = new TreeNode<Book>(new Book(" ", 1, "fff", "fff"));
    TreeNode<Book> g = new TreeNode<Book>(new Book(" ", 1, "ggg", "ggg"));
    TreeNode<Book> z = new TreeNode<Book>(new Book(" ", 1, "zzz", "zzz"));

    // creates variables to use later
    Attribute[] a1 =
    {Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.ID, Attribute.TITLE};
    BinaryBookshelf bb1 = new BinaryBookshelf(a1);

    // Scenario 1: non-recursive case
    // adds book
    bb1.insertBook​(d.getData());
    // checks base case, makes sure that when b1 is the only thing in the BST, the BST contains b1
    if (!bb1.contains​(d.getData()))
    {
      System.out.println("1");
      return false;
    }
    // Scenario 2: recursive case
    // get shallow copy of the root
    TreeNode<Book> t1 = bb1.getRoot();
    // creates BST

    t1.setLeft(b);
    t1.setRight(f);
    b.setLeft(a);
    b.setRight(c);
    f.setLeft(e);
    f.setRight(g);

    // System.out.println(t1.getLeft());

    // checks if the contains method returns true when called with nodes that are in the BST
    if (!bb1.contains​(d.getData()))
    {
      System.out.println("2");
      return false;
    }
    if (!bb1.contains​(c.getData()))
    {
      System.out.println("3");
      return false;
    }
    if (!bb1.contains​(b.getData()))
    {
      System.out.println("4");
      return false;
    }
    if (!bb1.contains​(f.getData()))
    {
      System.out.println("5");
      return false;
    }
    if (!bb1.contains​(g.getData()))
    {
      System.out.println("6");
      return false;
    }
    if (bb1.contains​(z.getData()))
    {
      System.out.println("7");
      return false;
    }

    return true;
  }

  // WORKING
  /**
   * tests the implementation of BinaryBookshelf getBooksByAuthor() method
   * 
   * @return true if all tests passed, false if any failed
   */
  public static boolean testGetBooksByAuthor()
  {
    // creates variables to use later
    Attribute[] a1 =
    {Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.ID, Attribute.TITLE};
    // create books to use later
    Book Bd = new Book(" ", 1, "ddd", "ddd");
    // create tree nodes to use later
    TreeNode<Book> a = new TreeNode<Book>(new Book(" ", 1, "aaa", "aaa"));
    TreeNode<Book> b = new TreeNode<Book>(new Book(" ", 2, "aaa", "aaa"));
    TreeNode<Book> c = new TreeNode<Book>(new Book(" ", 1, "ccc", "ccc"));
    TreeNode<Book> e = new TreeNode<Book>(new Book(" ", 1, "eee", "eee"));
    TreeNode<Book> f = new TreeNode<Book>(new Book(" ", 1, "fff", "fff"));
    TreeNode<Book> g = new TreeNode<Book>(new Book(" ", 1, "ggg", "ggg"));

    // create bookshelf and adds one book
    BinaryBookshelf bb1 = new BinaryBookshelf(a1);
    bb1.insertBook​(Bd);

    // System.out.println(bb1);

    // Scenario 1: non-recursive case
    // bb1.getBooksByAuthor should return an arraylist with the size of one when given the author of
    // the book which is in bb1
    if (bb1.getBooksByAuthor​(Bd.getAuthor()).size() != 1)
    {
      System.out.println("1");
      return false;
    }
    // bb1.getBooksByAuthor should return an arraylist with the size of 0 when given the author of
    // the book which is not in bb1
    if (bb1.getBooksByAuthor​("notLast, notFirst").size() != 0)
    {
      System.out.println("2");
      return false;
    }

    // Scenario 2: recursive case
    // get shallow copy of the root
    TreeNode<Book> t1 = bb1.getRoot();
    // creates BST
    t1.setLeft(b);
    t1.setRight(f);
    b.setLeft(a);
    b.setRight(c);
    f.setLeft(e);
    f.setRight(g);

    // bb1.getBooksByAuthor should return an arraylist with the size of one when given the author of
    // the book which is in bb1
    if (bb1.getBooksByAuthor​(c.getData().getAuthor()).size() != 1)
    {
      System.out.println("3");
      return false;
    }

    // bb1.getBooksByAuthor should return an arraylist with the size of 0 when given the author of
    // the book which is not in bb1
    if (bb1.getBooksByAuthor​("notLast, notFirst").size() != 0)
    {
      System.out.println("4");
      return false;
    }

    // bb1.getBooksByAuthor should return an arraylist with the size of 2 when given the author of
    // the book which is in bb1 twice
    if (bb1.getBooksByAuthor​("aaa, aaa").size() != 2)
    {
      System.out.println("5");
      return false;
    }

    return true;
  }

  /**
   * main method which calls and prints all the test methods
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    System.out.println("testTreeNode: " + testTreeNode());
    System.out.println("testEmptyTree: " + testEmptyTree());
    System.out.println("testInsertBook: " + testInsertBook());
    System.out.println("testContains: " + testContains());
    System.out.println("testGetBooksByAuthor: " + testGetBooksByAuthor());
  }

}
