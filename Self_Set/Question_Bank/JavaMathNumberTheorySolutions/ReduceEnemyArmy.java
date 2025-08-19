import java.util.*;

public class ReduceEnemyArmy {
    public static int minMoves(int n) {
        int moves = 0;
        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else n--;
            moves++;
        }
        return moves;
    }

    public static void main(String[] args) {
        System.out.println(minMoves(15)); // Expected: 6
    }
}