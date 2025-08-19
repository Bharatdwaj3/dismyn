#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int minJumps(int N, int X, int Y, const vector<int>& A) {
    vector<bool> visited(N, false);
    queue<pair<int, int>> q;

    int start = X - 1;
    int end = Y - 1;

    q.push({start, 0});
    visited[start] = true;

    while (!q.empty()) {
        int current = q.front().first;
        int jumps = q.front().second;

        q.pop();

        if (current == end)
            return jumps;

        int step = A[current];

        int reducedStep = step % N;
        int left = (current - reducedStep + N) % N; // a%c = (a+c)%c
        int right = (current + reducedStep) % N;

        if (!visited[right]) {
            visited[right] = true;
            q.push({right, jumps + 1});
        }

        if (!visited[left]) {
            visited[left] = true;
            q.push({left, jumps + 1});
        }
    }

    return -1;
}

int main() {
    int N, X, Y;
    cin >> N >> X >> Y;

    vector<int> A(N);
    for (int i = 0; i < N; ++i) {
        cin >> A[i];
    }

    int result = minJumps(N, X, Y, A);
    cout << result << endl;

    return 0;
}
