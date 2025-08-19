public class CountNiceSubarrays {
    static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    static int atMost(int[] nums, int k) {
        int left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) k--;
            while (k < 0) {
                if (nums[left++] % 2 != 0) k++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println("Nice subarrays count: " + numberOfSubarrays(nums, k));
    }
}