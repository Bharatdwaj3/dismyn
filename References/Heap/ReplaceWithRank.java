import java.util.*;

public class ReplaceWithRank {
    static int[] replaceWithRank(int[] arr) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < arr.length; i++) minHeap.offer(new int[]{arr[i], i});
        int[] result = new int[arr.length];
        int rank = 1, prev = Integer.MIN_VALUE;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (curr[0] != prev) rank++;
            result[curr[1]] = rank - 1;
            prev = curr[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 30};
        System.out.println("Ranks: " + Arrays.toString(replaceWithRank(arr)));
    }
}