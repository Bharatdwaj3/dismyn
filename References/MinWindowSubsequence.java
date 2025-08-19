public class MinWindowSubsequence {
    static String minWindow(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int minLen = Integer.MAX_VALUE, start = -1;

        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) != s2.charAt(0)) continue;
            int j = i, k = 0;
            while (j < m && k < n) {
                if (s1.charAt(j) == s2.charAt(k)) k++;
                j++;
            }
            if (k == n) {
                int end = j - 1;
                k = n - 1;
                while (j >= i && k >= 0) {
                    j--;
                    if (s1.charAt(j) == s2.charAt(k)) k--;
                }
                if (end - j < minLen) {
                    minLen = end - j;
                    start = j + 1;
                }
            }
        }

        return start == -1 ? "" : s1.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s1 = "abcdebdde", s2 = "bde";
        System.out.println("Minimum window subsequence: " + minWindow(s1, s2));
    }
}