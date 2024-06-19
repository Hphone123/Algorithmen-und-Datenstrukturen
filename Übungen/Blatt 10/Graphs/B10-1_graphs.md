# Darstellung von Graphen

## 1

### Waht is a Graph?

- Mathematical / Data structure consisting of nodes (deu.: 'Knoten') and edges (deu.: 'Kanten') between them
- Discribes relation between different nodes with weights on the edges
- Used to model networks, connections and many other structures

### Types of Graphs

- undirected graph
- directed graph
- weighted graph
- unweighted graph
- connected ('zusammenhängend') graph
- unconected graph
- cyclical graph

## 2

B = (V, E) mit V = {1,2,3,4,5} und E = {{1, 2} ,{1, 3}, {1, 4}, {1, 5}, {2, 4}, {2, 5}, {3, 4}, {4, 5}}

## 3

Edges:

``` Math
E = {{1, 2} ,{1, 3}, {1, 4}, {1, 5}, {2, 4}, {2, 5}, {3, 4}, {4, 5}}
```

Nodes:

``` Math
V = {1,2,3,4,5}
```

Adjacense Matrix:

``` Math
 | 1 2 3 4 5
-----------
1| 0 1 1 1 1
2| 1 0 0 1 1
3| 1 0 0 1 0
4| 1 1 1 0 1
5| 1 1 0 1 0
```

Adjacnese List:

``` Math
1: {2, 3, 4, 5}
2: {1, 4, 5}
3: {1, 4}
4: {1, 2, 3, 5}
5: {1, 2, 4}
```

### Java Impementation

Edge List:

``` Java
class Edge {
   Node src, dst;
}

List<Edge> edgeList;
```

Node List:

``` Java
class Node<T> {
   T value;
   int num;
}

List<Node> nodeList;
```

Adj. Matrix:

``` Java
class AdjacenseMatrix {
   int [][] matrix;
}
```

Adj. List:

``` Java
class AdjacenseList {
   List<Node> [] list;
}
```

## 4

``` Java
AdjacenseMatrix matrix; // This Matrix is already filled
AdjacenseList list = new AdjacenseList(matrix.length);
for (int i = 0; i < list.length; i++) {
   for (int j = 0; j < matrix[i].length; j++) {
      list[i].add()
   }
}
```

``` Java
AdjacenseList list; // This List is already filled
AdjacenseMatrix matrix = new AdjacenseMatrix(list.length);
for (int i = 0; i < list.length; i++) {
   for (for node in list) {
      matrix [i][node.num] = 1;
   }
}
```

Both algorithms are O(n^2)
