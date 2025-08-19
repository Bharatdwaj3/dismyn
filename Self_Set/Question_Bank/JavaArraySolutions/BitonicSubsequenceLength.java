public class BitonicSubsequenceLength {
    public static int longestBitonic(int[] nums) {
        int n = nums.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) inc[i] = Math.max(inc[i], inc[j] + 1);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) dec[i] = Math.max(dec[i], dec[j] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, inc[i] + dec[i] - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestBitonic(new int[]{1, 11, 2, 10, 4, 5, 2, 1}));
    }

}