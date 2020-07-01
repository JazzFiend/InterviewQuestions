Museum Guard

****File under In Person

Given a floor plan with walls and guards (MxN grid, walls = -1, guards = 0), populate the floor plan with the minimum distance to any guard.  Guards move in cardinal directions only (not diagonally).

In Java, this function would have the following shape:  
`int[][] guardDistances(int M, int N, List<OrderedPair> guards, List<OrderedPair> walls) {}`

where an OrderedPair is defined as:
```
class OrderedPair {
  public int m, n;
  public OrderedPair(int m, int n) {
    this.m = m; this.n = n;
  }
}
```

Example:
Input:
```
M = 3
N = 3
guards = [(1, 0), (2, 2)]
walls = [(1, 1), (2, 1)]
```

Graphical Representation of Input:
```
[  ,   ,   ]
[ G,  W,   ]
[  ,  W,  G]   
```

Output:
```
[ 1,  2,  2]
[ 0, -1,  1]
[ 1, -1,  0]
```