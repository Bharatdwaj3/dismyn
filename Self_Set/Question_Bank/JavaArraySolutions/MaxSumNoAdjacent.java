public class MaxSumNoAdjacent {
    public static int maxSum(int[] nums) {
        int incl = 0, excl = 0;
        for (int num : nums) {
            int temp = incl;
            incl = Math.max(excl + num, incl);
            excl = temp;
        }
        return incl;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{3, 2, 5, 10, 7}));
    }

}