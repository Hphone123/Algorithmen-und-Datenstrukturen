package MyDList;

import aud.DList;


public class MyDList<T> extends DList<T> {
//-----------------------------------------------------------------//
  public MyDList() {
    super();
  }

//-----------------------------------------------------------------//
  public void append(MyDList<T> li) {
    MyDList<T> cpy = new MyDList<T>();

    // Create new instance that is not a reference to li
    for (T t : li) {
      cpy.push_back(t);
    }
    for (T t : cpy) {
      this.push_back(t);
    }
    return;
  }

//-----------------------------------------------------------------//
  public void insert(int n, MyDList<T> li) {
    MyDList<T> cpy = new MyDList<T>();

    // Create a new MyDList instance that is not a pointer copy of li
    // If li and this are the same instance, the copying will go on forever, because the iterator wont reach the end of the List
    for (T t : li) {
      cpy.push_back(t);
    }

    // Iterate backwards
    for (T t : cpy.backwards()) {
      this.insert(n, t);
    }
  }

//-----------------------------------------------------------------//
  public static void main(String[] args) {
    MyDList<Integer> list = new MyDList<Integer>();
    list.push_back(1);
    list.push_back(2);
    list.push_back(3);
    list.push_back(4);
    System.out.println(list.toString());

    list.append(list);

    System.out.println(list.toString());

    list.insert(3, list);

    System.out.println(list.toString());
  }
}
