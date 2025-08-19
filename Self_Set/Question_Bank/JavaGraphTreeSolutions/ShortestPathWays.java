import java.util.*;

public class ShortestPathWays {
    static final int MOD = 1000000007;

    public static int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] r : roads) {
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }

        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            for (int[] nei : graph.get(u)) {
                int v = nei[0], w = nei[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    ways[v] = ways[u];
                    pq.add(new int[]{v, dist[v]});
                } else if (dist[v] == d + w) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }

    public static void main(String[] args) {
        int[][] roads = {{0, 1, 1}, {1, 2, 1}, {0, 2, 2}};
        System.out.println(countPaths(3, roads));
    }
}