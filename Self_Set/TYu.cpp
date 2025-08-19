#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int maxCandies(vector<int>&prices, int vouchers){
    sort(prices.begin(), prices.end());

    int total=0;
    for(int i=0;i<prices.size()&&vouchers>=prices[i];i++){
        vouchers-=prices[i];
        total++;
    }
    return total;
}

int main(){
    vector<int> prices={12,3,4,5};
    int vouchers=10;

    cout<<maxCandies(prices, vouchers)<<endl;
    return 0;
}

