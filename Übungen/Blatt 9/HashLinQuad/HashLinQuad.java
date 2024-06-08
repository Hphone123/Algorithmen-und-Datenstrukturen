package HashLinQuad;

//-----------------------------------------------------------------//
/** simple Hashtable with linear/quadratic probing
    capacity is big enough */

public class HashLinQuad {
  //---------------------------------------------------------------//
  private int[] table_;    // array of buckets or slots
  private int size_;       // current number of elements
  private int capacity_;

  public HashLinQuad(int __size) {
    table_ = new int[__size];
    size_ = 0;
    capacity_ = __size;

    for (int i = 0; i < table_.length; i++) {
      table_[i] = -1; //? -1 signals a spot in the table is free
    }
  }

  //---------------------------------------------------------------//
  public int addLin(int obj) {
    int col = 0; //? Colisions

    int hash = Math.floorMod(obj, capacity_); //? Hash function -> ceiling(obj/size_)

    while (table_[hash] != -1) {
      hash = Math.floorMod(hash + 1, capacity_);
      col++;
    }

    table_[hash] = obj;
    size_++;
    return col;
  }

  //---------------------------------------------------------------//
  public int addQuad(int obj) {
    int col = 0; //? Colisions

    int hash = Math.floorMod(obj, capacity_); //? Hash function -> ceiling(obj % capacity_)
    int i = 0;
    while (table_[hash] != -1) {
      hash = Math.floorMod(obj + i^2, capacity_);
      col++; i++;
    }

    table_[hash] = obj;
    size_++;
    return col;

  }

  //---------------------------------------------------------------//
  public String toString() {
    String res = "Cap.: " + size_ + "/" + capacity_ + " -> [";
    for (int i = 0; i < table_.length; i++) {
      if (table_[i] < 0) res += "-";
      else res += table_[i];
      res += ",";
    }
    res += "]";
    return res;
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    HashLinQuad hashTaLin = new HashLinQuad(11);
    int linCol = 0;
    for (int i = 0; i < 11; i++) {
      linCol += hashTaLin.addLin((int)(Math.random() * 11));
    }
    System.out.println("Collisions with linear probing: " + linCol);
    System.out.println(hashTaLin.toString());
  
    HashLinQuad hashTaQuad = new HashLinQuad(11);
    int quadCol = 0;
    for (int i = 0; i < 11; i++) {
      quadCol += hashTaQuad.addLin((int)(Math.random() * 11));
    }
    System.out.println("Collisions with quadratic probing: " + quadCol);
    System.out.println(hashTaQuad.toString());
  }
}
