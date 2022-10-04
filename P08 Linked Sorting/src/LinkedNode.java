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
 * linkednode generic class
 * 
 * @author ash wc
 *
 */
public class LinkedNode<T>
{
  private T data;
  private LinkedNode<T> next;

  /**
   * constructor for LinkedNode with only the data param
   * 
   * @param data the data of the node
   */
  public LinkedNode(T data)
  {
    this.data = data;
  }

  /**
   * constructor with data and next
   * 
   * @param data the data of the node
   * @param next the next node
   */
  public LinkedNode(T data, LinkedNode<T> next)
  {
    this.data = data;
    this.next = next;
  }

  /**
   * next getter
   * 
   * @return next
   */
  public LinkedNode<T> getNext()
  {
    return next;
  }

  /**
   * data getter
   * 
   * @return data
   */
  public T getData()
  {
    return data;
  }

  /**
   * toString method
   * 
   * @return string representation of data
   */
  @Override
  public String toString()
  {
    return data.toString();
  }

  /**
   * next mutator. sets this.next to next
   * 
   * @param next LinkedNode to set next to
   */
  public void setNext(LinkedNode<T> next)
  {
    this.next = next;
  }
}
