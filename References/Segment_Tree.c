// Segment Tree (Range Max Query) in C
#include <stdio.h>
#define MAX 100005

int a[MAX], seg[4 * MAX];

int max(int a, int b)
{
    return a > b ? a : b;
}

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
    seg[idx] = max(seg[2 * idx + 1], seg[2 * idx + 2]);
}

int query(int idx, int low, int high, int l, int r)
{
    if (high < l || low > r)
        return -1; // Assuming all values are non-negative 
    if (low >= l && high <= r)
        return seg[idx];
    int mid = (low + high) / 2;
    int left = query(2 * idx + 1, low, mid, l, r);
    int right = query(2 * idx + 2, mid + 1, high, l, r);
    return max(left, right);
}