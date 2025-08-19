import java.util.*;

public class TaskScheduler {
    static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) freq[task - 'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) if (f > 0) maxHeap.offer(f);
        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;
            for (int i = 0; i < cycle && !maxHeap.isEmpty(); i++) {
                int count = maxHeap.poll();
                if (count > 1) temp.add(count - 1);
                time++;
            }
            for (int count : temp) maxHeap.offer(count);
            if (!maxHeap.isEmpty()) time += cycle - temp.size();
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Least Interval: " + leastInterval(tasks, n));
    }
}