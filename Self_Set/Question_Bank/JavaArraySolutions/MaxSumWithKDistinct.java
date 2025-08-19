import java.util.*;

public class MaxSumWithKDistinct {
    public static int maxSum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, sum = 0, max = 0;
        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            sum += nums[right];
            while (freq.size() > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) freq.remove(nums[left]);
                sum -= nums[left++];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1,2,1,2,3}, 2));
    }

}