#include<bits/stdc++.h>
using namespace std;

void buildTree(int *a, int *tree, int srt, int end, int idx){
    if(srt==end){
        tree[idx]=a[srt];
        return;
    }
    int mid=(srt+end)/2;
    buildTree(a, tree, srt, mid, 2*idx);
    buildTree(a, tree, mid+1, end, 2*idx+1);
    tree[idx]=tree[2*idx]+tree[2*idx+1];
}

int main(){
    int a[]={1,2,3,4,5,6,7,8,8,9};
    int n=sizeof(a)/sizeof(int);
    int *tree=new int[2*n-1];
    buildTree(a, tree, 0, n-1, 1);
    for(int i=1;i<2*n;i++){
        cout<<tree[i]<<" ";
    }
    return 0;
}