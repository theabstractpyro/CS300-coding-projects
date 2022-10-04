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
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * tests FolderExplorer
 * 
 * @author ash WC
 */
public class FolderExplorerTester
{
  /**
   * tests if getContents returns the expected arraylist or exception
   * 
   * @param folder the directory which contains files to pass into getContents
   * @return true if it passed, false if it failed
   */
  public static boolean testGetContents(File folder)
  {
    try
    {
      // Scenario 1
      // list the basic contents of the cs300 folder
      ArrayList<String> listContent = FolderExplorer.getContents(folder);
      // expected output must contain "exams preparation", "grades",
      // "lecture notes", "programs", "reading notes", "syllabus.txt",
      // and "todo.txt" only.
      String[] contents = new String[]
      {"exams preparation", "grades", "lecture notes", "programs", "reading notes", "syllabus.txt",
          "todo.txt"};
      List<String> expectedList = Arrays.asList(contents);
      // check the size and the contents of the output
      if (listContent.size() != 7)
      {
        System.out.println("Problem detected: cs300 folder must contain 7 elements.");
        return false;
      }
      for (int i = 0; i < expectedList.size(); i++)
      {
        if (!listContent.contains(expectedList.get(i)))
        {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of cs300 folder.");
          return false;
        }
      }
      // Scenario 2 - list the contents of the grades folder
      File f = new File(folder.getPath() + File.separator + "grades");
      listContent = FolderExplorer.getContents(f);
      if (listContent.size() != 0)
      {
        System.out.println("Problem detected: grades folder must be empty.");
        return false;
      }
      // Scenario 3 - list the contents of the p02 folder
      f = new File(folder.getPath() + File.separator + "programs" + File.separator + "p02");
      listContent = FolderExplorer.getContents(f);
      if (listContent.size() != 1 || !listContent.contains("FishTank.java"))
      {
        System.out.println(
            "Problem detected: p02 folder must contain only " + "one file named FishTank.java.");
        return false;
      }
      // Scenario 4 - List the contents of a file
      f = new File(folder.getPath() + File.separator + "todo.txt");
      try
      {
        listContent = FolderExplorer.getContents(f);
        System.out.println("Problem detected: Your FolderExplorer.getContents() must "
            + "throw a NotDirectoryException if it is provided an input which is not"
            + "a directory.");
        return false;
      } catch (NotDirectoryException e)
      { // catch only the expected exception
        // no problem detected
      }
      // Scenario 5 - List the contents of not found directory/file
      f = new File(folder.getPath() + File.separator + "music.txt");
      try
      {
        listContent = FolderExplorer.getContents(f);
        System.out.println("Problem detected: Your FolderExplorer.getContents() must "
            + "throw a NotDirectoryException if the provided File does not exist.");
        return false;
      } catch (NotDirectoryException e)
      {
        // behavior expected
      }
    } catch (Exception e)
    {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * tests getDeepContents' base case.
   * 
   * @param folder the directory which contains files to pass into getDeepContents
   * @return true if it passed, false if it failed
   */
  public static boolean testDeepGetContentsBaseCase(File folder)
  {
    try
    {
      File f = new File(folder.getPath() + File.separator + "reading notes");
      ArrayList<String> listContent = FolderExplorer.getDeepContents(f);
      String[] contents = new String[]
      {"zyBooksCh1.txt", "zyBooksCh2.txt", "zyBooksCh3.txt", "zyBooksCh4.txt"};
      List<String> expectedList = Arrays.asList(contents);
      // should check if everything in expectedList is right
      for (int i = 0; i < expectedList.size(); i++)
      {
        if (!listContent.contains(expectedList.get(i)))
        {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of reading notes folder.");
          return false;
        }
      }
    } catch (Exception e)
    {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * tests if getDeepContents' recursive case returns the proper arraylist or exception
   * 
   * @param folder the directory which contains files to pass into getDeepContents
   * @return true if it passed, false if it failed
   */
  public static boolean testDeepListRecursiveCase(File folder)
  {
    try
    {
      // Scenario 1
      // tests files in programs directory and subdirectories
      File f = new File(folder.getPath() + File.separator + "programs");

      System.out.println(FolderExplorer.getDeepContents(folder));

      ArrayList<String> listContent = FolderExplorer.getDeepContents(f);
      String[] contents = new String[]
      {"ClimbingTracker.java", "ClimbingTrackerTester.java", "FishTank.java",
          "ExceptionalClimbing.java", "ExceptionalClimbingTester.java", "Program01.pdf",
          "Program02.pdf", "Program03.pdf"};
      List<String> expectedList = Arrays.asList(contents);
      // should check if everything in expectedList is right
      // System.out.println(listContent.toString());
      for (int i = 0; i < expectedList.size(); i++)
      {
        if (!listContent.contains(expectedList.get(i)))
        {
          // System.out.println(listContent.get(i));
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of programs folder.");
          return false;
        }
      }
      // Scenario 2
      // tests if getDeepContents throws the proper exception
      f = new File(folder.getPath() + File.separator + "music.txt");
      try
      {
        listContent = FolderExplorer.getDeepContents(f);
        System.out.println("Problem detected: Your FolderExplorer.getDeepContents() must "
            + "throw a NotDirectoryException if the provided File does not exist.");
        return false;
      } catch (NotDirectoryException e)
      {
        // behavior expected
      }
    } catch (Exception e)
    {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * tests if lookupByName returns the proper path to the file
   * 
   * @param folder the directory which contains files to pass into lookupByName
   * @return true if it passed, false if it failed
   */
  public static Boolean testLookupByFileName(File folder)
  {
    try
    {
      // Scenario 1
      // tries to find Program02.pdf
      File f = new File(folder.getPath());
      if (!FolderExplorer.lookupByName(f, "Program02.pdf")
          .equals("cs300\\programs\\writeUps\\Program02.pdf"))
      {
        return false;
      }

      /// *
      // Scenario 2
      // tests if the exceptions work right
      try
      {
        // should throw exception
        FolderExplorer.lookupByName(folder, "abc.123");
        System.out.println(
            "Problem detected: Your FolderExplorer.lookupByName() must throw a NotDirectoryException if it cant find the file");
        return false;
      } catch (NoSuchElementException e)
      {
        // behavior expected
      }
      // */


    } catch (Exception e)
    {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * tests if lookupByKey returns the proper arraylist
   * 
   * @param folder the directory which contains files to pass into lookupByKey
   * @return true if it passed, false if it failed
   */
  public static Boolean testLookupByKeyBaseCase(File folder)
  {
    try
    {
      System.out.println(FolderExplorer.lookupByKey(folder, "zyBooks"));

      // Scenario 1
      // gets all files with zyBooks in the name in reading notes
      File f = new File(folder.getPath() + File.separator + "reading notes");
      ArrayList<String> listContent = FolderExplorer.lookupByKey(f, "zyBooks");
      String[] contents = new String[]
      {"zyBooksCh1.txt", "zyBooksCh2.txt", "zyBooksCh3.txt", "zyBooksCh4.txt"};
      List<String> expectedList = Arrays.asList(contents);
      // should check if everything in expectedList is right
      for (int i = 0; i < expectedList.size(); i++)
      {
        if (!listContent.contains(expectedList.get(i)))
        {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of reading notes folder.");
          return false;
        }
      }
      // System.out.println(FolderExplorer.lookupByKey(f, "zyBooks"));
    } catch (Exception e)
    {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * tests if lookupByKey returns the proper arraylist
   * 
   * @param folder the directory which contains files to pass into lookupByKey
   * @return true if it passed, false if it failed
   */
  public static Boolean testLookupBySize(File folder)
  {
    try
    {
      // Scenario 1
      // gets all files with zyBooks in the name in reading notes
      File f = new File(folder.getPath() + File.separator + "exams preparation");
      ArrayList<String> listContent =
          FolderExplorer.lookupBySize(f, (long) 0, (long) (Math.pow(2, 38)));
      String[] contents = new String[]
      {"codeSamples.java", "outline.txt"};
      List<String> expectedList = Arrays.asList(contents);
      // should check if everything in expectedList is right
      // System.out.println("tester - listContent: " + listContent);
      for (int i = 0; i < expectedList.size(); i++)
      {
        if (!listContent.contains(expectedList.get(i)))
        {
          System.out.println("Problem detected: " + expectedList.get(i)
              + " is missing from the output of the list contents of exams preparation folder.");
          return false;
        }
      }
      // System.out.println(FolderExplorer.lookupByKey(f, "zyBooks"));
    } catch (Exception e)
    {
      System.out.println("Problem detected: Your FolderExplorer.getContents() has thrown"
          + " a non expected exception.");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * main method, runs all the tests and prints out if they failed or not
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    System.out.println("testGetContents: " + testGetContents(new File("cs300")));
    System.out
        .println("testDeepGetContentsBaseCase: " + testDeepGetContentsBaseCase(new File("cs300")));
    System.out
        .println("testDeepGetContentsBaseCase: " + testDeepListRecursiveCase(new File("cs300")));
    System.out.println("testLookupByFileName: " + testLookupByFileName(new File("cs300")));
    System.out.println("testLookupByKeyBaseCase: " + testLookupByKeyBaseCase(new File("cs300")));
    System.out.println("testLookupBySize: " + testLookupBySize(new File("cs300")));
  }
}
