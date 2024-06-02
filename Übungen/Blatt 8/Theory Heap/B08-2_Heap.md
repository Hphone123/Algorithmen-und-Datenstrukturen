# Heap Theory

## Task 1

- A Node is always in a set relation to its children -> MinHeap: All Nodes are smaller than or equal to their children
- Implements a Full tree -> All Rows (except in some cases the lowest one) are filled
- Can easily be displayed as an array, making them efficient
- Are good for finding the smallest / biggest value in a List, but very ineficient for searching

### Example

MinHeap With: 4 -> 8 -> 7 -> 2 -> 5

1. Insert 4

   ```Heap
       4
   ```

2. Insert 8 -> Left Child of 4

   ```Heap
       4
      /
     8
   ```

3. Insert 7 -> Right Child of 4

   ```Heap
       4
      / \
     8   7
   ```

4. Insert 2 -> Left Child of 8 and restore HeapProperty

   ```Heap
       4          2
      / \        / \
     8   7  =>  4   7
    /          /
   2          8
   ```

5. Insert 2 -> Right Child of 8

   ```Heap
       2   
      / \  
     4   7 
    / \     
   8   5   
   ```

## MinHeap

### Biggest Element

- The Biggest Element is in At the Very end of the list (Bottom Right)

### MinHeap Property

- Yes, as long as HeapProperty (every Node is smalles or Equal than ther Children) is given
- -> Sorted List Satisfies that!

## Swapping and Complexity


