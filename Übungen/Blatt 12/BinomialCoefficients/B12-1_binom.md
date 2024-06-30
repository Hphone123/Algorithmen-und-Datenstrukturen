# Binomial Coefficient

## Pseudo-Code-Algorithm

``` Pseudo-Code
function binomialCoeff(n, k):
    table = array[0..n][0..k] of int

    for i from 0 to n:
        for j from 0 to min(i, k):
            if j == 0 or j == i:
                table[i][j] = 1
            else:
                table[i][j] = table[i-1][j-1] + table[i-1][j]

    return table[n][k]
```

## N=7, K=5

| 1 	|   	|    	|    	|    	|    	|   	|   	|
|---	|---	|----	|----	|----	|----	|---	|---	|
| 1 	| 1 	|    	|    	|    	|    	|   	|   	|
| 1 	| 2 	| 1  	|    	|    	|    	|   	|   	|
| 1 	| 3 	| 3  	| 1  	|    	|    	|   	|   	|
| 1 	| 4 	| 6  	| 4  	| 1  	|    	|   	|   	|
| 1 	| 5 	| 10 	| 10 	| 5  	| 1  	|   	|   	|
| 1 	| 6 	| 15 	| 20 	| 15 	| 6  	| 1 	|   	|
| 1 	| 7 	| 21 	| 35 	| 35 	| 21 	| 7 	| 1 	|

## O(???)

This algorithm is O(n*k) -> O(n²) worst case, O(n) best case, O(n log n) overall.

## Optimization

Pascals triangle is symetrical along the y-axis (down), and so this would cut the runtime in half.
