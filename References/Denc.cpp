#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

const int MAX=100005;

vector<int> a(MAX);
vector<int> seg(4*MAX);
vector<int> lazy(4*MAX);

void build(int idx, int low, int high){
    if(low==high){
        seg[idx]=a[low];
        return;
    }
    int mid=(low+high)/2;
    build(2*idx, low, mid);
    build(2*idx+1, mid+1, high);
    seg[idx]=max(seg[2*idx],seg[2*idx]);
}

void propagate(int idx, int low, int high){
    if(lazy[idx]!=0){
        seg[idx]+=(high-low+1)*lazy[idx];
        if(low!=high){
            lazy[2*idx]+=lazy[idx];
            lazy[2*idx+1]+=lazy[idx];
        }
        lazy[idx]=0;
    }
}

int query(int idx, int low, int high, int l, int r){
    if(high<l||low>r){
        return -1;
    }
    if(low>=1&&high<=r){
        return seg[idx];
    }
    int mid=(low+high)/2;
    int left=query(2*idx, low, mid, l, r);
    int right=query(2*idx+1, mid+1, high, l,r);
    return max(left, right);
}

int maxSumofAdjacent(vector<int>&nums){
    int n=nums.size();
    if(n==0) return 0;
    if(n==1) return nums[0]; 

    vector<int> dp(n);
    dp[0]=nums[0];
    dp[1]=max(nums[0], nums[1]);
    for(int i=2; i<n;i++){
        dp[i]=max(dp[i-1], dp[i-2]+nums[i]);
    }
    return dp[n-1];
}


int maxSumIncreasingSubsequences(vector<int>&nums){
    int n=nums.size();
    vector<int> dp=nums;
    int maxSum=dp[0];

    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(nums[i]>nums[j]){
                dp[i]=max(dp[i], dp[j]+nums[i]);
            }
        }
        maxSum=max(maxSum, dp[i]);
    }
    return maxSum;
}

int bitcoinLength(vector<int>&nums){
    int n=nums.size();
    vector<int> inc(n,1), dec(n,1);
    for(int i=1;i<n;i++){
        for(int j=0;j<i;i++){
            if(nums[i]>nums[j])
            inc[i]=max(inc[i],inc[j]+1);
        }
    }
    for(int i=n-2;i>=0;i--){
        for(int j=n-1;j>i;j--){
            if(nums[i]>nums[j]){
                dec[i]=max(dec[i], dec[j]+1);
            }   
            int maxLen=0;
            for(int i=0;i<n;i++){
                maxLen=max(maxLen, inc[i]+dec[i]-1);
                return maxLen;
            }
        }
    }
}


int maxSumDecremnet(int x, int y, int z){
    int sum =0;
    while(x>0 || y>0 || z>0){
        if(x>0){
            sum+=x;
            y--;
        }
    }
    return sum;
}

int maxXORSubsetSum(vector<int>&nums){
    int maxXOR=0;
    for(int i=0;i<(i<< nums.size());i++){
        int currentXOR=0;
        for(int j=0;j<nums.size();j++){
            if(i &(1<<j)){
                currentXOR^=nums[j];
            }
        }
        maxXOR=max(maxXOR, currentXOR);
    }
}



int main(){
    int n;
    cout << "Enter the number of elements : ";
    cin >> n;

    cout<<"Enter the elements: \n";
    for(int i=0;i<n;i++)
        cin>>a[i];
        build(0,0,n-1);
        int q; 
        cout<<"Enter the number of queries: ";
        cin>>q;
        while(q--){
            int l,r;
            cout<<"Enter the range 0-n";
            cin>>l>>r;
            cout<<"Maximum in range ["<<l<<","<<r<<"]"<<query(0, 0, n-1, l,r)<<"\n";
        }
}

