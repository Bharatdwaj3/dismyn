import java.util.*;

public class EulerTourSubtreeTime {
    static int[] in, out;
    static int time = 0;

    public static void dfs(int node, int parent, List<List<Integer>> tree) {
        in[node] = ++time;
        for (int child : tree.get(node)) {
            if (child != parent) dfs(child, node, tree);
        }
        out[node] = time;
    }

    public static void main(String[] args) {
        int n = 5;
        in = new int[n];
        out = new int[n];
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        tree.get(0).add(1); tree.get(1).add(0);
        tree.get(0).add(2); tree.get(2).add(0);
        tree.get(1).add(3); tree.get(3).add(1);
        tree.get(1).add(4); tree.get(4).add(1);

        dfs(0, -1, tree);
        System.out.println("In: " + Arrays.toString(in));
        System.out.println("Out: " + Arrays.toString(out));
    }
}