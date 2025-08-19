import java.util.*;

public class AssignCookies {
    public static int findContentChildren(int[] greed, int[] size) {
        Arrays.sort(greed);
        Arrays.sort(size);
        int i = 0, j = 0;
        while (i < greed.length && j < size.length) {
            if (size[j] >= greed[i]) i++;
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] greed = {1, 2, 3}, size = {1, 1};
        System.out.println(findContentChildren(greed, size)); // Expected: 1
    }
}