public class test
{
  public static void main(String[] args)
  {
    new Truck().start();
  }

}


class Vehicle
{
  public void start()
  {
    System.out.print("On. ");
  }
}


class Truck extends Vehicle
{
  public void start()
  {
    System.out.print("Vroom. ");
  }
}
