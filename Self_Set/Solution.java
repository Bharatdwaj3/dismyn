import java.util.*;

public class Solution {
    static int[] tree;
    static int[] nums;
    static int n;

    static void build(int srt, int end, int idx) {
        if (srt == end) {
            tree[idx] = nums[srt];
            return;
        }
        int mid = (srt + end) / 2;
        build(srt, mid, 2 * idx);
        build(mid + 1, end, 2 * idx + 1);
        tree[idx] = Math.min(tree[2 * idx], tree[2 * idx + 1]);
    }

    static void update(int srt, int end, int idx, int pos, int val) {
        if (srt == end) {
            tree[idx] = val;
            return;
        }
        int mid = (srt + end) / 2;
        if (pos <= mid) {
            update(srt, mid, 2 * idx, pos, val);
        } else {
            update(mid + 1, end, 2 * idx + 1, pos, val);
        }
        tree[idx] = Math.min(tree[2 * idx], tree[2 * idx + 1]);
    }

    static int minQuery(int srt, int end, int idx, int l, int r) {
        if (end < l || srt > r)
            return Integer.MAX_VALUE;
        if (srt >= l && end <= r)
            return tree[idx];
        int mid = (srt + end) / 2;
        int leftMin = minQuery(srt, mid, 2 * idx, l, r);
        int rightMin = minQuery(mid + 1, end, 2 * idx + 1, l, r);
        return Math.min(leftMin, rightMin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int q = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        tree = new int[4 * n];
        build(0, n - 1, 1);
        while (q-- > 0) {
            String cmd = sc.next();
            if (cmd.equals("q")) {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;
                System.out.println(minQuery(0, n - 1, 1, l, r));
            } else if (cmd.equals("u")) {
                int idx = sc.nextInt() - 1;
                int val = sc.nextInt();
                update(0, n - 1, 1, idx, val);
            }
        }
        sc.close();
    }
}