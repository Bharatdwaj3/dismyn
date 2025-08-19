import java.util.*;

public class KthSmallestElement {
    static int kth_Smallest_Element(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 1;
        System.out.println("Kth Smallest: " + kth_Smallest_Element(arr, k));
    }
}