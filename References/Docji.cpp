#include<iostream>
#include<vector>
#include<algorithm>
#include<unordered_map>
#include<set>
#include<queue>
using namespace std;

class ArrayOperations {
private:
    const int MAX = 1000005;
    const int MOD = 1e9 + 7;
    vector<int> seg;
    vector<int> lazy;

    void buildSegTree(vector<int>& arr, int idx, int low, int high) {
        if(low == high) {
            seg[idx] = arr[low];
            return;
        }
        int mid = (low + high) >> 1;
        buildSegTree(arr, 2*idx, low, mid);
        buildSegTree(arr, 2*idx+1, mid+1, high);
        seg[idx] = max(seg[2*idx], seg[2*idx+1]);
    }

public:
    // 1. Count subarrays with even sum starting with odd
    int countEvenSumOddStart(vector<int>& arr) {
        int count = 0, n = arr.size();
        for(int i = 0; i < n; i++) {
            if(arr[i] % 2 == 1) {
                int sum = 0;
                for(int j = i; j < n; j++) {
                    sum += arr[j];
                    if(sum % 2 == 0) count++;
                }
            }
        }
        return count;
    }

    // 2. Maximum sum no adjacent
    int maxSumNoAdjacent(vector<int>& arr) {
        int n = arr.size();
        if(n == 0) return 0;
        if(n == 1) return arr[0];
        vector<int> dp(n);
        dp[0] = arr[0];
        dp[1] = max(arr[0], arr[1]);
        for(int i = 2; i < n; i++)
            dp[i] = max(dp[i-1], dp[i-2] + arr[i]);
        return dp[n-1];
    }

    // 3. Range increment operations
    void rangeUpdate(int idx, int low, int high, int l, int r, int val) {
        if(lazy[idx] != 0) {
            seg[idx] += lazy[idx];
            if(low != high) {
                lazy[2*idx] += lazy[idx];
                lazy[2*idx+1] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        if(low > r || high < l) return;
        if(l <= low && high <= r) {
            seg[idx] += val;
            if(low != high) {
                lazy[2*idx] += val;
                lazy[2*idx+1] += val;
            }
            return;
        }
        int mid = (low + high) >> 1;
        rangeUpdate(2*idx, low, mid, l, r, val);
        rangeUpdate(2*idx+1, mid+1, high, l, r, val);
        seg[idx] = max(seg[2*idx], seg[2*idx+1]);
    }

    // 4. XOR range query
    int xorQuery(int idx, int low, int high, int l, int r) {
        if(low > r || high < l) return 0;
        if(l <= low && high <= r) return seg[idx];
        int mid = (low + high) >> 1;
        return xorQuery(2*idx, low, mid, l, r) ^ 
               xorQuery(2*idx+1, mid+1, high, l, r);
    }

    // 5. Count increasing triplets
    int countIncreasingTriplets(vector<int>& arr) {
        int n = arr.size(), count = 0;
        for(int i = 0; i < n-2; i++) {
            for(int j = i+1; j < n-1; j++) {
                if(arr[j] > arr[i]) {
                    for(int k = j+1; k < n; k++) {
                        if(arr[k] > arr[j]) count++;
                    }
                }
            }
        }
        return count;
    }

    // 6. Subarray sum modulo
    int subarraySumModulo(vector<int>& arr) {
        long long result = 0;
        int n = arr.size();
        for(int i = 0; i < n; i++) {
            long long sum = 0;
            for(int j = i; j < n; j++) {
                sum = (sum + arr[j]) % MOD;
                result = (result + sum) % MOD;
            }
        }
        return result;
    }

    // 7. K-th smallest unique
    int kthSmallestUnique(vector<int>& arr, int k) {
        set<int> s(arr.begin(), arr.end());
        auto it = s.begin();
        advance(it, k-1);
        return *it;
    }

    // 8. Longest arithmetic subarray
    int longestArithmeticSubarray(vector<int>& arr) {
        if(arr.size() < 2) return arr.size();
        int maxLen = 2, currLen = 2;
        int currDiff = arr[1] - arr[0];
        for(int i = 2; i < arr.size(); i++) {
            if(arr[i] - arr[i-1] == currDiff)
                currLen++;
            else {
                currDiff = arr[i] - arr[i-1];
                currLen = 2;
            }
            maxLen = max(maxLen, currLen);
        }
        return maxLen;
    }

    // 9. Maximum sum with k distinct
    int maxSumKDistinct(vector<int>& arr, int k) {
        int maxSum = 0, currSum = 0;
        unordered_map<int, int> freq;
        int left = 0;
        for(int right = 0; right < arr.size(); right++) {
            freq[arr[right]]++;
            currSum += arr[right];
            while(freq.size() > k) {
                freq[arr[left]]--;
                currSum -= arr[left];
                if(freq[arr[left]] == 0)
                    freq.erase(arr[left]);
                left++;
            }
            if(freq.size() == k)
                maxSum = max(maxSum, currSum);
        }
        return maxSum;
    }

    // 10. Lexicographically smallest with k-distance swap
    vector<int> lexSmallestWithKSwap(vector<int> arr, int k) {
        int n = arr.size();
        for(int i = 0; i < n; i++) {
            int pos = i;
            for(int j = i+1; j < min(n, i+k+1); j++) {
                if(arr[j] < arr[pos])
                    pos = j;
            }
            for(int j = pos; j > i; j--)
                swap(arr[j], arr[j-1]);
        }
        return arr;
    }
};

int main() {
    ArrayOperations ops;
    vector<int> arr = {1, 2, 3, 4, 5};
    int k = 2;
    
    cout << "Even sum subarrays starting with odd: " << ops.countEvenSumOddStart(arr) << endl;
    cout << "Max sum no adjacent: " << ops.maxSumNoAdjacent(arr) << endl;
    cout << "Increasing triplets: " << ops.countIncreasingTriplets(arr) << endl;
    cout << "Subarray sum modulo: " << ops.subarraySumModulo(arr) << endl;
    cout << "Kth smallest unique: " << ops.kthSmallestUnique(arr, k) << endl;
    cout << "Longest arithmetic subarray: " << ops.longestArithmeticSubarray(arr) << endl;
    cout << "Max sum with k distinct: " << ops.maxSumKDistinct(arr, k) << endl;
    
    return 0;
}