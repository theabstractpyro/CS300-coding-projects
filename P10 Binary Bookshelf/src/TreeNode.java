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
 * genaric class TreeNode which has two leaves, a left and right leaf
 * 
 * @author ashwc
 *
 * @param <T> the type of the data to be sorted in this tree node
 */
public class TreeNode<T>
{
  private T data; // The data contained in this node
  private TreeNode<T> left; // The left child of this node
  private TreeNode<T> right; // The right child of this node

  /**
   * Constructs a node with the given data and no children
   * 
   * @param data The data contained in this node
   */
  public TreeNode(T data)
  {
    this.data = data;
  }

  /**
   * Constructs a node with the given data and children
   * 
   * @param data  The data contained in this node
   * @param left  The left child of this node
   * @param right The right child of this node
   */
  public TreeNode(T data, TreeNode<T> left, TreeNode<T> right)
  {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  /**
   * Accessor for the data contained in the node
   */
  public T getData()
  {
    return data;
  }

  /**
   * Accessor for the left child of the node
   */
  public TreeNode<T> getLeft()
  {
    return left;
  }

  /**
   * Accessor for the right child of the node
   */
  public TreeNode<T> getRight()
  {
    return right;
  }

  /**
   * Change the left child reference of this node; may be null
   * 
   * @param left TreeNode to set left to
   */
  public void setLeft(TreeNode<T> left)
  {
    this.left = left;
  }

  /**
   * Change the right child reference of this node; may be null
   * 
   * @param left TreeNode to set right to
   */
  public void setRight(TreeNode<T> right)
  {
    this.right = right;
  }

  /**
   * returns a string representation of this nodes data
   */
  public String toString()
  {
    return data.toString();
  }
}
