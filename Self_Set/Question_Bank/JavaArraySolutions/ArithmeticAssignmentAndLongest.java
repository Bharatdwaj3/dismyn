public class ArithmeticAssignmentAndLongest {
    public static int longestArithmeticSubarray(int[] nums) {
        if (nums.length < 2) return nums.length;
        int maxLen = 2, currLen = 2, diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                currLen++;
            } else {
                diff = nums[i] - nums[i - 1];
                currLen = 2;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestArithmeticSubarray(new int[]{1, 3, 5, 7, 9}));
    }

}