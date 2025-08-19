import java.util.*;

public class MinEdgesToReverseForConnectivity {
    public static int minReversals(int[][] edges, int n) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], 0});
            graph.get(e[1]).add(new int[]{e[0], 1});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            for (int[] nei : graph.get(u)) {
                int v = nei[0], cost = nei[1];
                if (dist[v] > d + cost) {
                    dist[v] = d + cost;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        int total = 0;
        for (int d : dist) if (d == Integer.MAX_VALUE) return -1;
        for (int d : dist) total += d;
        return total;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {2, 1}, {3, 2}};
        System.out.println(minReversals(edges, 4));
    }
}