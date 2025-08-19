import java.util.*;

public class KthLargestElement {
    static int kth_Largest_Element(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 1;
        System.out.println("Kth Largest: " + kth_Largest_Element(arr, k));
    }
}