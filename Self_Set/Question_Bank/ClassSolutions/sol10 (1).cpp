
#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>
using namespace std;

const int MAX_BITS = 17; // log2(10^5) approx 16.6, so 17 bits are enough

// Function to insert a number into the basis
void insert_vector(std::vector<int>& basis, int mask) {
    for (int i = MAX_BITS - 1; i >= 0; --i) {
        if (!((mask >> i) & 1)) continue;
        if (!basis[i]) {
            basis[i] = mask;
            return;
        }
        mask ^= basis[i];
    }
}

// Function to get the maximum XOR sum with a given number using the basis
int get_max_xor(const std::vector<int>& basis, int mask) {
    for (int i = MAX_BITS - 1; i >= 0; --i) {
        mask = max(mask, mask ^ basis[i]);
    }
    return mask;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int N, K;
    cin >> N >> K;

    vector<int> A(N);
    for (int i = 0; i < N; ++i) {
        cin >> A[i];
    }

    // dp[i] will store the maximum amazingness for the prefix A[0...i-1]
    vector<long long> dp(N + 1, 0);

    // Iterate through all possible ending positions of subarrays
    for (int i = 1; i <= N; ++i) {
        vector<int> current_basis(MAX_BITS, 0);
        int current_max_xor = 0;

        // Iterate through all possible starting positions for the last subarray
        // The last subarray must have length at least K
        for (int j = i - 1; j >= 0; --j) {
            insert_vector(current_basis, A[j]);
            current_max_xor = get_max_xor(current_basis, 0);

            // If the current subarray A[j...i-1] has length at least K
            if (i - j >= K) {
                dp[i] = max(dp[i], dp[j] + current_max_xor);
            }
        }
    }

    cout << dp[N] << endl;

    return 0;
}
