public class ComplexDecrementMaxSum {
    public static int maxSum(int X, int Y, int Z) {
        int sum = 0;
        while (X > 0 || Y > 0 || Z > 0) {
            int max = Math.max(X, Math.max(Y, Z));
            sum += max;
            if (X == max) X--;
            else if (Y == max) Y--;
            else Z--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(3, 2, 1));
    }

}