public class MaxXORSubsetSums {
    public static int maxXOR(int[] nums) {
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxXOR(new int[]{1,2,3}));
    }

}