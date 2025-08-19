import java.util.*;

public class SortKSortedArray {
    static int[] sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] result = new int[arr.length];
        int idx = 0;
        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) result[idx++] = minHeap.poll();
        }
        while (!minHeap.isEmpty()) result[idx++] = minHeap.poll();
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        System.out.println("Sorted K-Sorted Array: " + Arrays.toString(sortKSortedArray(arr, k)));
    }
}