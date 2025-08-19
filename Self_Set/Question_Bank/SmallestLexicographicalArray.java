package Question_Bank;

import java.util.ArrayList;
import java.util.List;

public class SmallestLexicographicalArray {
    public static List<Integer> smallestLexicographicalArray(int N, List<Integer> A, int K) {
        List<Integer> bestArray = new ArrayList<>(A); // Initialize with the original array

        for (int i = 0; i < N; i++) {
            // Find the smallest element within reach (distance K) to swap with A[i]
            int minVal = A.get(i);
            int minIdx = i;

            for (int j = i + 1; j < N && j <= i + K; j++) {
                if (A.get(j) < minVal) {
                    minVal = A.get(j);
                    minIdx = j;
                }
            }

            if (minIdx != i) { // If a smaller element was found within reach
                // Perform the swap and return the new array
                List<Integer> tempArray = new ArrayList<>(A);
                int valI = tempArray.get(i);
                int valMinIdx = tempArray.get(minIdx);
                tempArray.set(i, valMinIdx);
                tempArray.set(minIdx, valI);
                return tempArray; // Found the first optimal swap, return immediately
            }
        }

        return bestArray; // No beneficial swap found
    }

    public static void main(String[] args) {
        // Sample 1
        // int N1 = 3;
        // List<Integer> A1 = List.of(2, 2, 2);
        // int K1 = 1;
        // System.out.println(smallestLexicographicalArray(N1, A1, K1)); // Expected:
        // [2, 2, 2]

        // Sample 2
        // int N2 = 5;
        // List<Integer> A2 = List.of(5, 4, 3, 2, 1);
        // int K2 = 3;
        // System.out.println(smallestLexicographicalArray(N2, A2, K2)); // Expected:
        // [2, 4, 3, 5, 1]

        // Sample 3
        // int N3 = 5;
        // List<Integer> A3 = List.of(2, 1, 1, 1, 1);
        // int K3 = 3;
        // System.out.println(smallestLexicographicalArray(N3, A3, K3)); // Expected:
        // [1, 1, 1, 2, 1]
    }
}
