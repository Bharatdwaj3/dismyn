public class MinDelToAvoidSubseq {
    public static int minDeletions(String s, String forbidden) {
        int n = s.length(), m = forbidden.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = Integer.MAX_VALUE / 2;
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                if (j < m && s.charAt(i) == forbidden.charAt(j))
                    dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j]);
                else if (j < m)
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++)
            res = Math.min(res, dp[n][j]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("ababc", "abc"));
    }
}