
public class ListMain {

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1, null);
    List list = new List(n1);
    System.out.println(list.hasLoop());
    list.reverse();
  }
 

}

