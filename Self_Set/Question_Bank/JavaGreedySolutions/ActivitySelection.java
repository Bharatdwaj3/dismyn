import java.util.*;

public class ActivitySelection {

    static class EndTimeComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
        }
    }

    public static int maxActivities(int[][] intervals) {
        Arrays.sort(intervals, new EndTimeComparator());
        int count = 0;
        int end = -1;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                count++;
                end = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 4 }, { 3, 5 } };
        System.out.println(maxActivities(intervals)); // Output: 2
    }
}
