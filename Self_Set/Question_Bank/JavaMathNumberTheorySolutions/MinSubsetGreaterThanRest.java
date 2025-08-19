import java.util.*;

public class MinSubsetGreaterThanRest {
    public static int minSubset(int[] arr) {
        Arrays.sort(arr);
        int total = 0, sum = 0, count = 0;
        for (int x : arr) total += x;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            count++;
            if (sum > total - sum) break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 7, 1};
        System.out.println(minSubset(arr)); // Expected: 1
    }
}