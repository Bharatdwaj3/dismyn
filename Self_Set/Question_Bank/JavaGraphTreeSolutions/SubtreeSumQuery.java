import java.util.*;

public class SubtreeSumQuery {
    static int[] subtreeSum;

    public static void dfs(int node, int parent, List<List<Integer>> tree, int[] values) {
        subtreeSum[node] = values[node];
        for (int child : tree.get(node)) {
            if (child != parent) {
                dfs(child, node, tree, values);
                subtreeSum[node] += subtreeSum[child];
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] values = {1, 2, 3, 4, 5};
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        tree.get(0).add(1); tree.get(1).add(0);
        tree.get(1).add(2); tree.get(2).add(1);
        tree.get(1).add(3); tree.get(3).add(1);
        tree.get(3).add(4); tree.get(4).add(3);

        subtreeSum = new int[n];
        dfs(0, -1, tree, values);
        System.out.println(Arrays.toString(subtreeSum));
    }
}