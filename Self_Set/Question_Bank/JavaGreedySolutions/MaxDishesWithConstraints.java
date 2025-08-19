import java.util.*;

public class MaxDishesWithConstraints {
    public static int maxDishes(int[] dishes, int maxType) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        for (int right = 0; right < dishes.length; right++) {
            map.put(dishes[right], map.getOrDefault(dishes[right], 0) + 1);
            while (map.size() > maxType) {
                int count = map.get(dishes[left]) - 1;
                if (count == 0) map.remove(dishes[left]);
                else map.put(dishes[left], count);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] dishes = {1, 2, 1, 3, 4, 2, 3};
        System.out.println(maxDishes(dishes, 2)); // Max subarray with at most 2 types
    }
}