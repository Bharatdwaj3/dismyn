package Question_Bank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountPairsInArray {

    private static int calculateFrequency(List<Integer> arr, int start, int end, int value) {
        int freq = 0;
        for (int k = start - 1; k < end; k++) { // Adjust to 0-based indexing
            if (arr.get(k) == value) {
                freq++;
            }
        }
        return freq;
    }

    private static int calculateDistinct(List<Integer> arr, int start, int end) {
        Set<Integer> seen = new HashSet<>();
        for (int k = start - 1; k < end; k++) { // Adjust to 0-based indexing
            seen.add(arr.get(k));
        }
        return seen.size();
    }

    public static int countPairs(int N, List<Integer> A) {
        long MOD = 1_000_000_007L;
        long count = 0;

        for (int i = 1; i <= N; i++) { // i from 1 to N (1-based indexing)
            for (int j = i + 1; j <= N; j++) { // j from i+1 to N (1-based indexing)
                // Calculate left side
                int freqLiAi = calculateFrequency(A, 1, i, A.get(i - 1)); // A.get(i-1) for 0-based
                int distinctLi = calculateDistinct(A, 1, i);

                // Calculate right side
                int freqJnAj = calculateFrequency(A, j, N, A.get(j - 1)); // A.get(j-1) for 0-based
                int distinctJn = calculateDistinct(A, j, N);

                // Check condition
                if ((freqLiAi + freqJnAj) <= (distinctLi / 2) + (distinctJn / 2)) {
                    count = (count + 1) % MOD;
                }
            }
        }
        return (int) count;
    }

    public static void main(String[] args) {
        // Sample 1
        // int N1 = 5;
        // List<Integer> A1 = List.of(2, 2, 3, 1, 5);
        // System.out.println(countPairs(N1, A1)); // Expected: 2

        // Sample 2
        // int N2 = 5;
        // List<Integer> A2 = List.of(5, 5, 5, 5, 5);
        // System.out.println(countPairs(N2, A2)); // Expected: 0

        // Sample 3
        // int N3 = 5;
        // List<Integer> A3 = List.of(1, 2, 3, 4, 5);
        // System.out.println(countPairs(N3, A3)); // Expected: 5
    }
}