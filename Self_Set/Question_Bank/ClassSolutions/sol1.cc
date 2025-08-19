#include <bits/stdc++.h>
using namespace std;
#define ll long long
const ll MOD = 1e9 + 7;

ll BLOCK;

vector<ll> A, blockSum;

void buildBlocks(ll n) {
    BLOCK = sqrt(n);
    ll numBlocks = (n + BLOCK - 1) / BLOCK;
    blockSum.assign(numBlocks, 0);
    for (ll i = 0; i < n; ++i) {
        blockSum[i / BLOCK] += A[i];
    }
}

void update(ll l, ll r) {
    ll val = A[l];
    for (ll i = l; i <= r; ++i) {
        ll blockIdx = i / BLOCK;
        blockSum[blockIdx] -= A[i];
        A[i] = ((i - l + 1) * val) % MOD;
        blockSum[blockIdx] += A[i];
    }
}

ll query(ll l, ll r) {
    ll sum = 0;
    while (l <= r) {
        if (l % BLOCK == 0 && l + BLOCK - 1 <= r) {
            sum = (sum + blockSum[l / BLOCK]) % MOD;
            l += BLOCK;
        } else {
            sum = (sum + A[l]) % MOD;
            l++;
        }
    }
    return sum;
}

int main() {

    ll n;
    cin >> n;
    A.resize(n);
    for (ll i = 0; i < n; ++i) cin >> A[i];

    buildBlocks(n);

    ll q;
    cin >> q;
    ll total = 0;

    while (q--) {
        ll type, l, r;
        cin >> type >> l >> r;
        if (type == 1) {
            update(l, r);
        } else if (type == 2) {
            total = (total + query(l, r)) % MOD;
        }
    }

    cout << total << "\n";
    return 0;
}
