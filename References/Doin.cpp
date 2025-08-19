#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

const int MAX=1000005;

vector<int> a(MAX);
vector<int> seg(4*MAX);

void build(int idx, int low, int high){
    if(low==high){
        seg[idx]=a[low];
        return;
    }
    int mid=(low+high)/2;
    build(2*idx, low, mid);
    build(2*idx+1, mid+1,high);
    seg[idx]=max(seg[2*idx],seg[2*idx+1]);
}

int query(int idx, int low, int high, int l, int r){
    if(high<l||low>r)
    return -1;
    if(low>=1 && high <=r)
        return seg[idx];
    int mid=(low+high)/2;
    int left=query(2*idx, low, mid, l, r);
    int right=query(2*idx+1, mid+1, high, l, r);
    return max(left, right);
}

int main(){
    int n;
    cout<<"Enter the number of elements: ";
    cin>>n;

    cout<<"Enter the elements: \n";
    for(int i=0;i<n;i++)
        cin>>a[i];
    build(0, 0, n-1);
    int q;
    cout<<"Enter the numebr of queries: ";
    cin>>q;
    while(q--){
        int l, r;
        cout<<"Enter the range 0-n";
        cin>>l>>r;
        cout<<"Maximum in range [ "<<l<<","<<r<<"]"<<query(0,0,n-1,l,r)<<"\n";
    }
}