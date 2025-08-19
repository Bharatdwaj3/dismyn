import java.util.*;

public class MergeFilesMinCost {
    public static int minMergeCost(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int f : files) pq.add(f);
        int cost = 0;
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] files = {4, 8, 6, 12};
        System.out.println(minMergeCost(files));
    }
}