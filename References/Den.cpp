#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

const int MAX = 1000005;

class ArraySolutions {
private:
    vector<int> seg;
    vector<int> arr;

    void build(int idx, int low, int high) {
        if(low == high) {
            seg[idx] = arr[low];
            return;
        }
        int mid = (low + high)/2;
        build(2*idx, low, mid);
        build(2*idx+1, mid+1, high);
        seg[idx] = max(seg[2*idx], seg[2*idx+1]);
    }

public:
    ArraySolutions(int size) : seg(4*size), arr(size) {}

    // 1. Maximum sum no adjacent elements
    int maxSumNoAdjacent(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        vector<int> dp(n);
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i++) {
            dp[i] = max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }

    // 2. Maximum sum increasing subsequence
    int maxSumIncreasingSubsequence(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp = nums;
        int maxSum = dp[0];
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = max(dp[i], dp[j] + nums[i]);
                }
            }
            maxSum = max(maxSum, dp[i]);
        }
        return maxSum;
    }

    // 3. Biotonic subsequence length
    int bitonicLength(vector<int>& nums) {
        int n = nums.size();
        vector<int> inc(n, 1), dec(n, 1);
        
        for(int i = 1; i < n; i++) 
            for(int j = 0; j < i; j++) 
                if(nums[i] > nums[j])
                    inc[i] = max(inc[i], inc[j] + 1);
        
        for(int i = n-2; i >= 0; i--)
            for(int j = n-1; j > i; j--)
                if(nums[i] > nums[j])
                    dec[i] = max(dec[i], dec[j] + 1);
        
        int maxLen = 0;
        for(int i = 0; i < n; i++)
            maxLen = max(maxLen, inc[i] + dec[i] - 1);
        return maxLen;
    }

    // 4. Maximum sum with complex decrement
    int maxSumDecrement(int X, int Y, int Z) {
        int sum = 0;
        while(X > 0 || Y > 0 || Z > 0) {
            if(X > 0) { sum += X; X--; }
            if(Y > 0) { sum += Y; Y--; }
            if(Z > 0) { sum += Z; Z--; }
        }
        return sum;
    }

    // 5. Maximum XOR subset sum
    int maxXORSubsetSum(vector<int>& nums) {
        int maxXOR = 0;
        for(int i = 0; i < (1 << nums.size()); i++) {
            int currentXOR = 0;
            for(int j = 0; j < nums.size(); j++) {
                if(i & (1 << j)) {
                    currentXOR ^= nums[j];
                }
            }
            maxXOR = max(maxXOR, currentXOR);
        }
        return maxXOR;
    }
};

int main() {
    vector<int> nums = {1, 2, 3, 4, 5};
    ArraySolutions sol(nums.size());
    
    cout << "Max sum no adjacent: " << sol.maxSumNoAdjacent(nums) << "\n";
    cout << "Max sum increasing subsequence: " << sol.maxSumIncreasingSubsequence(nums) << "\n";
    cout << "Biotonic length: " << sol.bitonicLength(nums) << "\n";
    cout << "Max sum decrement (3,4,5): " << sol.maxSumDecrement(3,4,5) << "\n";
    cout << "Max XOR subset sum: " << sol.maxXORSubsetSum(nums) << "\n";
    
    return 0;
}