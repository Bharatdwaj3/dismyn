import java.util.*;

public class MinPlatformsRequired {
    public static int findPlatforms(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 0, maxPlat = 0, i = 0, j = 0;
        while (i < arr.length && j < dep.length) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
                maxPlat = Math.max(maxPlat, plat_needed);
            } else {
                plat_needed--;
                j++;
            }
        }
        return maxPlat;
    }

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatforms(arr, dep));
    }
}