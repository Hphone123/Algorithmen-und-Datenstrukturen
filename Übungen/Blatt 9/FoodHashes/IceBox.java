package FoodHashes;

//---------------------------------------------------------------//
/**Container that can store food elements.*/
public class IceBox {

  Food [] hashTable_;
  int capacity_;
  int size_;

  //---------------------------------------------------------------//
  public IceBox (int capacity) {
    capacity_ = capacity; size_ = 0; hashTable_ = new Food[capacity_];
    for (int i = 0; i < hashTable_.length; i++) {
      hashTable_[i] = null;
    }
  }

  //---------------------------------------------------------------//
  public void add(Food obj) {
    if (size_ >= capacity_) return; //! If no check, infinite Loop!
    //? Uses linear probing -> easier for searching
    int hash = Math.floorMod(obj.hashCode(), capacity_);
    int origHash = hash;
    while (hashTable_[hash] != null && origHash != hash) {
      hash = Math.floorMod(++hash, capacity_);
    }
    hashTable_[hash] = obj;
    size_++;
  }

  //---------------------------------------------------------------//
  public boolean contains(Food obj) {
    int hash = Math.floorMod(obj.hashCode(), capacity_);

    while (hashTable_[hash] != null) {
      if (hashTable_[hash].equals(obj)) return true;
      hash = Math.floorMod(++hash, capacity_);
    }
    return false;
  }

  public String toString () {
    String res = "Ice Box:\n   Capacity: " + size_ + "/" + capacity_ + "\n   Items: [";

    for (int i = 0; i < hashTable_.length; i++) {
      if (hashTable_[i] == null) res += "-;";
      else res += "{" +  hashTable_[i].toString() + "};";
    }
    res += "]";
    return res;
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    IceBox box = new IceBox(11);

    Food wamel = new Food("Fruits","Watermelon", 20, 4);
    Food apple = new Food("Fruits","Green Apple", 25, 8);
    Food meth = new Food("Meat","Mett", 100, 7);
    Food bigmc = new Food("FastFood","BigMac", 3000, 9);
    Food doener = new Food("FastFood","Döner", 2500, 10);
    Food chips = new Food("Snacks","Chips", 800, 10);
    Food konklo = new Food("German Quisine","Königsberger Klopse", 600, 1);
    Food tomat = new Food("Vegetables","Tomatoes", 10, 8);
    Food salad = new Food("Vegetables","Salad", 5, 6);
    Food tofu = new Food("Halal","Tofu", 60, 1);
    Food mold = new Food("Trash","Moldy Bread", 0, 10);

    box.add(wamel);
    box.add(apple);
    box.add(meth);
    box.add(bigmc);
    box.add(doener);
    box.add(chips);
    box.add(konklo);
    box.add(tomat);
    box.add(salad);
    box.add(tofu);
    box.add(mold);

    System.out.println(box.toString());

    System.out.println(box.contains(mold));

    Food amogus = new Food("Amogus", "Imposter", 99999, 11);

    System.out.println(amogus.toString() + " -> " + amogus.hashCode());
    System.out.println(box.contains(amogus));
  
    box.add(amogus);

    System.out.println(box.contains(amogus));
  }

}
