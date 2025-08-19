import java.util.*;

public class KthAncestor {
    static int LOG = 20;
    static int[][] up;

    public static void preprocess(int n, int[] parent) {
        up = new int[n][LOG];
        for (int i = 0; i < n; i++) up[i][0] = parent[i];
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (up[i][j - 1] != -1)
                    up[i][j] = up[up[i][j - 1]][j - 1];
                else
                    up[i][j] = -1;
            }
        }
    }

    public static int getKthAncestor(int node, int k) {
        for (int i = 0; i < LOG; i++) {
            if (((k >> i) & 1) != 0) {
                node = up[node][i];
                if (node == -1) break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        preprocess(7, parent);
        System.out.println(getKthAncestor(5, 2)); // Output: 0
    }
}