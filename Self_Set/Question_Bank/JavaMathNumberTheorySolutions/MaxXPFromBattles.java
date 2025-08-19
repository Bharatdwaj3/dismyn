import java.util.*;

public class MaxXPFromBattles {
    public static int maxXP(int[] soldiers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : soldiers) pq.add(x);
        int xp = 0;
        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            xp += a + b;
            pq.add(a + b);
        }
        return xp;
    }

    public static void main(String[] args) {
        int[] soldiers = {1, 2, 3};
        System.out.println(maxXP(soldiers)); // Expected: 9
    }
}