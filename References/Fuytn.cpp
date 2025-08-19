#include<bits/stdc++.h>
using namespace std;
using ll = long long;

const ll MAX =100005;
const int MOD=1e5+7;

int solve(int n, const vector<int>&arr){
    if(n==0)
        return 0;
    if(n==1)
        return arr[0];
    int prev = arr[0];
    int prev1 = 0;

    for(int i=1;i<n;i++){
        int pick=arr[i];
        if(i>1)
            pick+=prev1;
        int nonPick=prev;
        int cur_i=max(pick, nonPick);
        prev1=prev;
        prev=cur_i;
    }
    return prev;
}

int main(){
    int n;
    cout << "Enter the number of elements in the array: ";
    cin>>n;
    if(n<=0){
        cout<<"Array must have at least one element: "<<endl;
        return 1;
    }
    vector<int> arr(n);
    cout<<"Enter the elements if the array: \n";
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int result=solve(n, arr);
    cout<<"Maximum non-adjacent sum: "<<result<<endl;
    return 0;
}