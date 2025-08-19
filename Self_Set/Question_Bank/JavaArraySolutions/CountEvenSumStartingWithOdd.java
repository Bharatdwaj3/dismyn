public class CountEvenSumStartingWithOdd {
    public static int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum % 2 == 0) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 2, 3, 4}));
    }

}