public class BasesStartingWithOne {
    public static int countBases(int n) {
        int count = 0;
        for (int b = 2; b <= n; b++) {
            String rep = Integer.toString(n, b);
            if (rep.charAt(0) == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBases(10)); // Expected: Count of bases where 10 starts with '1'
    }
}