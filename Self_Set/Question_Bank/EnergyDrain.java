package Question_Bank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnergyDrain {

    public static int minExercisesToTire(int E, int N, List<Integer> A) {
        List<Integer> tempExercises = new ArrayList<>();
        for (int drain : A) {
            tempExercises.add(drain);
            tempExercises.add(drain);
        }
        Collections.sort(tempExercises);

        int totalExercisesDone = 0;
        int currentEnergy = E;

        for (int drain : tempExercises) {
            if (currentEnergy <= 0) {
                break;
            }
            currentEnergy -= drain;
            totalExercisesDone++;
        }

        if (currentEnergy > 0) {
            return -1; 
        } else {
            return totalExercisesDone;
        }
    }

    public static void main(String[] args) {
        // Sample 1
        // int E1 = 6;
        // int N1 = 2;
        // List<Integer> A1 = new ArrayList<>();
        // A1.add(1);
        // A1.add(2);
        // System.out.println(minExercisesToTire(E1, N1, A1)); // Expected: 4

        // Sample 2
        // int E2 = 10;
        // int N2 = 2;
        // List<Integer> A2 = new ArrayList<>();
        // A2.add(1);
        // A2.add(2);
        // System.out.println(minExercisesToTire(E2, N2, A2)); // Expected: -1

        // Sample 3
        // int E3 = 2;
        // int N3 = 1;
        // List<Integer> A3 = new ArrayList<>();
        // A3.add(5);
        // System.out.println(minExercisesToTire(E3, N3, A3)); // Expected: 1
    }
}