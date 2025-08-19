public class LongestPalindromeByConcat {
    public static int longestPalindrome(String word1, String word2) {
        String s = word1 + word2;
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (i < word1.length() && j >= word1.length())
                        max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cacb", "cbba"));
    }
}