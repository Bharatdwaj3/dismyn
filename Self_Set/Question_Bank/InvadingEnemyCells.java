package Question_Bank;

import java.util.*;

public class InvadingEnemyCells {

    public static int minTimeToInvade(int N, int M, List<String> Q) {
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = Q.get(i).toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>(); // int[]: {row, col, time}
        int enemyCells = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == 'A') {
                    queue.offer(new int[] { r, c, 0 });
                } else if (grid[r][c] == 'E') {
                    enemyCells++;
                }
            }
        }

        if (enemyCells == 0) {
            return 0; // No enemy cells to invade
        }

        int maxTime = 0;
        int invadedEnemies = 0;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int time = current[2];
            maxTime = Math.max(maxTime, time);

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && grid[nr][nc] == 'E') {
                    grid[nr][nc] = 'A'; // Mark as invaded
                    invadedEnemies++;
                    queue.offer(new int[] { nr, nc, time + 1 });
                }
            }
        }

        if (invadedEnemies == enemyCells) {
            return maxTime;
        } else {
            return -1; // Not all enemy cells could be invaded
        }
    }

    public static void main(String[] args) {
        // Sample 1
        // int N1 = 2;
        // int M1 = 2;
        // List<String> Q1 = List.of("AE", "EE");
        // System.out.println(minTimeToInvade(N1, M1, Q1)); // Expected: 2

        // Sample 2
        // int N2 = 3;
        // int M2 = 2;
        // List<String> Q2 = List.of("AE", "*E", "EE");
        // System.out.println(minTimeToInvade(N2, M2, Q2)); // Expected: 4

        // Sample 3
        // int N3 = 3;
        // int M3 = 2;
        // List<String> Q3 = List.of("AE", "**", "EE");
        // System.out.println(minTimeToInvade(N3, M3, Q3)); // Expected: -1
    }
}