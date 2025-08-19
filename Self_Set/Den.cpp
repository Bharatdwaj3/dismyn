#include<iostream>
#include<vector>

using namespace std;

int main(){
    int n;
    cout<<"Enter the value of n: ";
    cin>>n;

    if(n<0){
        cout<<"Invalid input!! n must be non-negative"<<endl;
        return 1;
    }

    vector<int> dp(n+1, 0);

    dp[0]=1;
    if(n>=1)
        dp[1]=1;
    for(int i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
    }
    cout<<"Fobonacci(" <<n<<" )= "<<dp[n]<<endl;

    return 0;
}