public class MinChangesToMountain {
    public static int minChanges(String s) {
        int n = s.length();
        int[] inc = new int[n], dec = new int[n];
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) < s.charAt(i)) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (s.charAt(j) < s.charAt(i)) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }
        int maxMountain = 0;
        for (int i = 0; i < n; i++) {
            if (inc[i] > 1 && dec[i] > 1)
                maxMountain = Math.max(maxMountain, inc[i] + dec[i] - 1);
        }
        return n - maxMountain;
    }

    public static void main(String[] args) {
        System.out.println(minChanges("abcdefedcba"));
    }
}