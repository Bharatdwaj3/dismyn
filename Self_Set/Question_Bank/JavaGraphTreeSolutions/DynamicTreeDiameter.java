import java.util.*;

public class DynamicTreeDiameter {
    static int diameter = 0;
    static int farthestNode;

    public static void dfs(int node, int parent, int depth, List<List<Integer>> tree) {
        if (depth > diameter) {
            diameter = depth;
            farthestNode = node;
        }
        for (int nei : tree.get(node)) {
            if (nei != parent)
                dfs(nei, node, depth + 1, tree);
        }
    }

    public static int findDiameter(List<List<Integer>> tree) {
        diameter = 0;
        dfs(0, -1, 0, tree);
        diameter = 0;
        dfs(farthestNode, -1, 0, tree);
        return diameter;
    }

    public static void main(String[] args) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < 6; i++) tree.add(new ArrayList<>());
        tree.get(0).add(1); tree.get(1).add(0);
        tree.get(1).add(2); tree.get(2).add(1);
        tree.get(1).add(3); tree.get(3).add(1);
        tree.get(3).add(4); tree.get(4).add(3);
        tree.get(4).add(5); tree.get(5).add(4);
        System.out.println(findDiameter(tree));
    }
}