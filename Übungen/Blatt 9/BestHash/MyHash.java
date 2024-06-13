package BestHash;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//---------------------------------------------------------------//
public class MyHash {
  //-------------------------------------------------------------//
  //-------------- !!Insert your solution below!! ---------------//
  public BucketArray e_;  //<-- !! USE ONLY THIS ARRAY !!
  int size_;              //the capacity of the array

  //-------------------------------------------------------------//
  public MyHash(int size) {
    this.size_ = size;
    e_ = new BucketArray(size);
  }

  //-------------------------------------------------------------//
  public void insert(String s) {
    int hash = createHash(s);
    int index = Math.floorMod(hash, size_);

    int i = 0;
    while (!e_.insert(index, s)) {
      index = Math.floorMod(hash + ++i^2, size_);
    }
  }

  private int createHash (String __s) {
    int hash = 0;
    for (int i = 0; i < __s.length(); i++) {
      hash += (__s.charAt(i) - 60) * (i+1);
    }

    //? Hash is the Value of each character, weight by how far they are in the String to make the hash as "unique" to any string as possible

    return hash;
  }

  //-------------------------------------------------------------//
  public static void main(String[] args) {
    // Idea for test
    int size = 1249;  // only an example (backend test)
    MyHash hash = new MyHash(size);
    try {
      DataInput s = new DataInputStream(new FileInputStream("C:\\Workspace\\Java\\AuD\\Übungen\\Blatt 9\\BestHash\\ww1.txt"));
      // use correct Path
      String line;
      while ((line = s.readLine()) != null) {
        hash.insert(line);
      }
    } catch (IOException e) {
      System.out.println("File not found");
    }
    System.out.println(hash.e_.toString());
    System.out.println("Collisions: " + hash.e_.getCollisions() + "\n");
  }

  //---------------------------------------------------------------//
  //---------------------------------------------------------------//
  //--------------- !!Do not change the code below!! --------------//
  class BucketArray {
    protected String[] arr;
    protected int col;

    //-------------------------------------------------------------//
    public BucketArray(int size) {
      col = 0;
      arr = new String[size];
    }

    //-------------------------------------------------------------//
    /**Insert the String s at index pos into the the BucketArray.
       If this index is already filled/blocked by another String,
       s is *NOT* added and false is returned.
       \return - true, if s was added correctly
               - false, if there is already an entry for this position.*/
    public boolean insert(int pos, String s) {
      if (arr[pos] == null) {
        arr[pos] = s;
        return true;
      }
      col++;
      return false;
    }

    //-------------------------------------------------------------//
    public int getCollisions() {
      return col;
    }

    //-------------------------------------------------------------//
    public String toString() {
      String res = new String();
      for (String s : arr)
        res += s + "\n";
      return res;
    }
  }
}
