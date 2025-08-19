package Question_Bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap; // To get sorted keys 

public class MaxDishesFriendCanEat {

    public static int maxDishesFriendCanEat(int N, List<Integer> Arr) { 
        // Count occurrences of each dish type 
        Map<Integer, Integer> typeCounts = new HashMap<>(); 
        for (int dishType : Arr) { 
            typeCounts.put(dishType, typeCounts.getOrDefault(dishType, 0) + 1); 
        } 
 
        // Count frequencies of the counts themselves (e.g., how many types have 1 dish, 2 dishes, etc.) 
        TreeMap<Integer, Integer> dishCountFrequencies = new TreeMap<>(); // TreeMap to keep keys sorted 
        for (int count : typeCounts.values()) { 
            dishCountFrequencies.put(count, dishCountFrequencies.getOrDefault(count, 0) + 1); 
        } 
 
        int maxTotalDishes = 0; 
 
        // Iterate through all possible starting dish counts (s) 
        List<Integer> uniqueCounts = new ArrayList<>(dishCountFrequencies.keySet()); 
        Collections.sort(uniqueCounts); // Ensure ascending order 
 
        for (int startDishCount : uniqueCounts) { 
            int currentTotalDishes = 0; 
            int currentOrderSize = startDishCount; 
             
            // Create a temporary map to track available counts for this specific path 
            TreeMap<Integer, Integer> tempDishCountFrequencies = new 
TreeMap<>(dishCountFrequencies); 
 
            while (tempDishCountFrequencies.getOrDefault(currentOrderSize, 0) > 0) { 
                tempDishCountFrequencies.put(currentOrderSize, 
tempDishCountFrequencies.get(currentOrderSize) - 1); 
                currentTotalDishes += currentOrderSize; 
                currentOrderSize *= 2; // Next order must be double 
            } 
            maxTotalDishes = Math.max(maxTotalDishes, currentTotalDishes); 
        } 
 
        return maxTotalDishes; 
    }

    public static void main(String[] args) {
        // Sample 1
        // int N1 = 5;
        // List<Integer> Arr1 = List.of(1, 2, 4, 2, 3);
        // System.out.println(maxDishesFriendCanEat(N1, Arr1)); // Expected: 4

        // Sample 2
        // int N2 = 7;
        // List<Integer> Arr2 = List.of(2, 2, 1, 1, 1, 1, 1);
        // System.out.println(maxDishesFriendCanEat(N2, Arr2)); // Expected: 6

        // Sample 3
        // int N3 = 4;
        // List<Integer> Arr3 = List.of(1, 1, 1, 1);
        // System.out.println(maxDishesFriendCanEat(N3, Arr3)); // Expected: 4
    }
}
