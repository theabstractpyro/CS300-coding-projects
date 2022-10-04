
public class LinkedNode<T>
{
  private T data;
  private LinkedNode<T> next;

  public LinkedNode(T data)
  {
    this.data = data;
  }

  public LinkedNode(T data, LinkedNode<T> next)
  {
    this.data = data;
    this.next = next;
  }
}
