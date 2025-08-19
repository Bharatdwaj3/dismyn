public class XORQuery {
    public static int[] xorQuery(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) prefix[i + 1] = prefix[i] ^ arr[i];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            res[i] = prefix[r + 1] ^ prefix[l];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = xorQuery(new int[]{1,3,4,8}, new int[][]{{0,1},{1,2}});
        for(int v : res) System.out.print(v + " ");
    }

}