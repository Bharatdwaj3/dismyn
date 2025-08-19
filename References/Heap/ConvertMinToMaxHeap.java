import java.util.*;

public class ConvertMinToMaxHeap {
    static void convertMinToMaxHeap(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) minHeap.offer(num);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        while (!minHeap.isEmpty()) maxHeap.offer(minHeap.poll());
        for (int i = 0; i < arr.length; i++) arr[i] = maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        convertMinToMaxHeap(arr);
        System.out.println("Max-Heap: " + Arrays.toString(arr));
    }
}