package AdjacenseMatrices;

import java.util.ArrayList;
import java.util.List;

/*
 *  0 0 0
 *  0 1 0
 *  1 0 0 <- Ausgehnde Kanten für Knoten 3 (Zeile 3) 
 *      ^
 *      |-- Eingehnde Kanten für Knoten 3 (Spalte 3)
 */     

//---------------------------------------------------------------//
public class AdjMatrix{
  //-------------------------------------------------------------//
  public  static int inDegree(int k, int[][] m) {
    //! We assume m is a quadratic Matrix, should be checked
    int sum = 0;
    for (int i = 0; i < m.length; i++) {
      if (m[i][k] > 0) sum++;
    }
    return sum;
  }

  //-------------------------------------------------------------//
  public  static int outDegree(int k, int[][] m) {
    //! We assume m is a quadratic Matrix, should be checked
    int sum = 0;
    for (int i = 0; i < m.length; i++) {
      if (m[k][i] > 0) sum++;
    }
    return sum;
  }

  //-------------------------------------------------------------//
  public  static List<Integer> adjacent(int k, int[][] m){
    List<Integer> nodes = new ArrayList<Integer>();
    //! We assume m is a quadratic Matrix, should be checked
    for (int i = 0; i < m.length; i++) {
      if (m[k][i] > 0) nodes.add(i);
      else if (m[i][k] > 0) nodes.add(i);
    }
    return nodes;
  }

  //-------------------------------------------------------------//
  public static boolean hasTriangle(int[][] m) {
    //! We assume m is a quadratic Matrix, should be checked
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m.length; j++) {
        if (m[i][j] > 0) {
          for (int j2 = 0; j2 < m.length; j2++) {
            if ((m[j][j2] > 0) && (m[j2][i] > 0)) return true;
          }
        }
      }
    }
    return false;
  }

  //-------------------------------------------------------------//
  public static void main(String args[]) {
    int [][] triangleMatrix = {
      {0, 1, 0},
      {0, 0, 1},
      {1, 0, 0}
    };
    int [][] noTriangleMatrix = {
      {0, 1, 0},
      {0, 0, 1},
      {0, 1, 0}
    };
    System.out.println("\nTest Matricies\n--------------");
    System.out.println("This Matrix has a triangle (should be true)  : " + hasTriangle(triangleMatrix));
    System.out.println("This Matrix has no triangle (should be false): " + hasTriangle(noTriangleMatrix));

    int [][] taskDMatrix = {
      {0, 1, 0, 0, 1},
      {0, 0, 0, 1, 0},
      {0, 1, 0, 0, 0},
      {0, 0, 1, 0, 0},
      {0, 0, 0, 1, 0}
    };

    /* Triangle in this Matrix:
     * 4 - 3 - 2
     */

    int [][] fourLongChainTest = {
      {0, 0, 0, 0, 0},
      {0, 0, 0, 0, 1},
      {0, 1, 0, 0, 0},
      {0, 0, 1, 0, 0},
      {0, 0, 0, 1, 0}
    };

    System.out.println("This Matrix has a 'square' (should be false) : " + hasTriangle(fourLongChainTest));
    System.out.println("\nGiven Matrix\n------------");
    System.out.println("OutDegree for Node 0                         : " + outDegree(0, taskDMatrix));
    System.out.println("InDegree for Node 2                          : " + inDegree(2, taskDMatrix));
    System.out.println("Nodes adjacent to  2                         : " + adjacent(2, taskDMatrix).toString());
    System.out.println("Triangle                                     : " + hasTriangle(taskDMatrix));
  }
}
