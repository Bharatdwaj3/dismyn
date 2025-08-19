public class BracketBalancingMinOps {
    public static int minSwaps(String s) {
        int open = 0, close = 0, unbalanced = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') open++;
            else {
                if (open > 0) open--;
                else unbalanced++;
            }
        }
        return (unbalanced + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("][][")); // Expected: 1
    }
}