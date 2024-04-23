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
    // TODO: return the size of the ring buffer
  }

  //-----------------------------------------------------------------//
  public boolean empty() {
    // TODO: return if the ring buffer is empty
  }

  //-----------------------------------------------------------------//
  public void push_back(T obj) {
    // TODO: append an element at the 'end' of the end buffer
  }

  //-----------------------------------------------------------------//
  public void pop_front() {
    // TODO: remove an element at the 'front' if the ring buffer
  }

  //-----------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: test your code with appropriate examples
  }
}
