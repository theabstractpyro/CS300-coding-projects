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

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * folderExplorer class, it traverses files and stuff
 * 
 * @author Ash WC
 *
 */
public class FolderExplorer
{
  /**
   * throws notDirectoryException if the file does not exist
   * 
   * @param currentDirectory directory to check
   * @throws NotDirectoryException if directory does not exist
   */
  private static void existsHelper(File currentDirectory) throws NotDirectoryException
  {
    // check wither the file exists
    if (!currentDirectory.exists())
    {
      throw new NotDirectoryException("The input file does not exist");
    }
  }

  /**
   * gets the contents (files and directories) from a directory
   * 
   * @param currentDirectory the directory that the method is currently in
   * @return a list of the names of all files and directories in the the given folder
   *         currentDirectory.
   * @throws NotDirectoryException with a description error message if the provided currentDirectory
   *                               does not exist or if it is not a directory
   */
  public static ArrayList<String> getContents(File currentDirectory) throws NotDirectoryException
  {
    existsHelper(currentDirectory);
    if (!currentDirectory.isDirectory())
    {
      throw new NotDirectoryException("The input file is not a directory");
    }
    ArrayList<String> returns = new ArrayList<String>();
    for (int i = 0; i < currentDirectory.list().length; i++)
    {
      // System.out.println(i);
      // System.out.println(currentDirectory.list()[i]);
      returns.add(currentDirectory.list()[i]);
    }
    return returns;
  }

  /**
   * helper which returns an arraylist of files in the directory and the subdirectories in
   * currentDirectory
   * 
   * @param currentDirectory the directory to look through
   * @return an arrayList of all the files in in the directory and the subdirectories of
   *         currentDirectory
   */
  private static ArrayList<File> listFileHelper(File currentDirectory)
  {
    ArrayList<File> returns = new ArrayList<File>();
    // searches through currentDirectory directory, and adds any files in it to returns list
    for (int i = 0; i < currentDirectory.listFiles().length; i++)
    {
      // returns.add(currentDirectory.listFiles(File::isFile)[i]);

      // System.out.println("currDir: " + currentDirectory);
      File current = currentDirectory.listFiles()[i];
      // System.out.println("currDir.listFiles: " + currentDirectory.listFiles()[i]);
      if (current.isFile())
      {
        returns.add(current);
      }

    }
    // searches currentDirectory for subdirectories, and recursively runs getDeepContents for
    // subdirectories
    for (int i = 0; i < currentDirectory.listFiles().length; i++)
    {
      // returns.addAll(listFileHelper(currentDirectory.listFiles(File::isDirectory)[i]));

      File current = currentDirectory.listFiles()[i];
      // System.out.println("currDir.listFiles: " + currentDirectory.listFiles()[i]);

      if (current.isDirectory())
      {
        returns.addAll(listFileHelper(currentDirectory.listFiles()[i]));
      }

    }
    return returns;
  }

  /**
   * Recursive method that lists the names of all the files (not directories) in the given directory
   * and its sub-directories.
   * 
   * @param currentDirectory the directory that the method is currently in
   * @return names of all the files (not directories) in the given directory and its
   *         sub-directories.
   * @throws NotDirectoryException with a description error message if the provided currentDirectory
   *                               does not exist or if it is not a directory
   */
  public static ArrayList<String> getDeepContents(File currentDirectory)
      throws NotDirectoryException
  {
    existsHelper(currentDirectory);
    if (!currentDirectory.isDirectory())
    {
      throw new NotDirectoryException("The input file is not a directory");
    }

    // creates empty list
    ArrayList<String> returns = new ArrayList<String>();
    // creates files list with files from currentDirectory and its subdirectories
    ArrayList<File> files = listFileHelper(currentDirectory);
    for (int i = 0; i < files.size(); i++)
    {
      returns.add(files.get(i).getName());
    }
    return returns;
  }

  /**
   * Searches the given directory and all of its sub-directories for an exact match to the provided
   * fileName. This method must be recursive or must use a recursive private helper method to
   * operate.
   * 
   * @param currentDirectory the directory that the method is currently in
   * @param fileName         file to create a path to
   * @return a path to the file, if it exists.
   * @throws NoSuchElementException with a descriptive error message if the search operation returns
   *                                with no results found (including the case if fileName is null or
   *                                currentDirectory does not exist, or was not a directory)
   */
  public static String lookupByName(File currentDirectory, String fileName)
  {
    // exceptions for the inputs
    if (!currentDirectory.exists())
    {
      throw new NoSuchElementException("input directory does not exist");
    }
    if (!currentDirectory.isDirectory())
    {
      throw new NoSuchElementException("input directory is not a directory");
    }
    if (fileName == null)
    {
      throw new NoSuchElementException("input fileName equals null");
    }
    String returns = "";
    // creates files arrayList, then looks through it to try to find a match to fileName
    ArrayList<File> files = listFileHelper(currentDirectory);
    for (int i = 0; i < files.size(); i++)
    {
      if (files.get(i).getName().equals(fileName))
      {
        // returns the files path if its found
        return files.get(i).getPath();
      }
    }
    if (returns == "")
    {
      throw new NoSuchElementException("input fileName equals null");
    }
    return returns;
  }

  /**
   * Recursive method that searches the given folder and its sub-directories for ALL files that
   * contain the given key in part of their name.
   * 
   * @param currentDirectory the directory that the method is currently in
   * @param key              string to find in files (filename must have this in it)
   * @return An arraylist of all the names of files that match and an empty arraylist when the
   *         operation returns with no results found (including the case where currentDirectory is
   *         not a directory).
   */
  public static ArrayList<String> lookupByKey(File currentDirectory, String key)
  {
    // creates returns array to return
    ArrayList<String> returns = new ArrayList<String>();
    // creates files arrayList, then looks through it to try to find something that contains key
    ArrayList<File> files = listFileHelper(currentDirectory);
    for (int i = 0; i < files.size(); i++)
    {
      if (files.get(i).getName().contains(key))
      {
        // adds the file name to returns if found
        returns.add(files.get(i).getName());
      }
    }
    return returns;
  }

  /**
   * Recursive method that searches the given folder and its sub-directories for ALL files whose
   * size is within the given max and min values, inclusive.
   * 
   * @param currentDirectory the directory that the method is currently in
   * @param sizeMin          minimum size for file to be
   * @param sizeMax          maximum size for file to be
   * @return an array list of the names of all files whose size are within the boundaries and an
   *         empty arraylist if the search operation returns with no results found (including the
   *         case where currentDirectory is not a directory).
   */
  public static ArrayList<String> lookupBySize(File currentDirectory, long sizeMin, long sizeMax)
  {
    // creates returns array to return
    ArrayList<String> returns = new ArrayList<String>();
    // creates files arrayList, then looks through it to try to find something is between sizeMin
    // and sizeMax in size
    ArrayList<File> files = listFileHelper(currentDirectory);
    for (int i = 0; i < files.size(); i++)
    {
      if (files.get(i).getTotalSpace() >= sizeMin && files.get(i).getTotalSpace() <= sizeMax)
      {
        // adds the file name to returns if found
        returns.add(files.get(i).getName());
      }
    }
    return returns;
  }

}
