/**
 * CS300 - Programming II University of Wisconsin at Madison  
 * BinaryNode: Generic class implementing a BinaryNode of a BinarySearchTree (BST)
 * 
 */

public class BinaryNode<T> {
  private T data; // data in the node field
  private BinaryNode<T> left; // reference to the left child
  private BinaryNode<T> right; // reference to the right child

  /**
   * Creates a binary node with a given data value
   * 
   * @param data
   */
  public BinaryNode(T data) {
     this.data = data;
  }

  // If you would use the following constructor should make
  // sure that the given left reference refers to a BinarySearchTree,
  // the right reference refers to a BinarySearchTree as well, and
  // that left.getData().compareTo(data) is negative (<0), and
  // right.getData().compareTo(data) is positive (>0).
  // Otherwise, the search order property for a binary search tree will
  // be violated.
  /**
   * Creates a BinaryNode with given data value, a reference to a left child (left subtree) and a
   * reference to a right child (right sub-tree)
   * 
   * @param data element held by this binary node
   * @param left reference to the left child
   * @param right reference to the right child
   */
  public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  // Setters and Getters Methods

  /**
   * Getter of left child
   * 
   * @return the left
   */
  public BinaryNode<T> getLeft() {
    return left;
  }

  /**
   * Setter for left child
   * 
   * @param left the left to set
   */
  public void setLeft(BinaryNode<T> left) {
    this.left = left;
  }

  /**
   * Getter of the right child
   * 
   * @return the right
   */
  public BinaryNode<T> getRight() {
    return right;
  }

  /**
   * Setter for the right child
   * 
   * @param right the right to set
   */
  public void setRight(BinaryNode<T> right) {
    this.right = right;
  }

  /**
   * Getter of data field
   * 
   * @return the data
   */
  public T getData() {
    return data;
  }

  


  // Depth-level traversal algorithms

  /**
   * Print tree rooted at current node using preorder traversal.
   */
  public void printPreOrder() {
    // TODO complete this code to implement a recursive algorithm that prints the content of
    // the tree rooted at this (current) node using preorder traversal
    // process current Node
    System.out.print(data + " ");
    // process left child (left sub-tree)
    
    // process right child (right sub-tree)

  }

  /**
   * Print tree rooted at current node using postorder traversal.
   */
  public void printPostOrder() {
    // TODO complete this code to implement a recursive algorithm that prints the content of
    // the tree rooted at this (current) node using postorder traversal
    // process left child (left sub-tree)

    // process right child (right sub-tree)

    // process current Node
  }


  /**
   * Print tree rooted at current node using inorder traversal.
   */
  public void printInOrder() {
    // TODO complete this code to implement a recursive algorithm that prints the content of
    // the tree rooted at this (current) node using inorder traversal
    
    // Left child (left sub-tree)

    // process current Node
    // process right child (right sub-tree)
  }

  /**
   * main method (tests the implementation of the BinaryNode class)
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Test scenarios
    BinaryNode<Integer> root =
        new BinaryNode<Integer>(50, new BinaryNode<Integer>(40,
           new BinaryNode<Integer>(3), new BinaryNode<Integer>(41) ), 
            new BinaryNode<Integer>(60, new BinaryNode<Integer>(55), null));
    //              50
    //            /    \
    //          40     60
    //        /   \    /
    //       3    41  55
    System.out.print("Preorder traversal: ");
    root.printPreOrder();
    System.out.println();
    System.out.print("Inorder traversal: ");
    root.printInOrder();
    System.out.println();
    System.out.print("Postorder traversal: ");
    root.printPostOrder();
  }

}