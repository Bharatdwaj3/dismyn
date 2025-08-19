import java.util.*;

public class MinCoinsChange {
    public static int minCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0 && amount > 0; i--) {
            count += amount / coins[i];
            amount %= coins[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        System.out.println(minCoins(coins, 27)); // Expected: 4 (10+10+5+2)
    }
}