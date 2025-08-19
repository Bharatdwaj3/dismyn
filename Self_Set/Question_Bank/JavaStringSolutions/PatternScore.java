public class PatternScore {
    public static int patternScore(String s, String pattern) {
        int score = 0;
        for (int i = 0; i <= s.length() - pattern.length(); i++) {
            if (s.substring(i, i + pattern.length()).equals(pattern)) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(patternScore("ababab", "ab"));
    }
}