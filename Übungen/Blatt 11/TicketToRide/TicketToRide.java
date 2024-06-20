package TicketToRide;

import java.util.List;

public class TicketToRide {
  //@formatter:off
  private Matrix adjacencyMatrix = null;
  Matrix getAdjacencyMatrix() { return adjacencyMatrix; }
  //@formatter:on

  // --------------------------------------------------------------- //
  // ToDo: add more variables if you need them

  // --------------------------------------------------------------- //
  /** Constructor creates all necessary data. */
  public TicketToRide() {
    // ToDo: implement the constructor
  }

  // --------------------------------------------------------------- //
  /**
   * Convert a name of a city to its index. Return -1 if a wrong city name is
   * provided.
   */
  public int cityToIndex(String city) {
    // ToDo: implement this method
  }

  // --------------------------------------------------------------- //
  /**
   * Convert an index of a city into a name. Return an empty String if the index
   * is wrong.
   */
  public String indexToCity(int index) {
    // ToDo: implement this method
  }

  // --------------------------------------------------------------- //
  /**
   * Converts the data of the boardgame into an adjacency matrix. The entries in
   * the matrix correspond to the length of the connection.
   */
  final public void createAdjacencyMatrix() {
    // ToDo: implement this method
  }

  // --------------------------------------------------------------- //
  /**
   * Computes the number of cycles with the given length for the specified city.
   */
  public int getCyclesCount(String city, int length) {
    // ToDo: implement this method
  }

  // --------------------------------------------------------------- //
  /**
   * Computes the total number of all cycles with the given length.
   */
  public int getTotalCyclesCount(int length) {
    // ToDo: implement this method
  }

  // --------------------------------------------------------------- //
  /**
   * Return a list with the cities, that are connected to the input city.
   */
  public List<String> getConnections(String city) {
    // ToDo: implement this method
  }

  // --------------------------------------------------------------- //
  /**
   * Return the length of the connection between cityA and cityB. Returns 0 if
   * there is no connection.
   */
  public int getConnectionLength(String cityA, String cityB) {
    // ToDo: implement this method
  }

  // --------------------------------------------------------------- //
  /**
   * Returns a list with city names, that represent a path between the input
   * cityA and cityB. The path is determined by depth-first-search'.
   */
  public List<String> getPath(String cityA, String cityB) {
    // ToDo: implement this method
  }
}
