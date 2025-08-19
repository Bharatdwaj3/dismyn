#include<bits/stdc++.h>

using namespace std;

using ll = long long;

const ll MAX = 1000005;
const int MOD = 1e5+7;

void printSS(int idx,vector<int>&ds, int cSum, int tSum, int arr[], int n){
    if(idx==n){
        if(cSum==tSum){
            for(int x:ds)
            cout<<endl;
        }
        return ;
    }
    ds.push_back(arr[idx]);
    cSum+=arr[idx];
    printSS(idx+,)
}

int main(){



    return 0;
}