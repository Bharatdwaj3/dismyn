import java.util.*;

public class DPProblems {

    // Climbing Stairs (DP-3)
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Frog Jump (DP-3)
    public int frogJump(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int jumpOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int jumpTwo = i > 1 ? dp[i - 2] + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;
            dp[i] = Math.min(jumpOne, jumpTwo);
        }
        return dp[n - 1];
    }

    // Frog Jump with K Distances (DP-4)
    public int frogJumpK(int n, int[] heights, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k && i - j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(heights[i] - heights[i - j]));
            }
        }
        return dp[n - 1];
    }

    // Maximum Sum of Non-Adjacent Elements (DP-5)
    public int robNonAdjacent(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (n == 1) return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    // House Robber (DP-6)
    public int rob(int[] nums) {
        return robNonAdjacent(nums);
    }

    // Ninja's Training (DP-7)
    public int ninjaTraining(int n, int[][] points) {
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        dp[day][last] = Math.max(dp[day][last], points[day][task] + dp[day - 1][task]);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    // Grid Unique Paths (DP-8)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // Grid Unique Paths 2 (DP-9)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                if (i > 0) dp[i][j] += dp[i - 1][j];
                if (j > 0) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // Minimum Path Sum in Grid (DP-10)
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int up = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;
                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }
        return dp[m - 1][n - 1];
    }

    // Minimum Path Sum in Triangular Grid (DP-11)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    // Minimum/Maximum Falling Path Sum (DP-12)
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) dp[0][j] = matrix[0][j];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = dp[i - 1][j];
                if (j > 0) min = Math.min(min, dp[i - 1][j - 1]);
                if (j < n - 1) min = Math.min(min, dp[i - 1][j + 1]);
                dp[i][j] = matrix[i][j] + min;
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) result = Math.min(result, dp[n - 1][j]);
        return result;
    }

    // 3D DP: Ninja and His Friends (DP-13)
    public int maxChocolates(int n, int m, int[][] grid) {
        int[][][] dp = new int[n][m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) dp[n - 1][j1][j2] = grid[n - 1][j1];
                else dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int nj1 = j1 + dj1, nj2 = j2 + dj2;
                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                int value = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                max = Math.max(max, value + dp[i + 1][nj1][nj2]);
                            }
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }

    // Subset Sum Equal to Target (DP-14)
    public boolean subsetSum(int[] nums, int target) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    // Partition Equal Subset Sum (DP-15)
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        return subsetSum(nums, sum / 2);
    }

    // Partition Set Into 2 Subsets With Min Absolute Sum Diff (DP-16)
    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (int j = 0; j <= sum / 2; j++) {
            if (dp[n][j]) minDiff = Math.min(minDiff, Math.abs(sum - 2 * j));
        }
        return minDiff;
    }

    // Count Subsets with Sum K (DP-17)
    public int countSubsets(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }

    // Count Partitions with Given Difference (DP-18)
    public int countPartitions(int[] nums, int d) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum - d < 0 || (sum - d) % 2 != 0) return 0;
        return countSubsets(nums, (sum - d) / 2);
    }

    // Assign Cookies
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) i++;
            j++;
        }
        return i;
    }

    // Minimum Coins (DP-20)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    // Target Sum (DP-21)
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum - target < 0 || (sum - target) % 2 != 0) return 0;
        return countSubsets(nums, (sum - target) / 2);
    }

    // Coin Change 2 (DP-22)
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    // Unbounded Knapsack (DP-23)
    public int unboundedKnapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[] dp = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = wt[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }
        return dp[W];
    }

    // Rod Cutting Problem (DP-24)
    public int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], price[j - 1] + dp[i - j]);
            }
        }
        return dp[n];
    }

    // Longest Common Subsequence (DP-25)
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    // Print Longest Common Subsequence (DP-26)
    public String printLCS(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                sb.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return sb.reverse().toString();
    }

    // Longest Common Substring (DP-27)
    public int longestCommonSubstring(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    // Longest Palindromic Subsequence (DP-28)
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, t);
    }

    // Minimum Insertions to Make String Palindrome (DP-29)
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }

    // Minimum Insertions/Deletions to Convert String (DP-30)
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);
        return word1.length() + word2.length() - 2 * lcs;
    }

    // Shortest Common Supersequence (DP-31)
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) sb.append(str1.charAt(--i));
        while (j > 0) sb.append(str2.charAt(--j));
        return sb.reverse().toString();
    }

    // Distinct Subsequences (DP-32)
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    // Edit Distance (DP-33)
    public int minDistanceEdit(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    // Wildcard Matching (DP-34)
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 1];
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    // Best Time to Buy and Sell Stock (DP-35)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
 UberChallenge
        return maxProfit;
    }

    // Buy and Sell Stock II (DP-36)
    public int maxProfitII(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    // Buy and Sell Stocks III (DP-37)
    public int maxProfitIII(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] first = new int[n];
        int[] second = new int[n];
        
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            first[i] = Math.max(first[i - 1], prices[i] - minPrice);
        }
        
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            second[i] = Math.max(second[i + 1], maxPrice - prices[i]);
        }
        
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, first[i] + (i + 1 < n ? second[i + 1] : 0));
        }
        return maxProfit;
    }

    // Buy and Sell Stocks IV (DP-38)
    public int maxProfitIV(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) return maxProfitII(prices);
        
        int[][][] dp = new int[n + 1][k + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = dp[i][j][1] = Integer.MIN_VALUE / 2;
            }
        }
        dp[0][0][0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = dp[i - 1][j][0]; // No buy
                if (j > 0 && dp[i - 1][j - 1][1] != Integer.MIN_VALUE / 2) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j - 1][1] - prices[i - 1]);
                }
                dp[i][j][1] = dp[i - 1][j][1]; // No sell
                if (dp[i - 1][j][0] != Integer.MIN_VALUE / 2) {
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][0] + prices[i - 1]);
                }
            }
        }
        return Math.max(0, dp[n][k][1]);
    }

    // Buy and Sell Stocks With Cooldown (DP-39)
    public int maxProfitCooldown(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] buy = new int[n], sell = new int[n], cooldown = new int[n];
        buy[0] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }
        return Math.max(sell[n - 1], cooldown[n - 1]);
    }

    // Buy and Sell Stocks With Transaction Fee (DP-40)
    public int maxProfitFee(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] buy = new int[n], sell = new int[n];
        buy[0] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[n - 1];
    }

    // Longest Increasing Subsequence (DP-41)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Printing Longest Increasing Subsequence (DP-42)
    public int[] printLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxLen = 1, maxIndex = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        
        List<Integer> lis = new ArrayList<>();
        while (maxIndex != -1) {
            lis.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        
        int[] result = new int[lis.size()];
        for (int i = 0; i < lis.size(); i++) {
            result[i] = lis.get(lis.size() - 1 - i);
        }
        return result;
    }

    // Largest Divisible Subset (DP-44)
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxLen = 1, maxIndex = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        return result;
    }

    // Longest String Chain (DP-45)
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int max = 1;
        
        for (String word : words) {
            dp.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prev)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(prev) + 1));
                }
            }
            max = Math.max(max, dp.get(word));
        }
        return max;
    }

    // Longest Bitonic Subsequence (DP-46)
    public int longestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lis[i] + lds[i] - 1);
        }
        return max;
    }

    // Matrix Chain Multiplication (DP-48)
    public int matrixChainOrder(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }

    // Matrix Chain Multiplication Bottom-Up (DP-49)
    public int matrixChainOrderBottomUp(int[] p) {
        return matrixChainOrder(p);
    }

    // Minimum Cost to Cut the Stick (DP-50)
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        newCuts[m + 1] = n;
        for (int i = 0; i < m; i++) newCuts[i + 1] = cuts[i];
        
        int[][] dp = new int[m + 2][m + 2];
        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i <= m + 1 - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + newCuts[j] - newCuts[i]);
                }
            }
        }
        return dp[0][m + 1];
    }

    // Burst Balloons (DP-51)
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) newNums[i + 1] = nums[i];
        
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], 
                        dp[i][k - 1] + dp[k + 1][j] + newNums[i - 1] * newNums[k] * newNums[j + 1]);
                }
            }
        }
        return dp[1][n];
    }

    // Evaluate Boolean Expression to True (DP-52)
    public int countEval(String s, int result) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        
        for (int i = 0; i < n; i += 2) {
            dp[i][i][s.charAt(i) - '0'] = 1;
        }
        
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i <= n - len; i += 2) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k += 2) {
                    char op = s.charAt(k);
                    for (int r = 0; r <= 1; r++) {
                        if (op == '&') {
                            dp[i][j][r] += r == 1 ? dp[i][k - 1][1] * dp[k + 1][j][1] : 
                                dp[i][k - 1][0] * dp[k + 1][j][0] + dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0];
                        } else if (op == '|') {
                            dp[i][j][r] += r == 1 ? dp[i][k - 1][1] * dp[k + 1][j][1] + dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0] : 
                                dp[i][k - 1][0] * dp[k + 1][j][0];
                        } else if (op == '^') {
                            dp[i][j][r] += r == 1 ? dp[i][k - 1][0] * dp[k + 1][j][1] + dp[i][k - 1][1] * dp[k + 1][j][0] : 
                                dp[i][k - 1][0] * dp[k + 1][j][0] + dp[i][k - 1][1] * dp[k + 1][j][1];
                        }
                    }
                }
            }
        }
        return dp[0][n - 1][result];
    }

    // Palindrome Partitioning II (DP-53)
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) isPalindrome[i][i] = true;
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (len == 2 || isPalindrome[i + 1][j - 1]);
            }
        }
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }

    // Partition Array for Maximum Sum (DP-54)
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            int currMax = 0;
            for (int j = 1; j <= Math.min(k, i); j++) {
                currMax = Math.max(currMax, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + currMax * j);
            }
        }
        return dp[n];
    }

    // Maximum Rectangle Area with All 1's (DP-55)
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    // Count Square Submatrices with All Ones (DP-56)
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    count += dp[i][j];
                }
            }
        }
        return count;
    }
}