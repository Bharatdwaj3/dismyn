package Question_Bank;

import java.util.ArrayList;
import java.util.List;

public class SimpleArrayAssignment {

    public static int arrayAssignmentAndSum(int n, List<Integer> A, int q, List<List<Integer>> queries) {
        long MOD = 1_000_000_007L;

        List<Integer> currentA = new ArrayList<>(A); // Make a mutable copy

        for (List<Integer> query : queries) {
            int l = query.get(0);
            int r = query.get(1);
            int x = query.get(2);
            int y = query.get(3);

            for (int i = l; i <= r; i++) {
                long assignedValue = (long) x + (long) (i - l) * y;
                currentA.set(i, (int) (assignedValue % MOD));
                // Ensure positive result if modulo makes it negative
                if (currentA.get(i) < 0) {
                    currentA.set(i, (int) (currentA.get(i) + MOD));
                }
            }
        }

        long finalSum = 0;
        for (int val : currentA) {
            finalSum = (finalSum + val) % MOD;
        }

        return (int) finalSum;
    }

    public static void main(String[] args) {
        // Sample 1
        // int n1 = 5;
        // List<Integer> A1 = new ArrayList<>(List.of(5, 5, 0, 3, 0));
        // int q1 = 5;
        // List<List<Integer>> queries1 = new ArrayList<>();
        // queries1.add(List.of(0, 2, 1, 2));
        // queries1.add(List.of(0, 1, 6, 5));
        // queries1.add(List.of(2, 3, 8, 0));
        // queries1.add(List.of(2, 4, 9, 6));
        // queries1.add(List.of(3, 4, 8, 9));
        // System.out.println(arrayAssignmentAndSum(n1, A1, q1, queries1)); // Expected:
        // 51

        // Sample 2
        // int n2 = 5;
        // List<Integer> A2 = new ArrayList<>(List.of(3, 9, 2, 5, 4));
        // int q2 = 5;
        // List<List<Integer>> queries2 = new ArrayList<>();
        // queries2.add(List.of(1, 2, 6, 3));
        // queries2.add(List.of(1, 2, 2, 8));
        // queries2.add(List.of(1, 2, 5, 5));
        // queries2.add(List.of(1, 3, 1, 8));
        // queries2.add(List.of(1, 2, 2, 9));
        // System.out.println(arrayAssignmentAndSum(n2, A2, q2, queries2)); // Expected:
        // 37

        // Sample 3
        // int n3 = 5;
        // List<Integer> A3 = new ArrayList<>(List.of(0, 1, 0, 0, 1));
        // int q3 = 5;
        // List<List<Integer>> queries3 = new ArrayList<>();
        // queries3.add(List.of(1, 2, 7, 7));
        // queries3.add(List.of(0, 1, 3, 6));
        // queries3.add(List.of(1, 1, 1, 1));
        // queries3.add(List.of(3, 4, 9, 1));
        // queries3.add(List.of(2, 3, 1, 0));
        // System.out.println(arrayAssignmentAndSum(n3, A3, q3, queries3)); // Expected:
        // 16
    }
}