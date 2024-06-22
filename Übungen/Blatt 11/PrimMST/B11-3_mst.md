# Prim-MST-Algorithm

## What

- Prim MST builds a new graph with less edges -> removes edges from original one
- Output graph is a tree (MinimumSpanningTree), with start node as the root
- This tree then shows the closest distance to all reachable nodes

## How

1. Start at current Node and put it into the new graph
2. Find all directly accessible nodes (All nodes with djacent edges to visited nodes)
3. Find the one with the shortest edge distance (=lowest edge weight)
4. Put the closest node and the connecting edge into the new graph, keeping the weights
5. If all nodes were visited, or there are no connecting edges between the found and not found nodes, stop
6. Start over from step 2, but use all 'found'/visited nodes to find the closet one

## Exaple

1. Node 0 -> Find 1,2,3 -> Closest 1 (Edge 0-1):

   ``` MST
     0
   2/
   1
   ```

2. Nodes 0,1 -> Find 2,3,5 -> Closest 3 (Edge 0-3):

   ``` MST
     0
   2/ \3
   1   3
   ```

3. Nodes 0,1,3 -> Find 2,5 -> Closest 2 (Edge 2-3):

   ``` MST
     0
   2/ \3
   1   3
       |1
       2
   ```

4. Nodes 0,1,2,3 -> Find 4,5 -> Closest 5 (Edge 1-5):

   ``` MST
      0
    2/ \3
    1   3
   4|   |1
    5   2
   ```

5. Nodes 0,1,2,3,5 -> Find 4 -> Closest 4 (Edge 2-4):

   ``` MST
      0
    2/ \3
    1   3
   4|   |1
    5   2
        |7
        4
   ```
