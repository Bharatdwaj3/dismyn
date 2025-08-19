package Question_Bank;

import java.util.List;

public class OilTankDisturbances {
    public static int minInitialOil(int N, int C, List<Integer> A) {
        int minOilNeededForBuys = 0;
        int currentOil = 0;

        // Calculate the maximum deficit that occurs due to buy operations
        // This determines the minimum initial oil needed to cover all buys
        for (int action : A) {
            if (action == -1) { // Person wants to buy
                currentOil--;
            } else if (action == 1) { // Person wants to sell
                currentOil++;
            }

            // If current_oil goes negative, it means we needed more initial oil
            minOilNeededForBuys = Math.max(minOilNeededForBuys, -currentOil);
        }

        // The minimum initial amount X required to achieve the least number of
        // disturbances
        // is the amount needed to ensure no disturbances from buying when empty.
        // Any additional X would only potentially lead to more sell disturbances if it
        // exceeds capacity.
        return minOilNeededForBuys;
    }

    public static void main(String[] args) {
        // Sample 1
        // int N1 = 3;
        // int C1 = 3;
        // List<Integer> A1 = List.of(-1, 1, 1);
        // System.out.println(minInitialOil(N1, C1, A1)); // Expected: 1

        // Sample 2
        // int N2 = 3;
        // int C2 = 2;
        // List<Integer> A2 = List.of(-1, -1, 1);
        // System.out.println(minInitialOil(N2, C2, A2)); // Expected: 2

        // Sample 3
        // int N3 = 4;
        // int C3 = 3;
        // List<Integer> A3 = List.of(1, 1, 1, 1);
        // System.out.println(minInitialOil(N3, C3, A3)); // Expected: 0
    }
}