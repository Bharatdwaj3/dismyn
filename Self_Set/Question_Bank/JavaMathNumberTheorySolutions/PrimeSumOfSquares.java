public class PrimeSumOfSquares {
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static boolean canBeSumOfSquares(int n) {
        for (int a = 1; a * a < n; a++) {
            int b2 = n - a * a;
            int b = (int) Math.sqrt(b2);
            if (b * b == b2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 29;
        if (isPrime(n)) {
            System.out.println(canBeSumOfSquares(n));
        } else {
            System.out.println("Not a prime.");
        }
    }
}