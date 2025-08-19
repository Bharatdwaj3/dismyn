public class SubstringsWithAllThree {
    static int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0, total = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                total += s.length() - right;
                count[s.charAt(left++) - 'a']--;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println("Number of substrings with all a, b, c: " + numberOfSubstrings(s));
    }
}