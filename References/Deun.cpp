#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

const int MAX = 1000005;

vector<int> arr(MAX);
vector<int> seg(4*MAX);
vector<int> lazy(4*MAX);


void build(int idx, int low , int high){
    if(low==high){
        seg[idx]=arr[low];
        return;
    }
    int mid=(low+high)/2;
    build(2*idx, low, mid);
    build(2*idx+1, mid+1, high);
}

void propagate(int idx, int low, int high){
    if(lazy[idx]!=0){
        seg[idx]+=(high-low+1)*lazy[idx];
        if(low!=high){
            lazy[2*idx]+=lazy[idx];
            lazy[2*idx+1]+=lazy[idx];
        }
        lazy[idx]=0;
    }
}


void update(int idx, int low, int high, int l, int r, int val){
    propagate(idx, low, high);
    if(high<l||low>r)
        return;
    if(low>=l && high <=r){
        lazy[idx]+=val;
        propagate(idx, low, high);
        return;
    }
    int mid=(low+high)/2;
    update(2*idx, low, mid, l, r, val);
    update(2*idx+1, mid+1, high, l, r, val);
    seg[idx]=seg[2*idx]+seg[2*idx+1];
}

int query(int idx, int low, int high, int l, int r){
    propagate(idx, low, high);
    if(high<l||low>r)
        return 0;
    if(low>=l && high <=r)
        return seg[idx];
    int mid=(low+high)/2;
    int left=query(2*idx, low, mid, l, r);
    int right=query(2*idx+1, mid+1, high,l,r);
}

int main(){

}