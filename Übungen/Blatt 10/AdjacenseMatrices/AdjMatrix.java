package AdjacenseMatrices;

import java.util.ArrayList;
import java.util.List;

/*
 *  0 0 0
 *  0 1 0
 *  1 0 0 <- Ausgehnde Kanten für Knoten 3 (Zeile 3) 
 *      /\
 *       |-- Eingehnde Kanten für Knoten 3 (Spalte 3)
 */     

//---------------------------------------------------------------//
public class AdjMatrix{
  //-------------------------------------------------------------//
  public  static int inDegree(int k, int[][] m) {
    //! We assume m is a quadratic Matrix, should be checked
    int sum = 0;
    for (int i = 0; i < m.length; i++) {
      if (m[i][k] > 1) ++sum;
    }
    return sum;
  }

  //-------------------------------------------------------------//
  public  static int outDegree(int k, int[][] m) {
    //! We assume m is a quadratic Matrix, should be checked
    int sum = 0;
    for (int i = 0; i < m[k].length; i++) {
      if (m[k][i] > 1) ++sum;
    }
    return sum;
  }

  //-------------------------------------------------------------//
  public  static List<Integer> adjacent(int k, int[][] m){
    List<Integer> nodes = new ArrayList<Integer>();
    //! We assume m is a quadratic Matrix, should be checked
    for (int i = 0; i < m.length; i++) {
      if (m[k][i] > 1) nodes.add(m[k][i]);
      if (m[i][k] > 1) nodes.add(m[i][k]);
    }
    return nodes;
  }

  //-------------------------------------------------------------//
  public static boolean hasTriangle(int[][] m) {
    //TODO: implement
  }

  //-------------------------------------------------------------//
  public static void main(String args[]) {
    //TODO: test your code
  }
}
