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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TileListIterator class
 * 
 * @author ash wc
 *
 */
public class TileListIterator implements Iterator<Tile>
{
  private Node next;

  /**
   * hasNext override
   * 
   * @return true if this has a next node, false if not
   */
  @Override
  public boolean hasNext()
  {
    if (next != null)
      return true;
    else
      return false;
  }

  /**
   * next override
   * 
   * @return the next node's Tile
   */
  @Override
  public Tile next()
  {
    if (next == null)
    {
      throw new NoSuchElementException("No next Node");
    }
    Node temp = next;
    next = next.getNext();
    return temp.getTile();
  }

  /**
   * Creates a new iterator to iterate through a list of tiles starting from its head
   * 
   * @param head a reference to the head of the linked list of tiles
   */
  public TileListIterator(Node head)
  {
    this.next = head;
  }


}
