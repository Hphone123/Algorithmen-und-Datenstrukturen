package TicketToRide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class TicketToRide {
  //@formatter:off
  private Matrix adjacencyMatrix = null;
  Matrix getAdjacencyMatrix() { return adjacencyMatrix; }

  private class Node {
    int id;
    String name;

    private Node (int __id, String __name) {
      id = __id;
      name = __name;
    }
  }

  private class Edge {
    int bgn, end;
    String bgnName, endName;
    int weight;

    private Edge (int __bgn, int __end, String __bgnNm, String __endNm, int __wght) {
      bgn = __bgn; end = __end;
      bgnName = __bgnNm; endName = __endNm;
      weight = __wght;
    }
  }

  private List<Node> nodes;
  private List<Edge> edges;
  //@formatter:on

  // --------------------------------------------------------------- //
  public TicketToRide () {
    nodes = new ArrayList<Node>();
    edges = new ArrayList<Edge>();

    // Read files and fill in Nodes and Edges
    BufferedReader reader;
		try {
      // Cities / Nodes
      String path = new File("cities.data").getAbsolutePath();
			reader = new BufferedReader(new FileReader(path)); reader.readLine(); String line = reader.readLine();  // The first line msut be discarded
			while (line != null) {
        String [] city = line.split(" +"); //? One or more Spaces match this expression
        for (int i = 2; i < city.length; i++) {
          city[1] += " " + city[i];
        } 
        Node cityNode = new Node(Integer.valueOf(city[0]), city[1]); //! Here should be a try-catch for safety, but were sury (for these files) that the first split value is a number!
				nodes.add(cityNode);

        line = reader.readLine();
			}
			reader.close();

      
      // Connections / Edges
      path = new File("connections.data").getAbsolutePath();
      reader = new BufferedReader(new FileReader(path)); reader.readLine(); line = reader.readLine();
			while (line != null) {
        String [] connection = line.split(", +"); //? Comma and one or more spaces match this expression
        Edge connectionEdge = new Edge(0, 0, connection[1], connection[2], Integer.valueOf(connection[0])); //! Here should be a try-catch for safety, but were sury (for these files) that the first split value is a number!
				edges.add(connectionEdge);

				line = reader.readLine();
			}

      reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    // Fill in id's
    for (Edge edge : edges) {
      for (Node node : nodes) {
        if (node.name.equals(edge.bgnName)) edge.bgn = node.id;
        if (node.name.equals(edge.endName)) edge.end = node.id;
      }
    }

    // Create empty AdjMatr.
    adjacencyMatrix = new Matrix(nodes.size());

  }

  // --------------------------------------------------------------- //
  /**
   * Convert a name of a city to its index. Return -1 if a wrong city name is
   * provided.
   */
  public int cityToIndex(String city) {
    for (Node node : nodes) {
      if (node.name.equals(city)) return node.id;
    }
    return -1;
  }

  // --------------------------------------------------------------- //
  /**
   * Convert an index of a city into a name. Return an empty String if the index
   * is wrong.
   */
  public String indexToCity(int index) {
    for (Node node : nodes) {
      if (node.id == index) return node.name;
    }
    return null;
  }

  // --------------------------------------------------------------- //
  /**
   * Converts the data of the boardgame into an adjacency matrix. The entries in
   * the matrix correspond to the length of the connection.
   */
  public final void createAdjacencyMatrix() {
    int [][] tempMtrx = new int[nodes.size()][nodes.size()];
    for (Edge edge : edges) {
      tempMtrx[edge.bgn][edge.end] = edge.weight;
      tempMtrx[edge.end][edge.bgn] = edge.weight;
    }
    adjacencyMatrix = new Matrix(tempMtrx);
  }

  // --------------------------------------------------------------- //
  /**
   * Computes the number of cycles with the given length for the specified city.
   */
  public int getCyclesCount(String city, int length) {
    int cityIdx = cityToIndex(city);

    // Set all Non-Zero elements to 1
    Matrix adjCopy = new Matrix(adjacencyMatrix);
    for (int i = 0; i < nodes.size(); i++) {
      for (int j = 0; j < nodes.size(); j++) {
        if (adjacencyMatrix.get(i, j) > 0) adjCopy.set(i, j, 1);
      }
    }
    // Multiply by itself length-times -> Number on diagonal is cycle count
    Matrix cycles = new Matrix(adjCopy);
    for (int i = 1; i < length; i++) {
      cycles = cycles.times(adjCopy);
    }
    return cycles.get(cityIdx, cityIdx);
  }

  // --------------------------------------------------------------- //
  /**
   * Computes the total number of all cycles with the given length.
   */
  public int getTotalCyclesCount(int length) {
    // Set all Non-Zero elements to 1
    Matrix adjCopy = new Matrix(adjacencyMatrix);
    for (int i = 0; i < nodes.size(); i++) {
      for (int j = 0; j < nodes.size(); j++) {
        if (adjacencyMatrix.get(i, j) > 0) adjCopy.set(i, j, 1);
      }
    }
    // Multiply by itself length-times -> Number on diagonal is cycle count
    Matrix cycles = new Matrix(adjCopy);
    for (int i = 1; i < length; i++) {
      cycles = cycles.times(adjCopy);
    }
    int res = 0;
    for (int i = 0; i < nodes.size(); i++) {
      res += cycles.get(i, i);
    }
    return res;
  }

  // --------------------------------------------------------------- //
  /**
   * Return a list with the cities, that are connected to the input city.
   */
  public List<String> getConnections(String city) {
    List<String> list = new ArrayList<String>();

    for (Edge edge : edges) {
      if (edge.bgnName.equals(city)) list.add(edge.endName);
      if (edge.endName.equals(city)) list.add(edge.bgnName);
    }
    return list;
  }

  // --------------------------------------------------------------- //
  /**
   * Return the length of the connection between cityA and cityB. Returns 0 if
   * there is no connection.
   */
  public int getConnectionLength(String cityA, String cityB) {
    for (Edge edge : edges) {
      if (edge.bgnName.equals(cityB) &&
          edge.endName.equals(cityA)
          ||
          edge.bgnName.equals(cityA) &&
          edge.endName.equals(cityB)) return edge.weight;
    }
    return 0;
  }

  /*********************************
   * Blatt 12 Solution Below
   *********************************/

  /**
   * Returns a list with city names, that represent a path between the input
   * cityA and cityB. The path is determined by depth-first-search'.
   */
  public List<String> getPath(String cityA, String cityB) {
    String cityC = cityA; // CityCurrent
    List<String> res = new ArrayList<String>(); res.add(cityC);
    List<String> vis = new ArrayList<String>(); vis.add(cityC);
    while (cityC != cityB) {
      List<String> con = getConnections(cityC);
      if (con.contains(cityB)) cityC = cityB;
      else {
        int sdist = 65000;
        String cityS = null; //Shortest City
        for (String string : con) {
          if ((getConnectionLength(cityC, string) < sdist) || // Distance is Shorter
              (getConnectionLength(cityC, string) == sdist && // Distance is Equal AND
               cityToIndex(string) < cityToIndex(cityS))) {   // Index is smaller
            if (!vis.contains(string)) {                      // City is not visited yet
              cityS = string; sdist = getConnectionLength(cityC, string);
            }
          }
        }
        if (cityS == null) {res.remove(cityC); cityC = res.get(res.size() - 1);} // Backtrack one City if no valid connection is available
        else cityC = cityS;
      }
      if (!vis.contains(cityC)) {res.add(cityC); vis.add(cityC);} // Dont add City Twice when Backtracking
    }
    return res;
  }

  public static void main (String [] args) {
    TicketToRide ttr = new TicketToRide();

    System.out.println("DFS-Path from Atlanta to Boston: " + ttr.getPath("Atlanta", "Boston").toString());
    System.out.println("DFS-Path from El Paso to Vancouver: " + ttr.getPath("El Paso", "Vancouver").toString());
  }
}
