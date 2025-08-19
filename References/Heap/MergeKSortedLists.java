import java.util.*;

public class MergeKSortedLists {
    static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new int[]{lists.get(i).get(0), i, 0});
            }
        }
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int val = curr[0], listIdx = curr[1], idx = curr[2];
            result.add(val);
            if (idx + 1 < lists.get(listIdx).size()) {
                minHeap.offer(new int[]{lists.get(listIdx).get(idx + 1), listIdx, idx + 1});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
            Arrays.asList(1, 4, 5),
            Arrays.asList(1, 3, 4),
            Arrays.asList(2, 6)
        );
        System.out.println("Merged Lists: " + mergeKSortedLists(lists));
    }
}