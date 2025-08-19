public class MinVillainRemovals {
    public static int minRemovals(int[] strengths, int limit) {
        int count = 0, sum = 0;
        for (int i = 0; i < strengths.length; i++) {
            sum += strengths[i];
        }
        Arrays.sort(strengths);
        for (int i = strengths.length - 1; i >= 0 && sum > limit; i--) {
            sum -= strengths[i];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] villains = {4, 2, 1, 10};
        System.out.println(minRemovals(villains, 10)); // Remove to make sum ≤ 10
    }
}