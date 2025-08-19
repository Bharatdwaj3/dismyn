public class MinimumInitialOil {
    public static int minInitialOil(int[] changes) {
        int oil = 0, minOil = 0;
        for (int c : changes) {
            oil += c;
            minOil = Math.min(minOil, oil);
        }
        return -minOil;
    }

    public static void main(String[] args) {
        int[] changes = {-4, 3, -2, 1};
        System.out.println(minInitialOil(changes)); // Expected: 3
    }
}