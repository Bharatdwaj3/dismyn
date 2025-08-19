import java.util.*;

public class DPProblems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample calls
        System.out.println("Fibonacci of 10: " + fibonacci(10));
        System.out.println("Tribonacci of 10: " + tribonacci(10));
        System.out.println("Lucas of 10: " + lucas(10));
        System.out.println("Climbing Stairs (n=10): " + climbingStairs(10));
        System.out.println("Climbing Stairs with 3 Moves (n=10): " + climbStairs3Moves(10));
        System.out.println("Weighted Climbing Stairs: " + weightedClimb(new int[] { 1, 2, 3, 1 }));
        System.out.println("Max Segments: " + maxSegments(7, 5, 2, 2));
        System.out.println("Nth Catalan Number (n=5): " + catalan(5));
        System.out.println("Count Unique BSTs (n=5): " + numTrees(5));
        System.out.println("Valid Parentheses (n=3): " + countParenthesis(3));
        System.out.println("Ways to Triangulate (n=6): " + triangulations(6));
        System.out.println("Min Sum in Triangle: " + minSumTriangle(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3))));
        System.out.println("Minimum Perfect Squares (n=12): " + minPerfectSquares(12));
        System.out.println("Ways to Partition (n=4, k=2): " + partitionSet(4, 2));
        System.out.println("Binomial Coefficient (n=5, k=2): " + binomialCoeff(5, 2));
        System.out.println("Nth Pascal Row (n=5): " + nthPascalRow(5));
    }

    // 1. Fibonacci
    static int fibonacci(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // 2. Tribonacci
    static int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    // 3. Lucas Numbers
    static int lucas(int n) {
        if (n == 0)
            return 2;
        if (n == 1)
            return 1;
        int a = 2, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // 4. Climbing Stairs
    static int climbingStairs(int n) {
        if (n <= 2)
            return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // 5. Climbing Stairs with 3 Moves
    static int climbStairs3Moves(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i >= 1)
                dp[i] += dp[i - 1];
            if (i >= 2)
                dp[i] += dp[i - 2];
            if (i >= 3)
                dp[i] += dp[i - 3];
        }
        return dp[n];
    }

    // 6. Weighted Climbing Stairs (Min Cost)
    static int weightedClimb(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    // 7. Maximum Segments
    static int maxSegments(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i >= a && dp[i - a] != -1)
                dp[i] = Math.max(dp[i], dp[i - a] + 1);
            if (i >= b && dp[i - b] != -1)
                dp[i] = Math.max(dp[i], dp[i - b] + 1);
            if (i >= c && dp[i - c] != -1)
                dp[i] = Math.max(dp[i], dp[i - c] + 1);
        }
        return dp[n];
    }

    // 8. Nth Catalan Number
    static int catalan(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return (int) dp[n];
    }

    // 9. Count Unique BSTs
    static int numTrees(int n) {
        return catalan(n);
    }

    // 10. Count Valid Parenthesis
    static int countParenthesis(int n) {
        return catalan(n);
    }

    // 11. Triangulate a Polygon
    static int triangulations(int n) {
        return catalan(n - 2);
    }

    // 12. Min Sum in a Triangle
    static int minSumTriangle(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    // 13. Minimum Perfect Squares
    static int minPerfectSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    // 14. Ways to Partition a Set into k Subsets
    static int partitionSet(int n, int k) {
        if (k == 0 || k > n)
            return 0;
        if (k == 1 || k == n)
            return 1;
        return k * partitionSet(n - 1, k) + partitionSet(n - 1, k - 1);
    }

    // 15. Binomial Coefficient
    static int binomialCoeff(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][k];
    }

    // 16. Nth Row of Pascal's Triangle
    static List<Integer> nthPascalRow(int n) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= n; i++) {
            long val = (long) row.get(i - 1) * (n - i + 1) / i;
            row.add((int) val);
        }
        return row;
    }
}
