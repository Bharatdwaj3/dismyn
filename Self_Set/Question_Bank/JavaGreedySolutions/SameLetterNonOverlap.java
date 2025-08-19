import java.util.*;

public class SameLetterNonOverlap {
    public static int maxSubstrings(String s) {
        Map<Character, Integer> first = new HashMap<>(), last = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            first.putIfAbsent(s.charAt(i), i);
            last.put(s.charAt(i), i);
        }

        List<int[]> ranges = new ArrayList<>();
        for (char c : first.keySet()) {
            int start = first.get(c), end = last.get(c);
            int j = start;
            while (j <= end) {
                end = Math.max(end, last.get(s.charAt(j)));
                j++;
            }
            ranges.add(new int[]{start, end});
        }

        ranges.sort(Comparator.comparingInt(a -> a[1]));
        int count = 0, prevEnd = -1;
        for (int[] r : ranges) {
            if (r[0] > prevEnd) {
                count++;
                prevEnd = r[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxSubstrings("adefaddaccc")); // Expected: 3
    }
}