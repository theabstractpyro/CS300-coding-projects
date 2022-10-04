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
 * Array-based heap implementation of a priority queue containing Assignments. Guarantees the
 * min-heap invariant, so that the Assignment at the root should have the earliest due date, and
 * children always have a due date after or at the same time as their parent. The root of a
 * non-empty queue is always at index 0 of this array-heap.
 */
public class AssignmentQueue implements PriorityQueueADT<Assignment>, Iterable<Assignment>
{
  private Assignment[] queue; // array min-heap of assignments representing this priority queue
  private int size; // size of this priority queue


  /**
   * Creates a new empty AssignmentQueue with the given capacity
   * 
   * @param capacity Capacity of this AssignmentQueue
   * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
   *                                  positive integer
   */
  public AssignmentQueue(int capacity)
  {
    // checks if the capacity is positive
    if (capacity < 0)
    {
      throw new IllegalArgumentException("input capacity is not a positive number");
    }
    // idk if i need this but it said to check if its a positive integer
    if (capacity % 1 != 0)
    {
      throw new IllegalArgumentException("input capacity is not an integer");
    }
    queue = new Assignment[capacity];
    size = 0;
  }

  /**
   * Checks whether this AssignmentQueue is empty
   * 
   * @return {@code true} if this AssignmentQueue is empty
   */
  @Override
  public boolean isEmpty()
  {
    // if size is 0 return true
    if (size == 0)
    {
      return true;
    }
    return false; // default return statement added to resolve compile errors
  }

  /**
   * Returns the size of this AssignmentQueue
   * 
   * @return the size of this AssignmentQueue
   */
  @Override
  public int size()
  {
    return size; // returns the size
  }

  /**
   * Returns the capacity of this AssignmentQueue
   * 
   * @return the capacity of this AssignmentQueue
   */
  public int capacity()
  {
    return queue.length; // returns the length of the queue array, which is the current max
                         // capacity.
  }


  /**
   * Removes all elements from this AssignmentQueue
   */
  @Override
  public void clear()
  {
    // set size to 0
    size = 0;
    // set everything in the queue to null
    for (int i = 0; i < queue.length; i++)
    {
      queue[i] = null;
    }
  }

  /**
   * Returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment with the
   * earliest due date.
   * 
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException if this AssignmentQueue is empty
   */
  @Override
  public Assignment peek()
  {
    if (isEmpty())
    {
      throw new NoSuchElementException("The AssignmentQueue is empty");
    }
    return queue[0];
  }


  /**
   * Adds the given Assignment to this AssignmentQueue at the correct position based on the min-heap
   * ordering. This queue should maintain the min-heap invariant, so that the Assignment at each
   * index has an earlier or equivalent due-date than the Assignments in its child nodes.
   * Assignments should be compared using the Assignment.compareTo() method.
   * 
   * @param e Assignment to add to this AssignmentQueue
   * @throws NullPointerException  if the given Assignment is null
   * @throws IllegalStateException with a descriptive error message if this AssignmentQueue is full
   */
  @Override
  public void enqueue(Assignment e)
  {
    // throw NullPointerException if the given Assignment is null
    if (e == null)
    {
      throw new NullPointerException("The input Assignment is null");
    }
    // throw IllegalStateException if this AssignmentQueue is full
    if (size == queue.length)
    {
      throw new IllegalStateException("The AssignmentQueue is full");
    }
    // sets the next open index in the array to e
    queue[size] = e;
    // moves the Assignment to the proper spot in the min heap
    percolateUp(size);
    // Increment size
    size++;
  }

  /**
   * Removes and returns the Assignment at the root of this AssignmentQueue, i.e. the Assignment
   * with the earliest due date.
   * 
   * @return the Assignment in this AssignmentQueue with the earliest due date
   * @throws NoSuchElementException with a descriptive error message if this AssignmentQueue is
   *                                empty
   */
  @Override
  public Assignment dequeue()
  {
    // throws an NoSuchElementException if the array is empty
    if (isEmpty())
    {
      throw new NoSuchElementException("AssignmentQueue is empty");
    }

    // saves the root to return later
    Assignment returns = queue[0];

    // sets the root to the last element

    // System.out.println("heap:");
    // System.out.println(queue[0]);
    // System.out.println(queue[1]);
    // System.out.println(queue[2]);
    // System.out.println(queue[3]);
    // System.out.println(queue[4]);
    // System.out.println();

    // System.out.println(toString());
    // System.out.println("size: " + size);
    // System.out.println("percolating down: (size - 1) " + queue[size - 1]);

    queue[0] = queue[size - 1];
    queue[size - 1] = null;

    // Increment size
    size--;

    // moves the new root to the proper position
    percolateDown(0);


    return returns;
  }


  // NOTE: this seems useful, I'll add it here:
  // Arr[(i-1)/2] Returns the parent node
  // Arr[(2*i)+1] Returns the left child node
  // Arr[(2*i)+2] Returns the right child node


