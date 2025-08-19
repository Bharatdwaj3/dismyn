public class MaxProductPalindromicSubseq {
    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    public static int maxProduct(String s) {
        int n = s.length(), max = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            StringBuilder a = new StringBuilder(), b = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) a.append(s.charAt(i));
                else b.append(s.charAt(i));
            }
            if (isPalindrome(a.toString()) && isPalindrome(b.toString())) {
                max = Math.max(max, a.length() * b.length());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct("acdapmpomp")); // Sample string
    }
}