
import java.util.ArrayList;
import java.util.Scanner;

public class IntegerManager
{
  public static void printSize(ArrayList<Integer> numsList)
  {
    System.out.println(numsList.size() + " items");
  }

  public static void main(String[] args)
  {
    Scanner scnr = new Scanner(System.in);
    int currVal;
    ArrayList<Integer> intList = new ArrayList<Integer>();

    printSize(intList);

    currVal = scnr.nextInt();
    while (currVal >= 0)
    {
      intList.add(currVal);
      currVal = scnr.nextInt();
    }

    printSize(intList);

    intList.clear();

    printSize(intList);
  }
}
