#include <bits/stdc++.h>
using namespace std;

const int MAX_A = 1005;
const int INF = 1e9;

int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    for (int& x : A) cin >> x;

    vector<int> dp(n + 1, 0); // dp[i] = max expert number for A[0..i-1]

    for (int i = 1; i <= n; ++i) {
        vector<int> freq(MAX_A, 0);
        vector<bool> seen(MAX_A, false);
        int distinct = 0;
        int maxx = 0;

        // Form a team ending at index i-1, starting from j
        for (int j = i; j >= 1; --j) {
            int val = A[j - 1];
            freq[val]++;
            if (!seen[val]) {
                seen[val] = true;
                distinct++;
                // Update MaXx
                while (seen[maxx]) maxx++;
            }

            dp[i] = max(dp[i], dp[j - 1] + maxx);
        }
    }

    cout << dp[n] << '\n';
    return 0;
}
