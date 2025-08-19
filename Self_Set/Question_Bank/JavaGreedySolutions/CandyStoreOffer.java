import java.util.*;

public class CandyStoreOffer {
    public static int minCost(int[] prices, int k) {
        Arrays.sort(prices);
        int cost = 0;
        for (int i = 0; i < prices.length - i / (k + 1); i++) {
            cost += prices[i];
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4};
        System.out.println(minCost(prices, 1)); // Buy 2, get 1 free
    }
}