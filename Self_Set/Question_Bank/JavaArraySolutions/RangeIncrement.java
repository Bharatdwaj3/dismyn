public class RangeIncrement {
    public static int[] applyIncrements(int[] arr, int[][] updates) {
        int[] result = new int[arr.length];
        int[] diff = new int[arr.length + 1];
        for (int[] upd : updates) {
            diff[upd[0]] += upd[2];
            if (upd[1] + 1 < diff.length) diff[upd[1] + 1] -= upd[2];
        }
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += diff[i];
            result[i] = arr[i] + curr;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] res = applyIncrements(new int[]{1,2,3}, new int[][]{{0,1,2}});
        for(int v : res) System.out.print(v + " ");
    }

}