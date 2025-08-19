public class SumAllSubarraysModulo {
    public static long sumSubarraysModulo(int[] arr, int mod) {
        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = (sum + arr[j]) % mod;
                total = (total + sum) % mod;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarraysModulo(new int[]{1,2,3}, 1000000007));
    }

}