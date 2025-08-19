import java.util.*;

public class MaxSumCombinations {
    static List<int[]> maxSumCombinations(int[] A, int[] B, int k) {
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        Set<String> seen = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        maxHeap.offer(new int[]{A[A.length - 1], B[B.length - 1], A.length - 1, B.length - 1});
        seen.add((A.length - 1) + "," + (B.length - 1));
        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            result.add(new int[]{curr[0], curr[1]});
            int i = curr[2], j = curr[3];
            if (i > 0 && seen.add((i - 1) + "," + j)) {
                maxHeap.offer(new int[]{A[i - 1], B[j], i - 1, j});
            }
            if (j > 0 && seen.add(i + "," + (j - 1))) {
                maxHeap.offer(new int[]{A[i], B[j - 1], i, j - 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2, 3};
        int[] B = {2, 5, 1, 6};
        int k = 4;
        List<int[]> result = maxSumCombinations(A, B, k);
        for (int[] pair : result) {
            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
        }
    }
}