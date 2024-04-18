package IntSList;

import java.util.function.Predicate;

import aud.SList;

// This class "wraps" an instance of `SList<Integer>` (attribute
// `li`): Calls to `toString()` and `push_front()` are "delegated" to
// the instance.
// The additional method `filter()` applies a predicate and constructs
// a new list with all items for which the predicate evaluates to `true`.
//
public class IntSList {
  // Store list of integers as an SList.
  SList<Integer> li;

  // Just construct a new SList
  public IntSList() {
    li = new SList<Integer>();
  }

  // delegate to SList
  @Override
  public String toString() {
    return li.toString();
  }

  // delegate to SList
  public void push_front(int obj){
    li.push_front(obj);
  }

  // Filter list by predicate `p` and return list of all items for
  // which predicate evaluates to `true`.
  // The order of items in the returned list may differ from the order
  // in `this` list (because we use always `push_front()`).
  //
  public IntSList filter(Predicate<Integer> p){
    IntSList filtered = new IntSList();
    for (Integer integer : li) {
      if (p.test(integer)) filtered.push_front(integer);
    }
    return filtered;
  }

  // You must provide a main() method!
  public static void main(String args[]) {
    Predicate<Integer> p = new Predicate<Integer>() {
      @Override
      public boolean test(Integer t) { // Method that provides the "test"
         if (t > 10 || t < -26) return true;
         return false;
      }
    };

    IntSList list = new IntSList();

    for (Integer i = -54; i < 48; i++) { // Simple loop to fill the list
      list.push_front(i);
    }

    System.out.println(list.filter(p));
  }
}
