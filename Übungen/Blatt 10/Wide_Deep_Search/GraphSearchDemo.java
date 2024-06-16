package Wide_Deep_Search;

import aud.example.graph.*;
// import aud.util.DotViewer;
// import aud.util.SingleStepper;

//------------------------------------------------------------------//
public class GraphSearchDemo {

  //----------------------------------------------------------------//  
  public static MyGraph createGraph() {
    
    MyGraph graph = new MyGraph(false);

    graph.addNode(); //? This is so the Nodes have the right Numbers on them
    
    // Add Nodes
    MyNode node1 = graph.addNode();
    MyNode node2 = graph.addNode();
    MyNode node3 = graph.addNode();
    MyNode node4 = graph.addNode();
    MyNode node5 = graph.addNode();
    MyNode node6 = graph.addNode();
    MyNode node7 = graph.addNode();
    MyNode node8 = graph.addNode();

    // Add Edges
    graph.addEdge(node1, node6);
    graph.addEdge(node1, node2);
    graph.addEdge(node1, node8);
    graph.addEdge(node1, node3);
    graph.addEdge(node1, node7);
    graph.addEdge(node2, node8);
    graph.addEdge(node3, node8);
    graph.addEdge(node6, node4);
    graph.addEdge(node6, node5);
    graph.addEdge(node4, node5);
    graph.addEdge(node8, node5);
    graph.addEdge(node7, node5);
    
    // Display
    // DotViewer.displayWindow(graph, "Graph");

    BreadthFirstSearch bfs = new BreadthFirstSearch(graph);
    // bfs.singlestepper = new SingleStepper("BFS Stepper");
    bfs.start(node8);
    // DotViewer.displayWindow(graph, "BFS");

    DepthFirstSearch dfs = new DepthFirstSearch(graph);
    // dfs.singlestepper = new SingleStepper("DFS Stepper");
    dfs.start(node8);
    // DotViewer.displayWindow(graph, "DFS");

    return graph;
  }

  //----------------------------------------------------------------//
  public static void main(String args[]) {
    createGraph();
  }
}
