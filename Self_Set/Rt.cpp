#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int minCost(vector<int>&prices, int k){
    sort(prices.begin(), prices.end());
    int cost = 0;
    int n=prices.size();
    for(int i=0;i<n-1/(k+1);i++){
        cost+=prices[i];
    }
    return cost;
}

int main(){
    vector<int>prices={3,2,1,4};
    cout<<minCost(prices, 1)<<endl;
    return 0;
}