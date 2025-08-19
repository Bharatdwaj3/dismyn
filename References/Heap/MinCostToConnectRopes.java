import java.util.*;

public class MinCostToConnectRopes {
    static long minCostToConnectRopes(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropes) minHeap.offer(rope);
        long cost = 0;
        while (minHeap.size() > 1) {
            int first = minHeap.poll(), second = minHeap.poll();
            int merged = first + second;
            cost += merged;
            minHeap.offer(merged);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println("Min Cost: " + minCostToConnectRopes(ropes));
    }
}