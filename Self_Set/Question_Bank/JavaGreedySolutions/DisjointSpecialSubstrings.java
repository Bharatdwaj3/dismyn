public class DisjointSpecialSubstrings {
    public static int maxDisjointSubstrings(String s) {
        int n = s.length(), count = 0, i = 0;
        while (i < n) {
            int[] freq = new int[26];
            int j = i;
            while (j < n && ++freq[s.charAt(j++) - 'a'] <= 1);
            count++;
            i = j;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxDisjointSubstrings("abac")); // "ab", "ac"
    }
}