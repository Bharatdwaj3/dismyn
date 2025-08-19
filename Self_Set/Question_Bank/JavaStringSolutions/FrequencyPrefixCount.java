import java.util.*;

public class FrequencyPrefixCount {
    public static int countPrefixFrequency(String s, char ch, int pos) {
        int count = 0;
        for (int i = 0; i <= pos && i < s.length(); i++) {
            if (s.charAt(i) == ch) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrefixFrequency("abracadabra", 'a', 5));
    }
}