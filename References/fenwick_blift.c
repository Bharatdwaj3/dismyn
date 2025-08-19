// Fenwick Tree + Binary Lifting in C
// Note: These two are conceptually separate but shown together here for demonstration

#include <stdio.h>
#include <string.h>
#include <math.h>

#define MAXN 100005
#define LOG 17  // Because 2^17 > 1e5

// -------- Fenwick Tree (Binary Indexed Tree) --------
int BIT[MAXN], a[MAXN];
int n;

void fenwick_update(int idx, int val) {
    while (idx <= n) {
        BIT[idx] += val;
        idx += idx & -idx;
    }
}

int fenwick_query(int idx) {
    int sum = 0;
    while (idx > 0) {
        sum += BIT[idx];
        idx -= idx & -idx;
    }
    return sum;
}

int fenwick_range_query(int l, int r) {
    return fenwick_query(r) - fenwick_query(l - 1);
}

// -------- Binary Lifting for Tree Ancestors --------
int up[MAXN][LOG];  // up[v][j] = 2^j-th ancestor of v
int depth[MAXN];
int parent[MAXN];
int adj[MAXN][LOG];  // simplistic static adjacency, for demo

void dfs(int v, int p) {
    up[v][0] = p;
    for (int i = 1; i < LOG; i++) {
        if (up[v][i - 1] != -1)
            up[v][i] = up[up[v][i - 1]][i - 1];
        else
            up[v][i] = -1;
    }
    for (int i = 0; i < adj[v][0]; i++) {
        int u = adj[v][i + 1];
        if (u != p) {
            depth[u] = depth[v] + 1;
            dfs(u, v);
        }
    }
}

int lift(int node, int k) {
    for (int i = 0; i < LOG; i++) {
        if (k & (1 << i)) {
            node = up[node][i];
            if (node == -1) break;
        }
    }
    return node;
}

int lca(int u, int v) {
    if (depth[u] < depth[v]) {
        int temp = u;
        u = v;
        v = temp;
    }

    u = lift(u, depth[u] - depth[v]);
    if (u == v) return u;

    for (int i = LOG - 1; i >= 0; i--) {
        if (up[u][i] != -1 && up[u][i] != up[v][i]) {
            u = up[u][i];
            v = up[v][i];
        }
    }
    return up[u][0];
}
