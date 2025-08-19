import java.util.*;

public class HandsOfStraights {
    static boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int card : hand) minHeap.offer(card);
        while (!minHeap.isEmpty()) {
            int start = minHeap.poll();
            for (int i = 1; i < W; i++) {
                if (!minHeap.remove(start + i)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int W = 3;
        System.out.println("Is Valid Hand: " + isNStraightHand(hand, W));
    }
}