  /**
   * Recursive implementation of percolateDown() method. Restores the min-heap invariant of a given
   * subtree by percolating its root down the tree. If the element at the given index does not
   * violate the min-heap invariant (it is due before its children), then this method does not
   * modify the heap. Otherwise, if there is a heap violation, then swap the element with the
   * correct child and continue percolating the element down the heap.
   * 
   * @param i index of the element in the heap to percolate downwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateDown(int i)
  {
    // provide the worst-case runtime complexity of this method assuming that the problem size
    // N is the size of this queue
    // Time complexity: O(log(N))

    // HOW THIS WORKS: (small meaning the node with the earliest due date)
    // it first compares the two leaf nodes, and gets the index of the smallest leaf node.
    // then, it checks if the smallest leaf node is less than the current node
    // if leaf is smaller, swap the current and leaf node, and recurse the new leaf node
    // if current node is smaller, it is properly sorted. return and exit the recursion

    // throws IndexOutOfBoundsException if input in is out of bounds
    if (i < 0 || i > size)
    {
      // System.out.println(i);
      throw new IndexOutOfBoundsException(
          "index is out of bounds, the input int is not within the size of the array");
    }

    int smallestLeafIndex; // the index of the smallest leaf node of the current node

    // if the left and right node exist
    if (queue[(2 * i) + 1] != null && queue[(2 * i) + 2] != null)
    {
      // recursive case
      // if left leaf has a earlier or equal due date to right node, set the smallestLeafIndex to
      // the left node index
      if (queue[(2 * i) + 1].compareTo(queue[(2 * i) + 2]) <= 0)
      {
        // sets smallestLeafIndex to the index of the left node
        smallestLeafIndex = (2 * i) + 1;
      }
      // else set smallestLeafIndex to the right node index
      else
      {
        // sets smallestLeafIndex to the index of the right node
        smallestLeafIndex = (2 * i) + 2;
      }

      // checks if the smallest leaf node is less than or greater than current node.
      // if leaf is smaller, swap + recurse
      // if current node is smaller, it is properly sorted. base case
      if (queue[i].compareTo(queue[smallestLeafIndex]) <= 0)
      {
        return; // base case, the array is sorted properly
      } else
      {
        // swaps the current node and the smallest leaf node
        Assignment temp = queue[i];
        queue[i] = queue[smallestLeafIndex];
        queue[smallestLeafIndex] = temp;
        percolateDown(smallestLeafIndex);
      }
    } else if (queue[(2 * i) + 1] != null) // if only the left node exists
    {
      // set the smallestLeafIndex to the index of the left node
      smallestLeafIndex = (2 * i) + 1;
      // swaps the current node and the smallest leaf node
      Assignment temp = queue[i];
      queue[i] = queue[smallestLeafIndex];
      queue[smallestLeafIndex] = temp;
      percolateDown(smallestLeafIndex);
    }
  }

  /**
   * Recursive implementation of percolateUp() method. Restores the min-heap invariant of the tree
   * by percolating a leaf up the tree. If the element at the given index does not violate the
   * min-heap invariant (it occurs after its parent), then this method does not modify the heap.
   * Otherwise, if there is a heap violation, swap the element with its parent and continue
   * percolating the element up the heap.
   * 
   * @param i index of the element in the heap to percolate upwards
   * @throws IndexOutOfBoundsException if index is out of bounds - do not catch the exception
   */
  protected void percolateUp(int i)
  {
    // provide the worst-case runtime complexity of this method assuming that the problem size
    // N is the size of this queue
    // Time complexity: O(log(N))

    // throws IndexOutOfBoundsException if input in is out of bounds
    if (i < 0 || i > size)
    {
      // System.out.println(i);
      // System.out.println(size);
      throw new IndexOutOfBoundsException(
          "index is out of bounds, the input int is not within the size of the array");
    }

    // base case, if the current node is at the root
    if (i == 0)
    {
      return; // return, the array is sorted properly
    }
    // System.out.println(i);
    // System.out.println(size);

    // if current node is less than its parent, percolate it up the heap.
    if (queue[i].compareTo(queue[(i - 1) / 2]) <= 0)
    {
      // swaps the current node and the smallest leaf node
      Assignment temp = queue[(i - 1) / 2];
      queue[(i - 1) / 2] = queue[i];
      queue[i] = temp;
      percolateUp((i - 1) / 2);
    } else // else, return, as the current node is in the proper spot
    {
      return; // base case, the array is sorted properly
    }
  }

  /**
   * Returns a deep copy of this AssignmentQueue containing all of its elements in the same order.
   * This method does not return the deepest copy, meaning that you do not need to duplicate
   * assignments. Only the instance of the heap (including the array and its size) will be
   * duplicated.
   * 
   * @return a deep copy of this AssignmentQueue. The returned new assignment queue has the same
   *         length and size as this queue.
   */
  public AssignmentQueue deepCopy()
  {
    // create an AssignmentQueue to return
    AssignmentQueue returns = new AssignmentQueue(queue.length);
    // adds each assignment from queue Assignment array to the returns AssignmentQueue
    for (int i = 0; i < size; i++)
    {
      returns.enqueue(queue[i]);
    }
    return returns; // return the returns AssignmentQueue
  }

  /**
   * Returns a String representing this AssignmentQueue, where each element (assignment) of the
   * queue is listed on a separate line, in order from earliest to latest.
   * 
   * @see Assignment#toString()
   * @see AssignmentIterator
   * @return a String representing this AssignmentQueue
   */
  public String toString()
  {
    StringBuilder val = new StringBuilder();

    for (Assignment a : this)
    {
      // System.out.println("tostring:");
      // System.out.println(a);
      val.append(a).append("\n");
    }

    return val.toString();
  }

  /**
   * Returns an Iterator for this AssignmentQueue which proceeds from the earliest to the latest
   * Assignment in the queue.
   * 
   * @see AssignmentIterator
   * @return an Iterator for this AssignmentQueue
   */
  @Override
  public Iterator<Assignment> iterator()
  {
    return new AssignmentIterator(this);
  }
}
