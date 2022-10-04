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
 * LinkedBookshelf class. its a slinky linked list of LinkedNodes containing book objects
 * 
 * @author ash wc
 *
 */
public class LinkedBookshelf
{
  private LinkedNode<Book> front;
  private LinkedNode<Book> back;
  private int size = 0;
  private Attribute sortedBy = Attribute.ID;

  /**
   * default constructor
   */
  public LinkedBookshelf()
  {
  }

  /**
   * size getter
   * 
   * @return this.size
   */
  public int size()
  {
    return size;
  }

  /**
   * checks if the bookshelf is empty
   * 
   * @returns true if empty, false if not
   */
  public boolean isEmpty()
  {
    if (front == null)
      return true;
    else
      return false;
  }

  /**
   * @return a String representation of the current state of the shelf, beginning with the current
   *         value of sortedBy and followed by each Book’s String representation on a separate line
   *         in order from front to back
   */
  @Override
  public String toString()
  {
    String returns = sortedBy.toString() + "\n";
    LinkedNode<Book> runner = front;
    // goes through the list and adds each LinkedNode<Book> to returns
    while (runner != null)
    {
      returns = returns + runner.toString() + "\n";
      runner = runner.getNext();
    }

    return returns.trim();
  }

  /**
   * gets the LinkedNode<Book> at index
   * 
   * @param index the index of the LinkedNode<Book> to return
   * @returns the LinkedNode<Book> at index
   */
  public LinkedNode<Book> getNode(int index)
  {
    // throws exception if index is not a proper index in the list
    if (index < 0 || index > size - 1)
    {
      throw new IndexOutOfBoundsException("index not within 0 and size - 1");
    }
    LinkedNode<Book> runner = front;
    int i = 0;

    // looks through the list for the index, and returns the right one
    while (runner != null)
    {
      if (i == index)
      {
        return runner;
      }
      i++;
      runner = runner.getNext();
    }
    return null;
  }

  /**
   * gets the Book at index
   * 
   * @param index the index of the Book to return
   * @returns the Book at index
   */
  public Book get(int index)
  {
    // throws exception if index is not a proper index in the list
    if (index < 0 || index > size - 1)
    {
      throw new IndexOutOfBoundsException("index not within 0 and size - 1");
    }
    LinkedNode<Book> runner = front;
    int i = 0;

    // looks through the list for the index, and returns the right one
    while (runner != null)
    {
      if (i == index)
      {
        return runner.getData();
      }
      i++;
      runner = runner.getNext();
    }
    return null;
  }

  /**
   * first getter
   * 
   * @return front
   */
  public Book getFirst()
  {
    return front.getData();
  }

  /**
   * last getter
   * 
   * @return back
   */
  public Book getLast()
  {
    return back.getData();
  }

  /**
   * clears the list
   */
  public void clear()
  {
    size = 0;
    front = null;
    back = null;
  }

  /**
   * adds the provided book to the end of the list, increases size, and sets next values
   * appropriately
   * 
   * @param toAdd the book to append to the list
   */
  public void appendBook(Book toAdd)
  {
    // creates new LinkedNode<Book> from the book param
    LinkedNode<Book> lnToAdd = new LinkedNode<Book>(toAdd);
    // if its empty, set head and tail to lnToAdd
    if (isEmpty())
    {
      front = lnToAdd;
      back = lnToAdd;
    } else
    {
      // sets the prev last LinkedNode<Book>'s next val to new last
      back.setNext(lnToAdd);
      back = lnToAdd;
    }
    size++;
  }

  /**
   * method I made which just prints out all the books and the size of the bookshelf
   */
  public void printAll()
  {
    // creates temp linkedNode book
    LinkedNode<Book> temp = front;
    // loops through list and prints out everything
    int i = 0;
    while (temp != null)
    {
      System.out.println("book " + i + " is: " + temp.getData().toString());
      temp = temp.getNext();
      i++;
    }
    // print size
    System.out.println("size is: " + size);
  }

  /**
   * inserts the param book into the list. basically a helper for sort.
   * 
   * @param toAdd the book to be inserted
   */
  public void insertBook(Book toAdd)
  {
    // creates new LinkedNode<Book> from the book param
    LinkedNode<Book> lnToAdd = new LinkedNode<Book>(toAdd);

    // if toAdd < front, then move toAdd to the front and front to the second
    if (toAdd.compareTo(front.getData(), sortedBy) < 0)
    {
      lnToAdd.setNext(front);
      front = lnToAdd;
      size++;
      return;
    }

    // if toAdd > back, put it in the back of the list
    if (toAdd.compareTo(back.getData(), sortedBy) > 0)
    {
      appendBook(toAdd);
      return;
    }

    // loops through the list, and places it in the middle
    LinkedNode<Book> runner = front;
    while (runner != null)
    {
      // checks if toAdd comes after the current node at i, if it its, then inserts it after
      if (toAdd.compareTo(runner.getData(), sortedBy) >= 0
          && toAdd.compareTo(runner.getNext().getData(), sortedBy) < 0)
      {
        lnToAdd.setNext(runner.getNext());
        runner.setNext(lnToAdd);
        size++;
        return;
      }
      runner = runner.getNext();
    }
  }

  /**
   * runs insertion sort on the provided shelf, using the given Attribute for comparing Book
   * objects.
   * 
   * @param b        the LinkedBookshelf to sort
   * @param sortedBy the Attribute to sort the list by
   */
  public static void sort(LinkedBookshelf b, Attribute sortedBy)
  {
    b.sortedBy = sortedBy;
    // lists with size of 0 or 1 are sorted
    if (b.size == 0 || b.size == 1)
    {
      return;
    }
    // create temp
    LinkedNode<Book> temp = b.front.getNext();
    // sets the front and back to the first Book in the list, and sets that Book's next to null
    b.front.setNext(null);
    b.back = b.front;
    b.size = 1;
    // prints out b (front)
    System.out.println("...separated front: " + b.front.getData());
    b.printAll();

    // cycles through the rest of the list and inserts them appropriately
    while (temp != null)
    {
      System.out.println("...inserting: " + temp.getData());

      b.insertBook(temp.getData());
      temp = temp.getNext();
      // b.size++;

      b.printAll();
    }
  }
}
