import java.util.*;

public class MuseumGuards {

  static class OrderedPair {
    public int m, n;
    public OrderedPair(int m, int n) {
      this.m = m; this.n = n;
    }
  }

  static int[][] guardDistances(int M, int N, List<OrderedPair> guards, List<OrderedPair> walls) {

    int[][] floorPlan = new int[M][N];
    for(int i = 0; i < M; i++) {
      for(int j = 0; j < N; j++) {
        floorPlan[i][j] = Integer.MAX_VALUE;
      }
    }

    for(OrderedPair guard : guards) {
      floorPlan[guard.m][guard.n] = 0;
    }

    for(OrderedPair wall : walls) {
      floorPlan[wall.m][wall.n] = -1;
    }

    for(OrderedPair guard : guards) {
      Queue<OrderedPair> q = new LinkedList<>();
      q.add(guard);
      int count = 0;
      while(!q.isEmpty()) {
        List<OrderedPair> nextRound = new ArrayList<>();
        OrderedPair current = q.remove();
        floorPlan[current.m][current.n] = count;

        if(current.m + 1 < M &&
          floorPlan[current.m + 1][current.n] > count) {
          nextRound.add(new OrderedPair(current.m + 1, current.n));
        }
        if(current.m - 1 >= 0 &&
          floorPlan[current.m - 1][current.n] > count) {
          nextRound.add(new OrderedPair(current.m - 1, current.n));
        }
        if(current.n + 1 < N &&
          floorPlan[current.m][current.n + 1] > count) {
          nextRound.add(new OrderedPair(current.m, current.n + 1));
        }
        if(current.n - 1 >= 0 &&
          floorPlan[current.m][current.n - 1] > count) {
          nextRound.add(new OrderedPair(current.m, current.n - 1));
        }
        
        if(q.isEmpty()) {
          q.addAll(nextRound);
          nextRound.clear();
          count++;
        }
      }
    }

    return floorPlan;
  }

  public static void main(String[] args) {
    List<OrderedPair> guards = new ArrayList<>();
    guards.add(new OrderedPair(1, 0));
    guards.add(new OrderedPair(2, 2));

    List<OrderedPair> walls = new ArrayList<>();
    walls.add(new OrderedPair(1, 1));
    walls.add(new OrderedPair(2, 1));

    int[][] floorPlan = guardDistances(3, 3, guards, walls);
    System.out.println(Arrays.deepToString(floorPlan));
  }
}