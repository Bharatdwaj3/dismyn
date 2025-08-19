public class LargestSecondLargest {
    public static int[] findTwoLargest(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2 && num != max1) {
                max2 = num;
            }
        }
        return new int[]{max1, max2};
    }

    public static void main(String[] args) {
        int[] res = findTwoLargest(new int[]{10, 20, 4, 45, 99});
        System.out.println("Largest: " + res[0] + ", Second Largest: " + res[1]);
    }
}