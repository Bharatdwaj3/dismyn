package Question_Bank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

public class ReduceEnemyArmy {

    public static int minMovesToReduceArmy(int N) {
        if (N == 1) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>(); // int[]: {current_soldiers, moves}
        queue.offer(new int[] { N, 0 });
        Set<Integer> visited = new HashSet<>();
        visited.add(N);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentSoldiers = current[0];
            int moves = current[1];

            // Move 1: Reduce by 1 soldier
            int nextSoldiers1 = currentSoldiers - 1;
            if (nextSoldiers1 >= 1 && !visited.contains(nextSoldiers1)) {
                if (nextSoldiers1 == 1) {
                    return moves + 1;
                }
                visited.add(nextSoldiers1);
                queue.offer(new int[] { nextSoldiers1, moves + 1 });
            }

            // Move 2: Reduce by half
            int nextSoldiers2 = currentSoldiers / 2;
            if (nextSoldiers2 >= 1 && !visited.contains(nextSoldiers2)) {
                if (nextSoldiers2 == 1) {
                    return moves + 1;
                }
                visited.add(nextSoldiers2);
                queue.offer(new int[] { nextSoldiers2, moves + 1 });
            }

            // Move 3: Reduce by two-thirds
            int nextSoldiers3 = currentSoldiers - (2 * currentSoldiers / 3);
            if (nextSoldiers3 >= 1 && !visited.contains(nextSoldiers3)) {
                if (nextSoldiers3 == 1) {
                    return moves + 1;
                }
                visited.add(nextSoldiers3);
                queue.offer(new int[] { nextSoldiers3, moves + 1 });
            }
        }
        return -1; // Should not be reached if N >= 1, as 1 is always reachable
    }

    public static void main(String[] args) {
        // Sample 1
        // int N1 = 5;
        // System.out.println(minMovesToReduceArmy(N1)); // Expected: 3

        // Sample 2
        // int N2 = 1;
        // System.out.println(minMovesToReduceArmy(N2)); // Expected: 0

        // Sample 3
        // int N3 = 6;
        // System.out.println(minMovesToReduceArmy(N3)); // Expected: 2
    }
}