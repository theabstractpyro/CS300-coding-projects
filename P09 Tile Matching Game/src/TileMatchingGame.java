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
 * TileMatchinGame class, models a tile matching game which consists of a certain number of columns
 * of stacks of tiles
 * 
 * @author ash wc
 * 
 */
public class TileMatchingGame
{
  private TileStack[] columns;

  /**
   * Creates a new matching tile game with a given number of columns and initializes its contents. A
   * new matching tile game stores an empty TileStack at each of its columns.
   * 
   * @param columnCount number of columns of the array of TileStacks
   */
  public TileMatchingGame(int columnCount)
  {
    columns = new TileStack[columnCount];

    // creates new TileStacks and places them in each column
    for (int i = 0; i < columnCount; i++)
    {
      columns[i] = new TileStack();
    }
  }

  /**
   * Removes all the tiles from a column with a given index
   * 
   * @param index column to remove all tiles from
   */
  public void clearColumn​(int index)
  {
    // while there are tiles in the stack, pop the top off the stack
    while (!columns[index].isEmpty())
    {
      columns[index].pop();
    }
  }

  /**
   * Returns a string representation of the stack of tiles at a given column index, and an empty
   * string "" if the stack is empty. For instance, if the stack at column index contains BLUE,
   * BLACK, and ORANGE blocks as follows, top: BLUE BLACK ORANGE the returned string will be: "BLUE
   * BLACK ORANGE"
   * 
   * @param index column of array to return
   * @return a string representation of the stack of tiles at a given column index
   */
  public String column​(int index)
  {
    String returns = "";

    // if the TileStack at index doesn't exist or is empty, return an empty string
    if (columns[index] == null || columns[index].isEmpty())
    {
      return returns;
    }
    // create new iterator
    TileListIterator i = (TileListIterator) columns[index].iterator();

    // iterate through the tileStack and add each tile to the returns string
    while (i.hasNext())
    {
      returns = returns + i.next().toString() + " ";
    }

    return returns.trim();
  }

  /**
   * Drops a tile at the top of the stack located at the given column index.
   * 
   * @param tile  till to drop (add) to the array
   * @param index column of the array to add the tile at
   */
  public void dropTile(Tile tile, int index)
  {
    // adds tile to the TileStack
    columns[index].push(tile);
  }

  /**
   * Gets the number of columns in this tile matching game
   * 
   * @return the number of columns in the array
   */
  public int getColumnsNumber()
  {
    return columns.length;
  }

  /**
   * Restarts the game.
   */
  public void restartGame()
  {
    // sets the columns array to null. doesn't delete the previous data
    columns = new TileStack[columns.length];

    // creates new TileStacks and places them in each column
    for (int i = 0; i < columns.length; i++)
    {
      columns[i] = new TileStack();
    }
  }

  /**
   * Returns a string representation of this tile matching game The format of the returned string is
   * as follows: GAME COLUMNS:\n [String representation of each column separated by newline] For
   * instance, a game with 4 columns will be represented as follows. GAME COLUMNS: 0: 1: BLACK BLUE
   * 2: ORANGE YELLOW 3: YELLOW
   */
  @Override
  public String toString()
  {
    String returns = "GAME COLUMNS:";

    // adds each column as represented by a string of the tiles in it to the returns string, with
    // labeling and proper newlines
    for (int i = 0; i < columns.length; i++)
    {
      returns += "\n" + i + ": " + column​(i);
    }

    return returns;
  }
}
