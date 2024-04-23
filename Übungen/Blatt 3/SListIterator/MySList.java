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
    // TODO: further implementation of `Node`
  }

  //----------------------------------------------------------------//
  Node head_ = null;

  //----------------------------------------------------------------//
  public MySList() {
    // TODO: Constructor
  }

  //----------------------------------------------------------------//
  // TODO: implement (at least) a function to insert an element
  //       into MySList

  //----------------------------------------------------------------//
  /**Iterator is used to traverse odd elements in a list.*/
  public class Iterator implements java.util.Iterator<Integer> {
    // TODO: implement the Iterator, which walks over odd elements
  }

  //----------------------------------------------------------------//
  public Iterator iterator() {
    // TODO: implement this method, which returns a new iterator instance
  }

  //----------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: test your code with appropriate examples
  }
}
