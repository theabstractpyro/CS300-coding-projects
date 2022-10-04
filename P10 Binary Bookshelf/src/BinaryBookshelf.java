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

public class BinaryBookshelf
{
  private TreeNode<Book> root; // The root node of the BST
  private int size; // The number of nodes currently contained in the BST
  private Attribute[] sortList; // The ordered array of attributes by which the BST nodes are sorted

  /**
   * One-argument constructor, initializes an empty BinaryBookshelf
   * 
   * @param sortList The ordered array of attributes by which the BST nodes are sorted
   */
  public BinaryBookshelf(Attribute[] sortList)
  {
    // checks if sortList is formatted correctly, and if it isn't, throw a exception
    if (sortList.length != 4)
    {
      throw new IllegalArgumentException("sortList param is not a four-element array");
    }
    if (sortList[0] != Attribute.AUTHOR)
    {
      throw new IllegalArgumentException("sortList does not begin with Attribute.AUTHOR");
    }
    if (sortList[0] == sortList[1] || sortList[0] == sortList[2] || sortList[0] == sortList[3]
        || sortList[1] == sortList[2] || sortList[1] == sortList[3] || sortList[2] == sortList[3])
    {
      throw new IllegalArgumentException(
          "sortList is not a four-element array of unique attributes");
    }
    this.sortList = sortList; // sets the sortList instance variable
    size = 0;
  }

  /**
   * Resets the BST to be empty
   */
  public void clear()
  {
    // sets size and root to 0 and null
    size = 0;
    root = null;
  }

  // TODO untested
  /**
   * helper method to compare two Book objects according to the sortList of attributes.
   * 
   * @param one the first Book
   * @param two the second Book
   * @return a negative value if one < two, a positive value if one > two, and 0 if they are equal
   */
  protected int compareToHelper​(Book one, Book two)
  {
    for (int i = 0; i < sortList.length; i++)
    {
      if (one.compareTo(two, sortList[i]) != 0)
      {
        // calls Book.compareTo and returns it
        return two.compareTo(one, sortList[i]);
      }
    }
    // if this is reached, then all attributes are the same and the books are equal
    return 0;
  }

  /**
   * Searches for the input book in the bookshelf. This must be implemented recursively; do not call
   * toString() in this method.
   * 
   * @param book the book to search for
   * @return true if the book is present in the shelf, false otherwise
   */
  public boolean contains​(Book book)
  {
    return containsHelper​(book, root);
  }

  // TODO currently untested, tester broken
  /**
   * Recursive helper method; searches for the input book in the subtree rooted at current
   * 
   * @param book    the query book to search for
   * @param current the root of the current subtree
   * @return true if the book is contained in this subtree, false otherwise
   */
  protected boolean containsHelper​(Book book, TreeNode<Book> current)
  {
    if (current == null)
    {
      return false;
    }
    int compareTo = compareToHelper​(book, current.getData());

    /*
     * System.out.println(); System.out.println("compTo: " + compareTo); System.out.println("book: "
     * + book); System.out.println("curr: " + current); System.out.println();
     */

    // if they are the same, return true. base case
    if (compareTo == 0)
    {
      return true;
    }
    // if the current node doesn't match the book, search the left or right node depending on the
    // ID of the desired book. recursive case
    if (compareTo > 0)
    {
      if (current.getLeft() != null)
      {
        return containsHelper​(book, current.getLeft());
      }
    }
    if (compareTo < 0)
    {
      if (current.getRight() != null)
      {
        return containsHelper​(book, current.getRight());
      }
    }
    System.out.println("unreachable code reached"); // lol idk how this is reached but if it doesn't
                                                    // break anything I'm gonna leave it. plz email
                                                    // me w/ an explanation if anyone knows
    return false; // shouldn't reach this code
  }

  /**
   * Provides a String-formatted list of the attributes in the order in which they are used, for
   * example: "1:AUTHOR 2:PAGECOUNT 3:TITLE 4:ID"
   * 
   * @return a String-formatted list of the sorting attributes
   */
  public String getAttributeOrder()
  {
    String returns = "";
    // loop through the list and add each attribute to the returns string
    for (int i = 0; i < sortList.length; i++)
    {
      returns = returns + (i + 1) + ":" + sortList[i].toString() + " ";
    }
    return returns.trim();
  }

