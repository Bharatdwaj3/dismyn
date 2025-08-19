import java.util.*;

public class MinWindowSubstring {
    static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> target = new HashMap<>();
        for (char ch : t.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        int left = 0, start = 0, minLen = Integer.MAX_VALUE;
        int required = target.size(), formed = 0;
        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (target.containsKey(ch) && window.get(ch).intValue() == target.get(ch).intValue()) {
                formed++;
            }
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left++);
                window.put(leftChar, window.get(leftChar) - 1);
                if (target.containsKey(leftChar) && window.get(leftChar) < target.get(leftChar)) {
                    formed--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + minWindow(s, t));
    }
}