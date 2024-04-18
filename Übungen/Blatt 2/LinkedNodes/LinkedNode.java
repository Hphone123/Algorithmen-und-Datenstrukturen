package LinkedNodes;

public class LinkedNode<T> {
  // Data
  private T data_ = null;
  private LinkedNode<T> next_ = null;

  // Constructoors
  public LinkedNode (T data, LinkedNode<T> next) {
    data_ = data;
    next_ = next;
  }
  
  public LinkedNode (T data) {
    data_ = data;
  }
  
  // Getters and Setters
  public T getData_() {
    return data_;
  }

  public void setData_(T data_) {
    this.data_ = data_;
  }

  public LinkedNode<T> getNext_() {
    return next_;
  }

  public void setNext_(LinkedNode<T> next_) {
    this.next_ = next_;
  }

  // Provide String-representation for list beginning at `this` node.
  @Override
  public String toString() {
    if (next_ == null) return data_.toString() + " > null";
    return (data_.toString() + " > " + next_.toString());
  }

  // You must provide a main() method!
  public static void main(String[] args) {
    LinkedNode<String> nodeSleep = new LinkedNode<String>("Schlafen gehen");
    LinkedNode<String> nodePlay = new LinkedNode<String>("Spielebend", nodeSleep);
    LinkedNode<String> nodeSleepIn = new LinkedNode<String>("Aufstehen", nodePlay);
    
    System.out.println(nodeSleepIn.toString());
    
    LinkedNode<String> nodeMensa = new LinkedNode<String>("Mensa gehen", nodePlay);
    LinkedNode<String> nodeUni = new LinkedNode<String>("Vorlsung besuchen", nodeMensa);

    // Set pointer to right next node
    nodeSleepIn.setNext_(nodeUni);
    
    System.out.println(nodeSleepIn.toString());
  }
}
