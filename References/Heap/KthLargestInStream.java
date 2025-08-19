import java.util.*;

public class KthLargestInStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargestInStream kthLargest = new KthLargestInStream(k, nums);
        System.out.println("Kth Largest: " + kthLargest.add(3));
        System.out.println("Kth Largest: " + kthLargest.add(5));
    }
}