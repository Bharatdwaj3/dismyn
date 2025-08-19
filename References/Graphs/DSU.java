

public class DSU {
    int[] parent;
    int[] rank;

    // Initialize DSU with 'n' elements (0 to n-1)
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    // Find the representative (root) of the set that element 'x' belongs to
    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }

    // Union two sets containing 'x' and 'y'
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[py] < rank[px]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    // Sample usage
    public static void main(String[] args) {
        DSU dsu = new DSU(5);

        dsu.union(0, 2);
        dsu.union(4, 2);
        dsu.union(3, 1);

        System.out.println("Find(4): " + dsu.find(4)); // Should give root of 0, 2, 4
        System.out.println("Find(3): " + dsu.find(3)); // Should give root of 1, 3
    }
}
