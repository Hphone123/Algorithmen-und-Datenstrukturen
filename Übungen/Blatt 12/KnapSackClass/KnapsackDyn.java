package KnapSackClass;

import java.util.ArrayList;
import java.util.List;

//-----------------------------------------------------------------//
public class KnapsackDyn {

  // Warpper class to make it prettier
  public class Matrix {
    private int [][] _matrix;

    public Matrix (int m, int n) {
      _matrix = new int[m][n];
    }

    public int get (int m, int n) {
      return _matrix[m][n];
    }

    public void set (int m, int n, int val) {
      _matrix[m][n] = val;
    }

    @Override
    public String toString () {
      String res = "";
      for (int i = 0; i < _matrix.length; i++) {
        res += i + ": ";
        for (int j = 0; j < _matrix[i].length; j++) {
          if (_matrix[i][j] < 10) res += " ";
          res += " " + _matrix[i][j];
        }
        res += "\n";
      }
      return res;
    }
  }

  public class BackPackObject {
    int _size; 
    int _use; // Price etc.
    int _idx; 
  
    public BackPackObject (int __idx, int __w, int __use) {
      _size = __w;
      _use = __use;
      _idx = __idx;
    }
  }

  List<BackPackObject> _obj;
  int _cap;
  Matrix _matr;

  public KnapsackDyn (int w, List<BackPackObject> objects) {
    _obj = objects;
    _cap = w;
    if (objects != null) _matr = new Matrix(objects.size() + 1, w + 1);
  }

  public void fillMatrix () {
    for (int i = 1; i <= _obj.size(); i++) {
      for (int j = 0; j <= _cap; j++) {
        if (_obj.get(i-1)._size <= j) {
          int max = Math.max(_matr.get(i-1, j), _obj.get(i-1)._use + _matr.get(i-1, j - _obj.get(i-1)._size)); // Gets maximum possible value
          _matr.set(i, j, max);
        } else {
          _matr.set(i, j, _matr.get(i-1, j));
        }
      }
    }
  }

  public int getMaxUse () {
    if (_matr == null) fillMatrix();
    return _matr.get(_obj.size(), _cap);
  }

  public int getMaxUse (int w) {
    if (_matr == null) fillMatrix();
    return _matr.get(_cap, w);
  }
  
  //---------------------------------------------------------------//
  public static void main(String[] args) {
    KnapsackDyn obj = new KnapsackDyn(0, null);
    BackPackObject a1 = obj.new BackPackObject(1, 3, 3);
    BackPackObject a2 = obj.new BackPackObject(2, 4, 5);
    BackPackObject a3 = obj.new BackPackObject(3, 6, 8);
    BackPackObject a4 = obj.new BackPackObject(4, 7, 9);

    List<BackPackObject> list = new ArrayList<BackPackObject>();

    list.add(a1);
    list.add(a2);
    list.add(a3);
    list.add(a4);

    obj = new KnapsackDyn(15, list);
    obj.fillMatrix();
    System.out.println(obj._matr.toString());
    System.out.println("Maximum weight: " + obj.getMaxUse());
  }
}
