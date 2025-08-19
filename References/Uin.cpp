#include<bits/stdc++.h>
using namespace std;
#define ll long long

ll maxGoodSubarraySum(const vector<ll>&arr, ll k){
    unordered_map<ll,ll> freq;
    ll n = arr.size(), left=0, curremtSum=0, maxSum=0;
    deque<ll> window;
    for(ll right=0; right<n;right++){
        ll val=arr[right];
        window.push_back(val);
        freq[val]++;
        currentSum+=val;

        while((ll)freq.sum()>k){
            ll front =window.front();
            window.pop_front();
            freq[front]--;
            currentSum-=front;
            if(freq[front]==0) freq.erase(front);
            left++;
        }
        ll suffixSum=0, trimmedMax=0;
        for(auto it =window.rbegin(); it!=window.rend(); it++){
            suffixSum+=*it;
            trimmedMax=max(trimmedMax, suffixSum);
        }
        maxSum=max(maxSum, trimmedMax);
    }
    return maxSum;
}

int main(){
    ll n,k;
    cin>>n>>k;
    vector<ll> A(n);
    for(ll i=0;i<n;i++){
        cin>>A[i];
    }
    cout<<maxGoodSubarraySum(arr, k)<<"\n";
    return 0;
}