  /**
   * Returns a list of books in the bookshelf written by the given author
   * 
   * @param authorName the author name to filter on
   * 
   * @return a list of books by the author
   */
  public ArrayList<Book> getBooksByAuthor​(String authorName)
  {
    return getBooksByAuthorHelper​(authorName, root);
  }

  /**
   * Recursive helper method; returns a list of books in the subtree rooted at current which were
   * written by the given author
   * 
   * @param authorName the author name to filter on
   * @param current    the root of the current subtree
   * @return a list of books by the author in the current subtree
   */
  protected ArrayList<Book> getBooksByAuthorHelper​(String authorName, TreeNode<Book> current)
  {
    // create arraylist to return
    ArrayList<Book> returns = new ArrayList<Book>();
    if (current == null)
    {
      return returns;
    }
    // if the current node's author matches, add it to the returns list
    if (current.getData().getAuthor().equals(authorName))
    {
      returns.add(current.getData());
    } else
    {
      if (current.getLeft() != null)
      {
        returns.addAll(getBooksByAuthorHelper​(authorName, current.getLeft()));
      }
      if (current.getRight() != null)
      {
        returns.addAll(getBooksByAuthorHelper​(authorName, current.getRight()));
      }
    }
    return returns;
  }

  /**
   * Returns a shallow copy of the root node so that test tree structures may be constructed
   * manually rather than by using the insertBook() method
   * 
   * @return a reference to the current root node
   */
  protected TreeNode<Book> getRoot()
  {
    return root;
  }

  /**
   * Adds a new Book to the BST in sorted order, relative to this BST's sortList attributes Note:
   * you may wish to write helper methods for comparing Books according to the sortList, as well as
   * for inserting Books in a recursive manner.
   * 
   * @param book the Book object to be added to the BST
   * @throws IllegalArgumentExceptions if this Book is already in the BST
   */
  public void insertBook​(Book book)
  {
    // Increment size
    size++;
    // if the root is null, set the root to the book
    if (root == null)
    {
      root = new TreeNode<Book>(book);
      // System.out.println(root);
    } else
    {
      insertBookHelper​(book, root);
    }
  }

  /**
   * Recursive helper method; adds the given Book to the subtree rooted at current.
   * 
   * @param book    the Book object to be added to the BST
   * @param current the root of the current subtree
   * @throws IllegalArgumentException if this Book is already in the BST
   */
  protected void insertBookHelper​(Book book, TreeNode<Book> current) // FIXME
  {
    // get an int that is negative, 0, or positive depending on how book compares to current
    int compareTo = compareToHelper​(book, current.getData());

    /*
     * System.out.println(); System.out.println("compTo: " + compareTo); System.out.println("book: "
     * + book); System.out.println("curr: " + current); System.out.println();
     */

    if (compareTo == 0)
    {
      throw new IllegalArgumentException("this Book is already in the BST");
    }
    if (compareTo > 0)
    {
      // if the current node doesnt have a left node, set the left node to the book
      if (current.getLeft() == null)
      {
        // set the left node to the book
        current.setLeft(new TreeNode<Book>(book));
      } else // else recurse into the left node
      {
        insertBookHelper​(book, current.getLeft());
      }
    }
    if (compareTo < 0)
    {
      // if the current node doesnt have a right node, set the right node to the book
      if (current.getRight() == null)
      {
        // set the left node to the book
        current.setRight(new TreeNode<Book>(book));
      } else // else recurse into the left node
      {
        insertBookHelper​(book, current.getRight());
      }
    }
  }

  /**
   * Determine whether the BST is empty
   * 
   * @return true if the BST is empty, false otherwise
   */
  public boolean isEmpty()
  {
    if (size == 0)
    {
      return true;
    } else
    {
      return false;
    }
  }

  /**
   * size getter method
   * 
   * @return The number of nodes currently contained in the BST
   */
  public int size()
  {
    return size;
  }

  /**
   * Creates and returns an in-order traversal of the BST, with each Book on a separate line
   * 
   * @return an in-order traversal of the BST, with each Book on a separate line
   */
  @Override
  public String toString()
  {
    String returns = "";
    // TODO write this
    return returns;
  }

  /**
   * Recursive helper method; creates and returns the String representation of the subtree rooted at
   * the current node
   * 
   * @param current the root of the current subtree
   * @return the string representation of this subtree
   */
  protected String toStringHelper​(TreeNode<Book> current)
  {
    String returns = "";
    // TODO write this
    return returns;
  }
}
