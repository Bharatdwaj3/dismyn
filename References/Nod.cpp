#include<iostream>
#include<vector>
#include<algorithm>

#define ll long long;

using namespace std;

ll maxGoodSubArraySum(const vector<ll>&a, ll k){
    unordered_map<ll, ll> freq;
    ll n=A.size(), left=0, currentSum=0, maxSum=0;

    dequeue<ll> window;
}