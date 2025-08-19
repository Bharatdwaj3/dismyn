import java.util.*;

public class MiceToHolesMinDistance {
    public static int assignMice(int[] mice, int[] holes) {
        Arrays.sort(mice);
        Arrays.sort(holes);
        int maxDist = 0;
        for (int i = 0; i < mice.length; i++) {
            maxDist = Math.max(maxDist, Math.abs(mice[i] - holes[i]));
        }
        return maxDist;
    }

    public static void main(String[] args) {
        int[] mice = {4, -4, 2}, holes = {4, 0, 5};
        System.out.println(assignMice(mice, holes));
    }
}