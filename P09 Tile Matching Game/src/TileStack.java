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

/**
 * TileStack class which represents a linked stack of tiles
 * 
 * @author ash wc
 *
 */
public class TileStack implements StackADT<Tile>, Iterable<Tile>
{
  private Node top;
  private int size;

  /**
   * no argument constructor which creates an empty stack of tiles.
   */
  public TileStack()
  {
    this.top = null;
    this.size = 0;
  }

  /**
   * Returns an iterator to iterate through this stack starting from its top
   */
  @Override
  public Iterator<Tile> iterator()
  {
    return new TileListIterator(top);
  }

  /**
   * Pushes the provided tile at top of this stack
   * 
   * @param element Tile to be added to top of this stack
   */
  @Override
  public void push(Tile element)
  {
    top = new Node(element, top);
    size++;
  }

  /**
   * Removes and returns the tile at the top of this stack
   * 
   * @return the tile at the top of this stack
   */
  @Override
  public Tile pop()
  {
    Node n = top;
    top = top.getNext();
    size--;
    return n.getTile();
  }

  /**
   * Returns the tile at the top of this stack without removing it
   * 
   * @return the tile at the top of this stack
   */
  @Override
  public Tile peek()
  {
    return top.getTile();
  }

  /**
   * Check whether this stack is empty
   * 
   * @return true if stack is empty
   */
  @Override
  public boolean isEmpty()
  {
    if (top == null)
    {
      return true;
    } else
    {
      return false;
    }
  }

  /**
   * size getter
   * 
   * @Return the size of this stack
   */
  @Override
  public int size()
  {
    return size;
  }

}
