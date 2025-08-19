#include <iostream>
#include <queue>
#include <unordered_set>

using namespace std;

int minMovesToOne(int N) {
    if (N == 1) return 0;

    queue<pair<int, int>> q; // {current_number, steps}
    unordered_set<int> visited;

    q.push({N, 0});
    visited.insert(N);

    while (!q.empty()) {
        int current = q.front().first;
        int steps = q.front().second;
        q.pop();

        // Try possible operations
        if (current % 3 == 0) {
            int next = current / 3;
            if (next == 1) return steps + 1;
            if (!visited.count(next)) {
                visited.insert(next);
                q.push({next, steps + 1});
            }
        }

        if (current % 2 == 0) {
            int next = current / 2;
            if (next == 1) return steps + 1;
            if (!visited.count(next)) {
                visited.insert(next);
                q.push({next, steps + 1});
            }
        }

        int next = current - 1;
        if (next == 1) return steps + 1;
        if (!visited.count(next)) {
            visited.insert(next);
            q.push({next, steps + 1});
        }
    }

    return -1; // This shouldn't happen for N >= 1
}

int main() {
    int N;
    cin >> N;
    cout << minMovesToOne(N) << endl;
    return 0;
}
