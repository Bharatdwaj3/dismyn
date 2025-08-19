import java.util.*;

public class DP_Rectangles {
    public static int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int totalSquares = 0;

        // Initialize first row and column
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
            totalSquares += dp[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = matrix[0][j];
            totalSquares += dp[0][j];
        }

        // Fill the dp matrix
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                            Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                    totalSquares += dp[i][j];
                }
            }
        }

        return totalSquares;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of rows
        int m = sc.nextInt(); // number of columns

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int result = countSquares(matrix);
        System.out.println(result); // ✅ No extra text
    }
}
