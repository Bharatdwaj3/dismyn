package Question_Bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSumGoodSubarray {

    public static long maxSumGoodSubarray(int N, int k, List<Integer> A) {
        long maxSoFar = 0; // Initialize to 0 for empty subarray case

        int left = 0;
        long currentSum = 0;
        int distinctCount = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < N; right++) {
            // Expand window
            int element = A.get(right);
            if (freqMap.getOrDefault(element, 0) == 0) {
                distinctCount++;
            }
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
            currentSum += element;

            // Shrink window if distinct count exceeds k
            while (distinctCount > k) {
                int leftElement = A.get(left);
                currentSum -= leftElement;
                freqMap.put(leftElement, freqMap.get(leftElement) - 1);
                if (freqMap.get(leftElement) == 0) {
                    distinctCount--;
                }
                left++;
            }

            // Update maxSoFar with the current good subarray sum
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        // Sample 1
        // int N1 = 11;
        // int k1 = 2;
        // List<Integer> A1 = List.of(1, 2, 2, 3, 2, 3, 5, 1, 2, 1, 1);
        // System.out.println(maxSumGoodSubarray(N1, k1, A1)); // Expected: 12

        // Sample 2
        // int N2 = 3;
        // int k2 = 1;
        // List<Integer> A2 = List.of(-1, -2, -3);
        // System.out.println(maxSumGoodSubarray(N2, k2, A2)); // Expected: 0

        // Sample 3
        // int N3 = 5;
        // int k3 = 5;
        // List<Integer> A3 = List.of(-1, 1, 3, 2, -1);
        // System.out.println(maxSumGoodSubarray(N3, k3, A3)); // Expected: 6
    }
}