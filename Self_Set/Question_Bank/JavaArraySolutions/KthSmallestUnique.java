import java.util.*;

public class KthSmallestUnique {
    public static int findKth(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        List<Integer> uniques = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() == 1) uniques.add(e.getKey());
        }
        Collections.sort(uniques);
        return k <= uniques.size() ? uniques.get(k - 1) : -1;
    }

    public static void main(String[] args) {
        System.out.println(findKth(new int[]{4, 2, 2, 1, 3}, 2));
    }

}