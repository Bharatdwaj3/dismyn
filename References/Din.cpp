#include <iostream>
#include <vector>
#include <algorithm> 
using namespace std;

const int MAX = 100005;

vector<int> a(MAX);
vector<int> seg(4 * MAX);

// Builds the segment tree
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

// Queries the segment tree for the maximum in the range [l, r]
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

// Example usage
int main()
{
    int n;
    cout << "Enter number of elements: ";
    cin >> n;

    cout << "Enter the elements:\n";
    for (int i = 0; i < n; ++i)
        cin >> a[i];

    build(0, 0, n - 1);

    int q;
    cout << "Enter number of queries: ";
    cin >> q;

    while (q--)
    {
        int l, r;
        cout << "Enter range (0-based index): ";
        cin >> l >> r;
        cout << "Maximum in range [" << l << ", " << r << "] = " << query(0, 0, n - 1, l, r) << "\n";
    }

    return 0;
}
