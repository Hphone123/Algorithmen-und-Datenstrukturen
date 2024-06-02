package MaxHeap;

import java.util.*;

//-----------------------------------------------------------------//
public class MaxHeap<T extends Comparable<T>> {
  //-----------------------------------------------------------------//
  //------------- !!Do not change the following lines!! -------------//
  public String toString() {
    return heap_.toString();  // don't change because of backend
  }

  //---------------------------------------------------------------//
  //--------------- !!Insert your solution below!! ----------------//
  private List<T> heap_;  // or Vector

  //---------------------------------------------------------------//
  public MaxHeap() {
    heap_ = new ArrayList<T>();
  }

  //---------------------------------------------------------------//
  public MaxHeap(T[] arr) {
    heap_ = new ArrayList<T>(Arrays.asList(arr));
    for (int i = arr.length/2 - 1; i >= 0; i--) {
      downHeap(i);
    }
  }

  //---------------------------------------------------------------//
  public List<T> getHeap(){
    return heap_;
  }

  //---------------------------------------------------------------//
  public int getSize() {
    return heap_.size();
  }

  //---------------------------------------------------------------//
  public boolean isEmpty() {
    return heap_.isEmpty();
  }

  //---------------------------------------------------------------//
  public final void downHeap(int n) {
    int parent = n;
    int left = 2*n + 1;
    int right = 2*n + 2;

    if (left < heap_.size() && heap_.get(left).compareTo(heap_.get(parent)) > 0) parent = left;
    if (right < heap_.size() && heap_.get(right).compareTo(heap_.get(parent)) > 0) parent = right;

    if (parent != n) {
      //? Swap n and parent Object in the Heap
      T temp = heap_.get(n);
      heap_.set(n, heap_.get(parent));
      heap_.set(parent, temp);

      //? Repeat
      downHeap(parent);
    }
  }

  //---------------------------------------------------------------//
  public void insert(T obj) {
    heap_.add(obj);
    upHeap(getSize()-1);
  }

  //---------------------------------------------------------------//
  private void upHeap(int n) {
    int parent = (n-1) / 2;

    if (parent >= 0 && heap_.get(n).compareTo(heap_.get(parent)) > 0) {
      //? Swap n and Parent in the Heap
      T temp = heap_.get(n);
      heap_.set(n, heap_.get(parent));
      heap_.set(parent, temp);

      upHeap(parent);
    }
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    MaxHeap<Integer> heap = new MaxHeap<Integer>();

    heap.insert(3);
    heap.insert(8);
    heap.insert(4);
    heap.insert(15);
    heap.insert(100);

    System.out.println(heap.getSize());
    System.out.println(heap.getHeap());
    System.out.println(heap.isEmpty());
  }
}
