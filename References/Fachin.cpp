#include<bits/stdc++.h>
using namespace std;


using ll = long long;

const int MAX = 1000005;
const int MOD = 1e5+7;

int main(){
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    if(n<0){
        cout<<"Invalid input! n mussen be non-negative"<<endl;
        return 1;
    }
    vector<ll> dp(n+1);
    dp[0]=1;
    if(n>=1)
        dp[1]=1;
    for(int i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
        dp[i]%=MOD;
    }
    cout<<"Fibonacci("<<n<<")="<<dp[n]<<endl;
}