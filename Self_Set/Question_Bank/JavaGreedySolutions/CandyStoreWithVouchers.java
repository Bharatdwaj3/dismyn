import java.util.*;

public class CandyStoreWithVouchers {
    public static int maxCandies(int[] prices, int vouchers) {
        Arrays.sort(prices);
        int total = 0;
        for (int i = 0; i < prices.length && vouchers >= prices[i]; i++) {
            vouchers -= prices[i];
            total++;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxCandies(prices, 10)); // Expected: 4
    }
}