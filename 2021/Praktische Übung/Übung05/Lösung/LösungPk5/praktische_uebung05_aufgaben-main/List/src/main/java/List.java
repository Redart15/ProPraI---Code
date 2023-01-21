class List {

  private ListNode head;

  public List() {
    head = null;
  }

  public ListNode getHead() {
    return head;
  }

  public List(ListNode ln) {
    head = ln;
  }

  public void reverse() {

    ListNode ln1, ln2, ln3, ln4;

    if (head == null) {
      return;
    }

    ln1 = head;
    ln2 = head.next;
    ln3 = null;

    while (ln2 != null) {
      ln4 = ln2.next;
      ln1.next = ln3;
      ln3 = ln1;
      ln1 = ln2;
      ln2 = ln4;
    }

    head = ln1;
  }

  public boolean hasLoop() {
    ListNode ln1, ln2;
    if ((head == null) || (head.next == null)) {
      return false;
    }

    ln1 = head;
    ln2 = head.next;

    while (true) {
      if (ln1 == ln2) {
        return true;
      }

      if (ln1.next == null) {
        return false;
      }
      else {
        ln1 = ln1.next;
      }

      if (ln1 == ln2) {
        return true;
      }

      if (ln2.next == null) {
        return false;
      }
      else {
        ln2 = ln2.next;
      }

      if (ln1 == ln2) {
        return true;
      }

      if (ln2.next == null) {
        return false;
      }
      else {
        ln2 = ln2.next;
      }
    }
  }
}
