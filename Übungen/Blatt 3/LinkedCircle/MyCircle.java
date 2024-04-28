package LinkedCircle;

public class MyCircle<T> {
  //-----------------------------------------------------------------//
  //------------- !!Do not change the following lines!! -------------//
  //A Node is a single element int the ring
  class Node {
    T data_ = null;
    Node next_ = null;
    Node prev_ = null;

    Node(T obj, Node prv, Node nxt) {
      data_ = obj;
      prev_ = prv;
      next_ = nxt;
    }
  }

  //--- class members
  protected Node head_ = null;

  //--- class methods
  public   MyCircle() { head_ = null; }
  public T front()    { return head_.data_; }
  public String toString() {
    if (empty())
      return "[]";
    String rv = "[";
    Node node = head_;
    do {
      rv += node.data_.toString();
      if (node.next_ != head_)
        rv += ",";
      node = node.next_;
    } while(node != head_);
    rv += "]";
    return rv;
  }

  //-----------------------------------------------------------------//
  //---------------- !!Insert your solution below!! -----------------//
  public int size() {
    if (head_ == null) return 0;
    int i = 1;

    Node head = head_;
    Node curr = head_.next_;
    
    while (curr != head) {
      curr = curr.next_;
      i++;
    }
    return i;
  }

  //-----------------------------------------------------------------//
  public boolean empty() {
    if (head_ == null) return true;
    return false;
  }

  //-----------------------------------------------------------------//
  public void push_back(T obj) {
    if (head_ == null) {
      Node head = new Node(obj, null, null);
      head.prev_ = head;
      head.next_ = head;
      head_ = head;
    } else {
      Node back = new Node(obj, head_.prev_, head_);
      head_.prev_.next_ = back;
      head_.prev_ = back;
    }
  }

  //-----------------------------------------------------------------//
  // Shouldn't pop return the node?
  public void pop_front() {
    if (head_ == null) return;
    // If head is only node, pop == set to null
    if (head_.next_ == head_ && head_.prev_ == head_) {head_ = null;return;}
    head_.next_.prev_ = head_.prev_;
    head_.prev_.next_ = head_.next_;
    // Should head be moved to the next element on hte front or back???
    head_ = head_.next_;
  }

  //-----------------------------------------------------------------//
  public static void main(String[] args) {
    MyCircle<Integer> circle = new MyCircle<Integer>();
    circle.push_back(1);
    circle.push_back(2);
    circle.push_back(3);
    circle.push_back(4);
    circle.push_back(5);
    circle.push_back(6);

    System.out.println(circle.toString());

    circle.pop_front();
    circle.pop_front();
    circle.pop_front();

    System.out.println(circle.toString());
    System.out.println(circle.size());
    System.out.println(circle.empty());
  }
}
