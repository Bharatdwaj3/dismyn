package Question_Bank;

import java.util.ArrayList;
import java.util.List;

public class ArrayTransformationAndSum {
    public static int arrayTransformationAndSum(int n, List<Integer> A, int q, List<List<Integer>> queries) {
        long MOD = 1_000_000_007L;
        long totalSumOfType2Queries = 0;
        List<Integer> currentA = new ArrayList<>(A); // Make a mutable copy

        for (List<Integer> query : queries) {
            int queryType = query.get(0);
            int l = query.get(1);
            int r = query.get(2);

            if (queryType == 1) {
                // Type 1: (1, l, r) - Replace A[i] with (i-l+1)*A[l]
                long originalAlForThisQuery = currentA.get(l);
                for (int i = l; i <= r; i++) {
                    currentA.set(i, (int) (((long) (i - l + 1) * originalAlForThisQuery) % MOD));
                }
            } else if (queryType == 2) {
                // Type 2: (2, l, r) - Calculate the sum of elements in A from l to r
                long currentQuerySum = 0;
                for (int i = l; i <= r; i++) {
                    currentQuerySum = (currentQuerySum + currentA.get(i)) % MOD;
                }
                totalSumOfType2Queries = (totalSumOfType2Queries + currentQuerySum) % MOD;
            }
        }
        return (int) totalSumOfType2Queries;
    }

    public static void main(String[] args) {
        // Sample 1
        // int n1 = 7;
        // List<Integer> A1 = new ArrayList<>(List.of(1, 4, 5, 1, 6, 7, 8));
        // int q1 = 5;
        // List<List<Integer>> queries1 = new ArrayList<>();
        // queries1.add(List.of(1, 1, 6));
        // queries1.add(List.of(1, 1, 5));
        // queries1.add(List.of(2, 5, 5));
        // queries1.add(List.of(2, 3, 4));
        // queries1.add(List.of(2, 3, 3));
        // System.out.println(arrayTransformationAndSum(n1, A1, q1, queries1)); //
        // Expected: 60

        // Sample 2
        // int n2 = 7;
        // List<Integer> A2 = new ArrayList<>(List.of(3, 7, 4, 2, 5, 3, 7));
        // int q2 = 5;
        // List<List<Integer>> queries2 = new ArrayList<>();
        // queries2.add(List.of(1, 0, 4));
        // queries2.add(List.of(2, 0, 1));
        // queries2.add(List.of(1, 3, 6));
        // queries2.add(List.of(2, 3, 3));
        // queries2.add(List.of(2, 0, 5));
        // System.out.println(arrayTransformationAndSum(n2, A2, q2, queries2)); //
        // Expected: 111

        // Sample 3
        // int n3 = 7;
        // List<Integer> A3 = new ArrayList<>(List.of(1, 8, 6, 10, 5, 6, 9));
        // int q3 = 5;
        // List<List<Integer>> queries3 = new ArrayList<>();
        // queries3.add(List.of(2, 0, 3));
        // queries3.add(List.of(1, 2, 3));
        // queries3.add(List.of(1, 0, 6));
        // queries3.add(List.of(2, 1, 4));
        // queries3.add(List.of(2, 6, 6));
        // System.out.println(arrayTransformationAndSum(n3, A3, q3, queries3)); //
        // Expected: 46
    }
}