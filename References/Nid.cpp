#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++)
        cin>>arr[i];
    int prev=arr[0], sum=0, maxVal=0;
    for(int i=1;i<n;i++){
        if(arr[i]<=prev)
        prev=arr[i];
        else{
            sum=arr[i]-(prev-1);
            int k=floor(sqrt(sum+2));
            if(k*k==sum+2) sum++;
                prev--;
                maxVal=max(maxVal, sum);
        }
    }
    cout<< ceil(sqrt(maxVal))<<endl;
}