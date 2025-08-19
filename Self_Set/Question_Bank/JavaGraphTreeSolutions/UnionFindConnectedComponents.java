import java.util.*;

public class UnionFindConnectedComponents {
    static int[] parent;

    public static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py)
            parent[px] = py;
    }

    public static int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] e : edges) union(e[0], e[1]);

        Set<Integer> comps = new HashSet<>();
        for (int i = 0; i < n; i++) comps.add(find(i));
        return comps.size();
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        System.out.println(countComponents(5, edges));
    }
}