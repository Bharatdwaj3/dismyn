#include <bits/stdc++.h>
using namespace std;
#define ll long long

const ll MAXN = 1e5 + 5;

vector<ll> parent(MAXN), rank_(MAXN);
vector<set<ll>> component_nodes(MAXN);


ll find(ll x) {
    if (parent[x] != x)
        parent[x] = find(parent[x]);
    return parent[x];
}


void unite(ll x, ll y) {
    ll rx = find(x);
    ll ry = find(y);
    if (rx == ry) return;

    if (rank_[rx] < rank_[ry]) swap(rx, ry);

    parent[ry] = rx;
    rank_[rx] += rank_[ry];

    
    if (component_nodes[rx].size() < component_nodes[ry].size())
        swap(component_nodes[rx], component_nodes[ry]);

    component_nodes[rx].insert(component_nodes[ry].begin(), component_nodes[ry].end());
    component_nodes[ry].clear();
}


ll compute_beauty(const set<ll>& nodes) {
    if (nodes.empty()) return 0;
    ll prev = -2, beauty = 0;
    for (ll node : nodes) {
        if (node != prev + 1)
            beauty++;
        prev = node;
    }
    return beauty;
}

int main() {
    ll n, q, t;
    cin >> n >> q >> t;

    for (ll i = 1; i <= n; ++i) {
        parent[i] = i;
        rank_[i] = 1;
        component_nodes[i].insert(i);
    }

    ll answer_sum = 0;

    for (ll i = 0; i < q; ++i) {
        ll type, u, v;
        cin >> type >> u >> v;

        if (type == 1) {
            unite(u, v);
        } else if (type == 2) {
            ll root = find(u);
            ll beauty = compute_beauty(component_nodes[root]);
            answer_sum += beauty;
        }
    }

    cout << answer_sum << "\n";
    return 0;
}
