public class LexSmallestOneSwapWithinK {
    public static int[] smallestArray(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j <= Math.min(n - 1, i + k); j++) {
                if (nums[j] < nums[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] res = smallestArray(new int[]{3,2,1}, 2);
        for(int v : res) System.out.print(v + " ");
    }

}