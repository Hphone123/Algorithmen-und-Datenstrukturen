# Headless SList

## Task

An element from an SList (Single-Link List) is to be deleteded. \
The SList is (for some reason) missing the HEAD reference.

## Solution

Set the DATA and the NEXT references of the to be deleted Node to it's next one. The referenced Node will be the same, but it then behaves like its next Node.

## Example

``` SList
1 -> 2 -> 3 -> 4 -> 5 -> 6
```

Delete the 3: Update the Data

``` SList
1 -> 2 -> 4 -> 4 -> 5 -> 6
```

Update the reference

``` Slist
1 -> 2 -> 4    4 -> 5 -> 6
          |        /\
          |_________|
```

The garbage collector (in Languages which have one, like Java) will then ged rid of the 'lost' Node

``` SList
1 -> 2 -> 4 -> 5 -> 6
```
