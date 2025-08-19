#include<iostream>
#include<unordered_map>
#include<vector>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int i=0;i<n;i++)
    cin >>arr[i];
    unordered_map<int, int>m ;
    if(n & 1){
        int mid=n/2;
        for(int i=0;i<mid;i++){
            m[arr[i]-i]++;
        }
        for(int i=mid;i<n;i++){
            m[arr[i]+i-n+1]++;
        }
    }else{
        int mid1=n/2-1, mid2=n/2;
        for(int i=0;i<=mid1;i++)
            m[arr[i]-i]++;
        for(int i=mid2;i<n;i++)
            m[arr[i]-n+1]++;
    }
    int maxFreq=0;
    for(auto& it:m)
        maxFreq=max(maxFreq, it.second);
    cout<<(n-maxFreq)<<endl;
}