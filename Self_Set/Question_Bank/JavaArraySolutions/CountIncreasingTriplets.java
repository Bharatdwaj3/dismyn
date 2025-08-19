public class CountIncreasingTriplets {
    public static int count(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++)
                    if (nums[i] < nums[j] && nums[j] < nums[k]) count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count(new int[]{1, 2, 3, 4}));
    }

}