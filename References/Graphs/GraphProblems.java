import java.util.*;

public class GraphProblems {

    // Number of Provinces (Disjoint Set)
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int p1 = find(parent, i);
                    int p2 = find(parent, j);
                    if (p1 != p2) parent[p1] = p2;
                }
            }
        }
        
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) provinces++;
        }
        return provinces;
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    // Rotten Oranges (BFS)
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) fresh++;
            }
        }
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0], y = curr[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }

    // Flood Fill (DFS)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        dfsFloodFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfsFloodFill(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) return;
        image[r][c] = newColor;
        dfsFloodFill(image, r+1, c, oldColor, newColor);
        dfsFloodFill(image, r-1, c, oldColor, newColor);
        dfsFloodFill(image, r, c+1, oldColor, newColor);
        dfsFloodFill(image, r, c-1, oldColor, newColor);
    }

    // Cycle Detection in Undirected Graph (BFS)
    public boolean hasCycleBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, -1});
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int node = curr[0], parent = curr[1];
                    for (int neighbor : adj.get(node)) {
                        if (!visited[neighbor]) {
                            queue.offer(new int[]{neighbor, node});
                            visited[neighbor] = true;
                        } else if (neighbor != parent) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // Cycle Detection in Undirected Graph (DFS)
    public boolean hasCycleDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfsCycleUtil(i, -1, visited, adj)) return true;
        }
        return false;
    }
    
    private boolean dfsCycleUtil(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfsCycleUtil(neighbor, node, visited, adj)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // 0/1 Matrix (BFS)
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) queue.offer(new int[]{i, j});
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0], y = curr[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && dist[x][y] > dist[curr[0]][curr[1]] + 1) {
                    dist[x][y] = dist[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return dist;
    }

    // Surrounded Regions (DFS)
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfsSurround(board, i, 0);
            if (board[i][n-1] == 'O') dfsSurround(board, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfsSurround(board, 0, j);
            if (board[m-1][j] == 'O') dfsSurround(board, m-1, j);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    
    private void dfsSurround(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') return;
        board[r][c] = '#';
        dfsSurround(board, r+1, c);
        dfsSurround(board, r-1, c);
        dfsSurround(board, r, c+1);
        dfsSurround(board, r, c-1);
    }

    // Number of Enclaves (Flood Fill Multisource)
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) dfsEnclave(grid, i, 0);
            if (grid[i][n-1] == 1) dfsEnclave(grid, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) dfsEnclave(grid, 0, j);
            if (grid[m-1][j] == 1) dfsEnclave(grid, m-1, j);
        }
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    
    private void dfsEnclave(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) return;
        grid[r][c] = 0;
        dfsEnclave(grid, r+1, c);
        dfsEnclave(grid, r-1, c);
        dfsEnclave(grid, r, c+1);
        dfsEnclave(grid, r, c-1);
    }

    // Word Ladder - 1 (BFS)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                char[] currArr = curr.toCharArray();
                for (int j = 0; j < currArr.length; j++) {
                    char original = currArr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        currArr[j] = c;
                        String next = new String(currArr);
                        if (next.equals(endWord)) return level + 1;
                        if (wordSet.contains(next)) {
                            queue.offer(next);
                            wordSet.remove(next);
                        }
                    }
                    currArr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }

    // Word Ladder - 2 (BFS)
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordSet.contains(endWord)) return result;
        
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distances.put(beginWord, 0);
        wordSet.remove(beginWord);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int dist = distances.get(curr);
            char[] currArr = curr.toCharArray();
            for (int i = 0; i < currArr.length; i++) {
                char original = currArr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;
                    currArr[i] = c;
                    String next = new String(currArr);
                    if (wordSet.contains(next)) {
                        graph.computeIfAbsent(curr, k -> new ArrayList<>()).add(next);
                        if (!distances.containsKey(next)) {
                            distances.put(next, dist + 1);
                            queue.offer(next);
                            wordSet.remove(next);
                        }
                    }
                }
                currArr[i] = original;
            }
        }
        
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfsWordLadder(beginWord, endWord, graph, distances, path, result);
        return result;
    }
    
    private void dfsWordLadder(String curr, String endWord, Map<String, List<String>> graph, 
                              Map<String, Integer> distances, List<String> path, List<List<String>> result) {
        if (curr.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (!graph.containsKey(curr)) return;
        for (String next : graph.get(curr)) {
            if (distances.get(next) == distances.get(curr) + 1) {
                path.add(next);
                dfsWordLadder(next, endWord, graph, distances, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    // Number of Distinct Islands (DFS Multisource)
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfsIsland(grid, i, j, i, j, sb);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }
    
    private void dfsIsland(int[][] grid, int r, int c, int r0, int c0, StringBuilder sb) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) return;
        grid[r][c] = 0;
        sb.append((r - r0) + "," + (c - c0) + ";");
        dfsIsland(grid, r+1, c, r0, c0, sb);
        dfsIsland(grid, r-1, c, r0, c0, sb);
        dfsIsland(grid, r, c+1, r0, c0, sb);
        dfsIsland(grid, r, c-1, r0, c0, sb);
    }

    // Bipartite Graph (DFS)
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        
        for (int i = 0; i < V; i++) {
            if (colors[i] == -1 && !dfsBipartite(graph, i, 0, colors)) return false;
        }
        return true;
    }
    
    private boolean dfsBipartite(int[][] graph, int node, int color, int[] colors) {
        colors[node] = color;
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == -1) {
                if (!dfsBipartite(graph, neighbor, 1 - color, colors)) return false;
            } else if (colors[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    // Cycle Detection in Directed Graph (DFS)
    public boolean hasCycleDirectedDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfsCycleDirectedUtil(i, visited, recStack, adj)) return true;
        }
        return false;
    }
    
    private boolean dfsCycleDirectedUtil(int node, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && dfsCycleDirectedUtil(neighbor, visited, recStack, adj)) return true;
            else if (recStack[neighbor]) return true;
        }
        recStack[node] = false;
        return false;
    }

    // Topological Sort (DFS)
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfsTopoSort(i, visited, stack, adj);
        }
        
        int[] result = new int[V];
        int idx = 0;
        while (!stack.isEmpty()) result[idx++] = stack.pop();
        return result;
    }
    
    private void dfsTopoSort(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) dfsTopoSort(neighbor, visited, stack, adj);
        }
        stack.push(node);
    }

    // Kahn's Algorithm (BFS Topological Sort)
    public int[] topoSortKahn(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) inDegree[neighbor]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        
        int[] result = new int[V];
        int idx = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[idx++] = node;
            for (int neighbor : adj.get(node)) {
                if (--inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        return idx == V ? result : new int[0];
    }

    // Cycle Detection in Directed Graph (BFS)
    public boolean hasCycleDirectedBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) inDegree[neighbor]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : adj.get(node)) {
                if (--inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        return count != V;
    }

    // Course Schedule - I
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] pre : prerequisites) adj.get(pre[1]).add(pre[0]);
        
        return !hasCycleDirectedDFS(numCourses, adj);
    }

    // Course Schedule - II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] pre : prerequisites) adj.get(pre[1]).add(pre[0]);
        
        return topoSortKahn(numCourses, adj);
    }

    // Find Eventual Safe States
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        boolean[] safe = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) dfsSafeNodes(i, visited, recStack, safe, graph);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe[i]) result.add(i);
        }
        return result;
    }
    
    private boolean dfsSafeNodes(int node, boolean[] visited, boolean[] recStack, boolean[] safe, int[][] graph) {
        visited[node] = true;
        recStack[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor] && !dfsSafeNodes(neighbor, visited, recStack, safe, graph)) return false;
            else if (recStack[neighbor]) return false;
        }
        recStack[node] = false;
        safe[node] = true;
        return true;
    }

    // Alien Dictionary
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    inDegree.put(w2.charAt(j), inDegree.getOrDefault(w2.charAt(j), 0) + 1);
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) queue.offer(c);
        }
        
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            for (char neighbor : adj.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }
        
        return result.length() == inDegree.size() ? result.toString() : "";
    }

    // Shortest Path in UG with Unit Weights (BFS)
    public int[] shortestPath(int V, ArrayList<ArrayList<Integer>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return dist;
    }

    // Shortest Path in DAG
    public int[] shortestPathDAG(int V, ArrayList<ArrayList<int[]>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        int[] topo = topoSort(V, adj);
        for (int node : topo) {
            if (dist[node] != Integer.MAX_VALUE) {
                for (int[] neighbor : adj.get(node)) {
                    int v = neighbor[0], w = neighbor[1];
                    if (dist[node] + w < dist[v]) dist[v] = dist[node] + w;
                }
            }
        }
        return dist;
    }

    // Dijkstra's Algorithm
    public int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];
            if (d > dist[node]) continue;
            
            for (int[] neighbor : adj.get(node)) {
                int v = neighbor[0], w = neighbor[1];
                if (dist[node] + w < dist[v]) {
                    dist[v] = dist[node] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }

    // Why Priority Queue is used in Dijkstra's Algorithm
    // Priority Queue ensures the node with the smallest tentative distance is processed first,
    // which is crucial for finding the shortest path efficiently in a greedy manner.

    // Shortest Path in a Binary Maze
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            if (r == n-1 && c == n-1) return dist[r][c];
            
            for (int[] dir : dirs) {
                int x = r + dir[0], y = c + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0 && dist[r][c] + 1 < dist[x][y]) {
                    dist[x][y] = dist[r][c] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }

    // Path with Minimum Effort
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], effort = curr[2];
            if (r == m-1 && c == n-1) return effort;
            if (effort > dist[r][c]) continue;
            
            for (int[] dir : dirs) {
                int x = r + dir[0], y = c + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[r][c]));
                    if (newEffort < dist[x][y]) {
                        dist[x][y] = newEffort;
                        pq.offer(new int[]{x, y, newEffort});
                    }
                }
            }
        }
        return 0;
    }

    // Cheapest Flights Within K Stops
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], w = flight[2];
                if (prices[u] != Integer.MAX_VALUE) {
                    temp[v] = Math.min(temp[v], prices[u] + w);
                }
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    // Network Delay Time
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] time : times) {
            adj.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];
            if (d > dist[node]) continue;
            
            if (adj.containsKey(node)) {
                for (int[] neighbor : adj.get(node)) {
                    int v = neighbor[0], w = neighbor[1];
                    if (dist[node] + w < dist[v]) {
                        dist[v] = dist[node] + w;
                        pq.offer(new int[]{v, dist[v]});
                    }
                }
            }
        }
        
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }

    // Number of Ways to Arrive at Destination
    public int countPaths(int n, int[][] roads) {
        long[] ways = new long[n];
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;
        
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], x -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            adj.computeIfAbsent(road[1], x -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }
        
        int MOD = 1_000_000_007;
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int)curr[0];
            long d = curr[1];
            if (d > dist[node]) continue;
            
            for (int[] neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                int v = neighbor[0], w = neighbor[1];
                if (dist[node] + w < dist[v]) {
                    dist[v] = dist[node] + w;
                    ways[v] = ways[node];
                    pq.offer(new long[]{v, dist[v]});
                } else if (dist[node] + w == dist[v]) {
                    ways[v] = (ways[v] + ways[node]) % MOD;
                }
            }
        }
        return (int)ways[n-1];
    }

    // Minimum Steps to Reach End from Start by Multiplication and Mod
    public int minimumSteps(int[] arr, int start, int end) {
        int n = arr.length;
        int[] dist = new int[1001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == end) return dist[curr];
            
            for (int x : arr) {
                int next = (curr * x) % 1000;
                if (dist[curr] + 1 < dist[next]) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    // Bellman Ford Algorithm
    public int[] bellmanFord(int V, ArrayList<int[]> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                return new int[]{}; // Negative cycle detected
            }
        }
        return dist;
    }

    // Find City with Smallest Number of Neighbors in Threshold Distance
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        int minNeighbors = n, city = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) count++;
            }
            if (count <= minNeighbors) {
                minNeighbors = count;
                city = i;
            }
        }
        return city;
    }

    // Minimum Spanning Tree (Prim's Algorithm)
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[]{j, cost});
                adj.get(j).add(new int[]{i, cost});
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0, 0});
        int cost = 0, edgesUsed = 0;
        
        while (!pq.isEmpty() && edgesUsed < n) {
            int[] curr = pq.poll();
            int node = curr[0], w = curr[1];
            if (visited[node]) continue;
            
            visited[node] = true;
            cost += w;
            edgesUsed++;
            for (int[] neighbor : adj.get(node)) {
                if (!visited[neighbor[0]]) pq.offer(neighbor);
            }
        }
        return cost;
    }

    // Disjoint Set (Union by Rank)
    class DisjointSet {
        int[] parent, rank;
        
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        
        public boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false;
            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[px] > rank[py]) parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }

    // Kruskal's Algorithm
    public int kruskalMST(int V, ArrayList<int[]> edges) {
        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        DisjointSet ds = new DisjointSet(V);
        int cost = 0;
        
        for (int[] edge : edges) {
            if (ds.union(edge[0], edge[1])) cost += edge[2];
        }
        return cost;
    }

    // Number of Operations to Make Network Connected
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        DisjointSet ds = new DisjointSet(n);
        int extra = 0;
        
        for (int[] conn : connections) {
            if (!ds.union(conn[0], conn[1])) extra++;
        }
        
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.find(i) == i) components++;
        }
        return components - 1;
    }

    // Most Stones Removed with Same Row or Column
    public int removeStones(int[][] stones) {
        DisjointSet ds = new DisjointSet(20001);
        for (int[] stone : stones) {
            ds.union(stone[0], stone[1] + 10001);
        }
        
        Set<Integer> groups = new HashSet<>();
        for (int[] stone : stones) {
            groups.add(ds.find(stone[0]));
        }
        return stones.length - groups.size();
    }

    // Accounts Merge
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                parent.putIfAbsent(email, email);
                parent.put(email, find(parent, firstEmail));
            }
        }
        
        Map<String, TreeSet<String>> merged = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(parent, email);
            merged.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (String root : merged.keySet()) {
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(root));
            account.addAll(merged.get(root));
            result.add(account);
        }
        return result;
    }
    
    private String find(Map<String, String> parent, String x) {
        if (!parent.get(x).equals(x)) parent.put(x, find(parent, parent.get(x)));
        return parent.get(x);
    }

    // Number of Islands II
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        DisjointSet ds = new DisjointSet(m * n);
        int[][] grid = new int[m][n];
        List<Integer> result = new ArrayList<>();
        int islands = 0;
        
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            if (grid[r][c] == 1) {
                result.add(islands);
                continue;
            }
            grid[r][c] = 1;
            islands++;
            int curr = r * n + c;
            
            for (int[] dir : dirs) {
                int x = r + dir[0], y = c + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                    if (ds.union(curr, x * n + y)) islands--;
                }
            }
            result.add(islands);
        }
        return result;
    }

    // Making a Large Island
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int curr = i * n + j;
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            ds.union(curr, x * n + y);
                        }
                    }
                }
            }
        }
        
        Map<Integer, Integer> sizeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int root = ds.find(i * n + j);
                    sizeMap.put(root, sizeMap.getOrDefault(root, 0) + 1);
                }
            }
        }
        
        int maxSize = sizeMap.values().stream().max(Integer::compare).orElse(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> roots = new HashSet<>();
                    int size = 1;
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            int root = ds.find(x * n + y);
                            if (roots.add(root)) size += sizeMap.getOrDefault(root, 0);
                        }
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    // Swim in Rising Water
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], t = curr[2];
            if (r == n-1 && c == n-1) return t;
            
            for (int[] dir : dirs) {
                int x = r + dir[0], y = c + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    pq.offer(new int[]{x, y, Math.max(t, grid[x][y])});
                }
            }
        }
        return 0;
    }

    // Bridges in Graph
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> conn : connections) {
            adj.get(conn.get(0)).add(conn.get(1));
            adj.get(conn.get(1)).add(conn.get(0));
        }
        
        List<List<Integer>> bridges = new ArrayList<>();
        int[] disc = new int[n], low = new int[n], parent = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(parent, -1);
        
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) dfsBridges(i, 0, disc, low, parent, adj, bridges);
        }
        return bridges;
    }
    
    private void dfsBridges(int u, int time, int[] disc, int[] low, int[] parent, 
                           ArrayList<ArrayList<Integer>> adj, List<List<Integer>> bridges) {
        disc[u] = low[u] = time++;
        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                parent[v] = u;
                dfsBridges(v, time, disc, low, parent, adj, bridges);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) bridges.add(Arrays.asList(u, v));
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    // Articulation Points
    public List<Integer> articulationPoints(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> conn : connections) {
            adj.get(conn.get(0)).add(conn.get(1));
            adj.get(conn.get(1)).add(conn.get(0));
        }
        
        List<Integer> articulationPoints = new ArrayList<>();
        int[] disc = new int[n], low = new int[n], parent = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(parent, -1);
        
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) dfsAP(i, 0, disc, low, parent, adj, articulationPoints);
        }
        return articulationPoints;
    }
    
    private void dfsAP(int u, int time, int[] disc, int[] low, int[] parent, 
                      ArrayList<ArrayList<Integer>> adj, List<Integer> articulationPoints) {
        int children = 0;
        disc[u] = low[u] = time++;
        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                dfsAP(v, time, disc, low, parent, adj, articulationPoints);
                low[u] = Math.min(low[u], low[v]);
                
                if (parent[u] == -1 && children > 1 && !articulationPoints.contains(u)) {
                    articulationPoints.add(u);
                }
                if (parent[u] != -1 && low[v] >= disc[u] && !articulationPoints.contains(u)) {
                    articulationPoints.add(u);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}