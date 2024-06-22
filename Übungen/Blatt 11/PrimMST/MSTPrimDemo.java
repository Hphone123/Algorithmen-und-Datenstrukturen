package PrimMST;

import aud.example.graph.*;
import aud.util.DotViewer;

//------------------------------------------------------------------//
public class MSTPrimDemo {
  //----------------------------------------------------------------//

  public static MyNode fillWithExampleGraph (MyGraph __grph) {
    
    // Add Nodes
    MyNode node0 = __grph.addNode();
    MyNode node1 = __grph.addNode();
    MyNode node2 = __grph.addNode();
    MyNode node3 = __grph.addNode();
    MyNode node4 = __grph.addNode();
    MyNode node5 = __grph.addNode();

    // Add Edges
    MyEdge e01 =__grph.addEdge(node0, node1);
    MyEdge e02 =__grph.addEdge(node0, node2);
    MyEdge e03 =__grph.addEdge(node0, node3);
    MyEdge e15 =__grph.addEdge(node1, node5);
    MyEdge e23 =__grph.addEdge(node2, node3);
    MyEdge e24 =__grph.addEdge(node2, node4);
    MyEdge e25 =__grph.addEdge(node2, node5);
    MyEdge e35 =__grph.addEdge(node3, node5);
    MyEdge e45 =__grph.addEdge(node4, node5);

    // Set Edge Weights
    e01.setWeight(2);
    e02.setWeight(5);
    e03.setWeight(3);
    e15.setWeight(4);
    e23.setWeight(1);
    e24.setWeight(7);
    e25.setWeight(8);
    e35.setWeight(6);
    e45.setWeight(9);

    return node0;
  }

  public static void main(String args[]) {
    MyGraph graph = new MyGraph(false);
    MyNode start = fillWithExampleGraph(graph);
    DotViewer.displayWindow(graph, "Prim-MST");
    PrimMinimumSpanningTree pmst = new PrimMinimumSpanningTree(graph);

    pmst.start(start);

    DotViewer.displayWindow(graph, "Prim-MST");
  }
}
