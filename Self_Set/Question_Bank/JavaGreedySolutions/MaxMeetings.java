import java.util.*;

public class MaxMeetings {
    public static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++)
            meetings[i] = new int[] { start[i], end[i] };
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));

        int count = 0, lastEnd = 0;
        for (int[] m : meetings) {
            if (m[0] > lastEnd) {
                count++;
                lastEnd = m[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        System.out.println(maxMeetings(start, end));
    }
}