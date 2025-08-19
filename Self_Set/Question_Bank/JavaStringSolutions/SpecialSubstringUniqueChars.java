import java.util.*;

public class SpecialSubstringUniqueChars {
    public static int longestUniqueSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("abcabcbb"));
    }
}