// Segment Tree with Lazy Propagation (Range Sum)
#include <stdio.h>
#define MAX 100005

int a[MAX], seg[4 * MAX], lazy[4 * MAX];

void build(int idx, int low, int high)
{
    if (low == high)
    {
        seg[idx] = a[low];
        return;
    }
    int mid = (low + high) / 2;
    build(2 * idx + 1, low, mid);
    build(2 * idx + 2, mid + 1, high);
    seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
}

void propagate(int idx, int low, int high)
{
    if (lazy[idx] != 0)
    {
        seg[idx] += (high - low + 1) * lazy[idx];
        if (low != high)
        {
            lazy[2 * idx + 1] += lazy[idx];
            lazy[2 * idx + 2] += lazy[idx];
        }
        lazy[idx] = 0;
    }
}

void update(int idx, int low, int high, int l, int r, int val)
{
    propagate(idx, low, high);
    if (high < l || low > r)
        return;
    if (low >= l && high <= r)
    {
        lazy[idx] += val;
        propagate(idx, low, high);
        return;
    }
    int mid = (low + high) / 2;
    update(2 * idx + 1, low, mid, l, r, val);
    update(2 * idx + 2, mid + 1, high, l, r, val);
    seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
}

int query(int idx, int low, int high, int l, int r)
{
    propagate(idx, low, high);
    if (high < l || low > r)
        return 0;
    if (low >= l && high <= r)
        return seg[idx];
    int mid = (low + high) / 2;
    int left = query(2 * idx + 1, low, mid, l, r);
    int right = query(2 * idx + 2, mid + 1, high, l, r);
    return left + right;
}