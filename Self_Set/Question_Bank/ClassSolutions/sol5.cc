#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int minInvasionTime(int N, int M, vector<string>& grid) {
    queue<pair<int, int>> q;
    vector<vector<int>> time(N, vector<int>(M, -1));
    int enemyCount = 0;

    // Directions: up, down, left, right
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    // Step 1: Enqueue all 'A' cells (starting points)
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            if (grid[i][j] == 'A') {
                q.push(make_pair(i, j));
                time[i][j] = 0;
            } else if (grid[i][j] == 'E') {
                enemyCount++;
            }
        }
    }

    // Step 2: BFS to invade adjacent 'E' cells
    int maxTime = 0;
    while (!q.empty()) {
        pair<int, int> current = q.front();
        q.pop();
        int x = current.first;
        int y = current.second;

        for (int d = 0; d < 4; ++d) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (grid[nx][ny] == 'E') {
                    grid[nx][ny] = 'A';
                    time[nx][ny] = time[x][y] + 1;
                    maxTime = time[nx][ny];
                    q.push(make_pair(nx, ny));
                    enemyCount--;
                }
            }
        }
    }

    if (enemyCount > 0) return -1;
    return maxTime;
}

int main() {
    int N, M;
    cin >> N >> M;
    vector<string> grid(N);
    for (int i = 0; i < N; ++i) {
        cin >> grid[i];
    }
    cout << minInvasionTime(N, M, grid) << endl;
    return 0;
}
