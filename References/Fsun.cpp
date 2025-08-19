#include<bits/stdc++.h>
using namespace std;


using ll = long long;

const int MAX = 1000005;
const int MOD = 1e5+7;

int absDiff(int a, int b){
    return abs(a-b);
}

int solveUtil(int n, const vector<int>&height, vector<int>&dp, int k){
    dp[0]=0;
    for(int i=1;i<n;i++){
        int mmSteps=INT_MAX;
        for(int j=1;j<=k;j++){
            if(i-j>=0){
                int jump=dp[i-j]+absDiff(height[i], height[i-j]);
                mmSteps=min(mmSteps, jump);
            }
        }
        dp[i]=mmSteps;
    }
    return dp[n-1];
}

int solve(int n, const vector<int>&height, int k){
    vector<int> dp(n, 0);
    return solveUtil(n, height, dp, k);
}

int main(){
    int n,k;
    cout<<"Enter the numbe of stones: ";
    cin>>n;

    vector<int> height(n);
    cout<< "Enter the height of the stones\n";
    for(int i=0;i<n;i++){
        cin>>height[i];
    }
    cout<<"Enter the max number of jumps(k): ";
    cin>>k;

    int minCost=solve(n, height, k);
    cout<<"Minimum energy required: "<<minCost<<endl;

    return 0;
}