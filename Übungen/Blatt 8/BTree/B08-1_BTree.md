# Aufgabe 8.1

## Minimal Keys

Tree of Order `t`, Height `h`:

``` Math
1 + (t-1) * sum(t^n) for n = 1 to h-1
```

## Maximal Keys

Tree of Order `t`, Height `h`:

```Math
sum((2t-1) * t^n) for n = 0 to h-1

=

(2t-1) * MinimalKeys
```

## Example

`t=2`, `h=3`

Minimum:

```Math
1 + (2-1) * sum(2^n) = 1 + 1 + (2 + 4) = 7
```

Maximum:

```Math
sum((2*2-1) * 2^n) = (3*1) + (3 * 2) + (3 * 4) = 3 * 7 = 21
```

