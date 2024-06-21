
# Dijkstra Algorithmus

## How does it work

- Initialize All Node
  - Start-node (Here 0) to 0 distance
  - All other to ∞ (Here shown as '-')
  - Mark all as not visited
  - set current node to start node
- Main Loop
  - Look at all NOT VISITED nodes from the current node
  - compute new distance (add current distance and edge distance)
  - if new distance is shorter then last computed distance, update it
  - mark current node as visited
  - set current node to node with shortest distance (total distance, not from current node)
  - repeat
  - break, if all nodes were visited or if shortest known distance to all unvisited is ∞ -> they are unreachable

## Example

| Step 	| Node 	|   Visited   	| 0 	| 1 	| 2 	| 3 	|  4 	| 5 	|    Action   	|
|:----:	|:----:	|:-----------:	|:-:	|:-:	|:-:	|:-:	|:--:	|:-:	|:-----------:	|
|   1  	|   0  	|             	| 0 	| - 	| - 	| - 	|  - 	| - 	|   Choose 0  	|
|   2  	|   0  	|             	| 0 	| 2 	| 5 	| 3 	|  - 	| - 	| Visit 1,2,3 	|
|   3  	|   1  	|      0      	| 0 	| 2 	| 5 	| 3 	|  - 	| - 	|   Choose 1  	|
|   4  	|   1  	|      0      	| 0 	| 2 	| 5 	| 3 	|  - 	| 6 	|   Visit 5   	|
|   5  	|   3  	|     0,1     	| 0 	| 2 	| 5 	| 3 	|  - 	| 6 	|   Choose 3  	|
|   6  	|   3  	|     0,1     	| 0 	| 2 	| 4 	| 3 	|  - 	| 6 	|  Visit 2,5  	|
|   7  	|   2  	|    0,1,3    	| 0 	| 2 	| 4 	| 3 	|  - 	| 6 	|   Choose 2  	|
|   8  	|   2  	|    0,1,3    	| 0 	| 2 	| 4 	| 3 	| 12 	| 6 	|  Visit 4,5  	|
|   9  	|   5  	|   0,1,2,3   	| 0 	| 2 	| 4 	| 3 	| 12 	| 6 	|   Choose 5  	|
|  10  	|   5  	|   0,1,2,3   	| 0 	| 2 	| 4 	| 3 	| 12 	| 6 	|   Visit 4   	|
|  11  	|   4  	|  0,1,2,3,5  	| 0 	| 2 	| 4 	| 3 	| 12 	| 6 	|   Choose 4  	|
|  12  	|   4  	| 0,1,2,3,4,5 	| 0 	| 2 	| 4 	| 3 	| 12 	| 6 	|     Stop    	|

## Simple Example

``` Dijkstra-Graph
    0
  5/ \1
  / 3 \
 1-----2
  \   /
  1\ /1
    3
```

On this Graph, starting on Node 0, the aproximation for Node 1s aproximation goes:\
5 -> 4 -> 3 -> 3\
as the graph visits nodes:\
0 -> 2 -> 3 -> 1

## Simple Negative Example

``` Dijkstra-Graph
    0
  5/ \1
  / 6 \
 1-----2
  \   /
 -4\ /1
    3
```

Here the Distance to Node 3 one goes:\
∞ -> 2 -> 2 -> 1 \
as the Nodes are visited:\
0 -> 2 -> 3 -> 1 \
This is suboptimal, because the distance between 0 and 1 is already longer as between 0, 2 and 3, but the negative edge between 1 and 3 distorts this relation.
