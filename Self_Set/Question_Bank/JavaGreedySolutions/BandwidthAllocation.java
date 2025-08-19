import java.util.*;

public class BandwidthAllocation {
    static class Request {
        int start, end, bandwidth;
        Request(int s, int e, int b) { start = s; end = e; bandwidth = b; }
    }

    public static int allocate(Request[] requests, int capacity) {
        Arrays.sort(requests, Comparator.comparingInt(a -> a.end));
        int[] timeline = new int[1001];
        for (Request r : requests) {
            boolean canAllocate = true;
            for (int i = r.start; i < r.end; i++) {
                if (timeline[i] + r.bandwidth > capacity) {
                    canAllocate = false;
                    break;
                }
            }
            if (canAllocate) {
                for (int i = r.start; i < r.end; i++) {
                    timeline[i] += r.bandwidth;
                }
            }
        }
        int used = 0;
        for (int t : timeline) used = Math.max(used, t);
        return used;
    }

    public static void main(String[] args) {
        Request[] req = {
            new Request(1, 4, 3),
            new Request(2, 6, 4),
            new Request(5, 7, 2)
        };
        System.out.println(allocate(req, 5));
    }
}