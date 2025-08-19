import java.util.*;

public class PairCountWithConditions {
    public static int countPairs(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.put(x, freq.getOrDefault(x, 0) + 1);
        int count = 0;
        for (int val : freq.values()) {
            if (val > 1) count += val * (val - 1) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1};
        System.out.println(countPairs(arr)); // Expected: 4
    }
}