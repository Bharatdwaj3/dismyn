#include<iostream>
#include<vector>
#include<algorithm>
#include<unordered_map>
#include<set>
#include<queue>

using namespace std;

const int MAX =1000005;
const int MOD =1e9+7;

vector<int> seg;
vector<int> lazy;

void buildSegTree(vector<int>&arr, int idx, int low, int high){
    if(low==high){
        seg[idx]=arr[low];
        return;
    }
    int mid=(low+high)>>1;
    buildSegTree(arr, 2*idx, low, mid);
    buildSegTree(arr, 2*idx+1, mid+1, high);
    seg[idx]=max(seg[2*idx],seg[2*idx+1]);
}

int countEvenOddStart(vector<int>&arr){
    int count=0, n=arr.size();
    for(int i=0;i<n;i++){
        if(arr[i]%2==1){
            int sum=0;
            for(int j=i;j<n;j++){
                sum += arr[j];
                if(sum %2== 0)
                    count++;
            }
        }
    }
    return count;
}

int maxSumNoAdjacents(vector<int>&arr){
    int n=arr.size();
    if(n==0) return 0;
    if (n==1) return arr[0];

    vector<int> dp(n);
    dp[0] = arr[0];
    dp[1] = max(arr[0], arr[1]);

    for(int i=2;i<n;i++){
        dp[i]=max(dp[i-1],dp[i-2]+arr[i]);
    }
    return dp[n-1];
}

int xorQuery(int idx, int low, int high, int l, int r){
    if(low>r || high<l)
        return 0;
    if(l<=low && high <=r)
        return seg[idx];
        int mid=(low+high)>>1;
            return xorQuery(2*idx, mid, high, l,r)^
                            (2*idx+1, mid+1, high, l,r);
}

int countIncreasingTriplets(vector<int>&arr){
    int n=arr.size(), count=0;
    for(int i=0;i<n-2;i++){
        for(int j=i+1;j<n-1;j++){
            if(arr[j]>arr[i]){
                for (int k = j + 1; j < n; k++)
                {
                    if(arr[k]>arr[j])
                    count++;
                }
            }
        }
    }
    return count;
}

int subarraySumModulo(vector<int>&arr){
    long long result=0;
    int n=arr.size();
    for(int i=0;i<n;i++){
        long long sum=0;
        for(int j=i;j<n;j++){
            sum=(sum+arr[j])%MOD;
            result=(result+sum)%MOD;
        }
    }
    return result;
}

int KthSmallestUnique(vector<int>&arr, int k){
    set<int> s(arr.begin(), arr.end());
    auto it = s.begin();
    advance(it, k-1);
    return *it;
}


int longestArithmeticSubarray(vector<int>&arr){
    if(arr.size()<2)
        return arr.size();
    int maxLen=2, currLen=2;
    int currDiff=arr[1]-arr[0];
    for(int i=2;i<arr.size();i++){
        if(arr[i]-arr[i-1]==currDiff)
            currLen++;
        else{
            currDiff=arr[i]-arr[i-1];
            currLen=2;
        }
        maxLen=max(maxLen, currLen);
    }
    return maxLen;
}

int maxSumKDistinct(vector<int>&arr, int k){
    int maxSum=0, currSum=0;
    unordered_map<int, int>freq;
    int left=0;
    for(int right=0;right<arr.size();right++){
        freq[arr[right]]++;
        currSum+=arr[right];
        while(freq.size()>k){
            currSum-=arr[left];
            if(freq[arr[left]]==0)
                freq.erase(arr[left]);
            left++;
        }
        if(freq.size()==k)
            maxSum=max(maxSum, currSum);
    }
    return maxSum;
}

int maxSumIncreasingSubSequence(vector<int>&nums){
    int n=nums.size();
    vector<int>dp=nums;
    int maxSum=dp[0];
    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(nums[i]>nums[j]){
                dp[i] = max(dp[i], dp[j] + nums[i]);
            }
        }
        maxSum = max(maxSum, dp[i]);
    }
    return maxSum;
}

int biotonicLength(vector<int>& nums){
    int n=nums.size();
    vector<int> incr(n,1),desc(n,1);
    for(int i=1;i<n;i++)
        for(int j=0;j<i;j++)
            if(nums[i]>nums[j])
                incr[i]=max(incr[i], incr[j]+1);
    for(int i=n-2;i>=0;i--)
        for(int j=n-1;j>i;j++)
            if(nums[i]>nums[j])
                desc[i]=max(desc[i],desc[j]+1);
    int maxLen=0;
    for(int i=0;i<n;i++)
        maxLen=max(maxLen, incr[i]+desc[i]-1);
        return maxLen;

    
}

int main(){

}