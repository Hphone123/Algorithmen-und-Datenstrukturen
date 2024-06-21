
# Dijkstra Algorithmus

## How does it work

- Initialize All Node
  - Start-node (Here 0) to 0 distance
  - All other to ∞
  - Mark all as not visited
  - set current node to start node
- Main Loop
  - Look at all NOT VISITED nodes from the current node
  - compute new distance (add current distance and edge distance)
  - if new distance is shorter then last computed distance, update it
  - mark current node as visited
  - set current node to node with shortest distance from current node
  - repeat
  - break, if all nodes were visited or if shortest known distance to all unvisited is ∞ -> they are unreachable

## Example

| | | |