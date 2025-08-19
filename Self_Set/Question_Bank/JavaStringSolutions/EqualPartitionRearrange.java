import java.util.*;

public class EqualPartitionRearrange {
    public static boolean canPartition(String s, int parts) {
        if (s.length() % parts != 0) return false;
        int len = s.length() / parts;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < s.length(); i += len) {
            for (int j = i + 1; j < i + len; j++) {
                if (chars[j] != chars[i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canPartition("aabbcc", 3));
    }
}