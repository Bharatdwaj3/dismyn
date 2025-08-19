// Fenwick Tree (Binary Indexed Tree) in C
#include <stdio.h>
#define MAX 100005

int BIT[MAX], a[MAX];
int n;

void update(int idx, int val)
{
    while (idx <= n)
    {
        BIT[idx] += val;
        idx += idx & -idx;
    }
}

int query(int idx)
{
    int sum = 0;
    while (idx > 0)
    {
        sum += BIT[idx];
        idx -= idx & -idx;
    }
    return sum;
}

int range_sum(int l, int r)
{
    return query(r) - query(l - 1);
}