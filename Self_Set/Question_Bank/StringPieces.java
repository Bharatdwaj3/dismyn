package Question_Bank;

import java.util.HashMap;
import java.util.Map;

public class StringPieces {
    public static int maxStringPieces(String S) {
        int n = S.length();
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : S.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        int maxPieces = 1; // Minimum 1 piece (the entire string)

        for (int numPieces = 1; numPieces <= n; numPieces++) {
            if (n % numPieces == 0) {
                boolean possible = true;
                for (int count : charCounts.values()) {
                    if (count % numPieces != 0) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    maxPieces = numPieces;
                }
            }
        }
        return maxPieces;
    }

    public static void main(String[] args) {
        // Sample 1
        // String S1 = "ZZZZZ";
        // System.out.println(maxStringPieces(S1)); // Expected: 5

        // Sample 2
        // String S2 = "ababcc";
        // System.out.println(maxStringPieces(S2)); // Expected: 2

        // Sample 3
        // String S3 = "abccdcabacda";
        // System.out.println(maxStringPieces(S3)); // Expected: 2
    }
}