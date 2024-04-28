package SListIterator;

/**MySList represents a single linked list, which holds elements of type
   integer.*/
public class MySList implements Iterable<Integer> {
  //-----------------------------------------------------------------//
  //------------- !!Do not change the following lines!! -------------//
  public String toString() {
    if (empty())
      return "[]";
    String rv = "[";
    Node node = head_;
    do {
      rv += node.data_;
      if (node.next_ != null)
        rv += ",";
      node = node.next_;
    } while(node != null);
    rv += "]";
    return rv;
  }

  //-----------------------------------------------------------------//
  //---------------- !!Insert your solution below!! -----------------//
  /**Node represents a single element in the list.*/
  class Node {
    int data_;                         //!! Do not change this line !!
    Node next_ = null;
  }

  //----------------------------------------------------------------//
  Node head_ = null;
  Node tail_ = null;

  //----------------------------------------------------------------//
  public MySList(int objects []) {
    for (int i : objects) {
      push_back(i);
    }
  }

  public MySList () {
    // This is just here so Rössl's test system doesnt brake
  }

  public boolean empty () {
    return (head_ == null && tail_ == null);
  }

  public final void push_back (int obj) {
    Node node = new Node();
    node.data_ = obj;
    node.next_ = null;
    if (head_ == null) {
      head_ = node;
      tail_ = node;
      return;
    }
    tail_.next_ = node;
    tail_ = node;
    if (head_.next_ == null) {
      head_.next_ = node;
    }
    return;
  }

  //----------------------------------------------------------------//
  /**Iterator is used to traverse odd elements in a list.*/
  public class Iterator implements java.util.Iterator<Integer> {

    Node node;

    public Iterator () {
      node = head_;
    };

    @Override
    public boolean hasNext () {
      if (node == null) return false;
      if (node.data_ % 2 != 0) {
        return true;
      }
      node = node.next_;
      return hasNext();
    }

    @Override
    public Integer next () {
      int res = node.data_;
      node = node.next_;
      return res;
    }
  }

  //----------------------------------------------------------------//
  public Iterator iterator() {
    return new Iterator();
  }

  //----------------------------------------------------------------//
  public static void main(String[] args) {
    MySList list = new MySList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
    for (Integer integer : list) {
      System.out.println(integer);
    }
    System.out.println(list.toString());
    System.out.println(list.empty());
    
    list.push_back(27);
    list.push_back(89);
    
    for (Integer integer : list) {
      System.out.println(integer);
    }
    System.out.println(list.toString());
    return;
  }
}
