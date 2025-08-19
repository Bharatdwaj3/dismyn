#include<bits/stdc++.h>
using namespace std;
#define MAX 50005;

int a[MAX];

void buildTree(int *a, int *tree, int *ss, int *se, int idx){
    if(ss=se){
        tree[idx]=a[ss];
        return;
    }
    int mid=(ss+se)/2;
    buildTree(a, tree, ss, mid, 2*idx);
    buildTree(a, tree, mid+1, se, 2*idx+1);
    tree[idx]=tree[2*idx]+tree[2*idx+1];
}

void updateTree1(int *a, int *tree, int ss, int se, int idx, int px){
    if(ss==se){
        a[idx]++;
        tree[idx]++;
    }else{
        int mid=(ss+se)/2;
        if(idx>=ss and idx<=mid)
            updateTree1(a, tree, ss, mid, idx, 2*idx, px);
        else
            updateTree1(a, tree, mid+1, 2*idx, px);
        tree[idx]=tree[2*idx]+tree[2*idx+1];
    }
}

void updateTree(int *a, int *tree, int ss, int ss, int se, int idx , int idx, int px){
    if(ss==se){
        if(a[idx]==0)
            return;
        a[idx]--;
        tree[idx]--;
    }else{
        int mid=(ss+se)/2;
        if(idx>=ss and idx<=mid)
            updateTree2(a, tree, ss, mid, idx, 2*idx, px);
        else
            updateTree2(a, tree, mid+1, se, idx, 2*idx+1, px);
        tree[idx]=tree[2*idx]+tree[2*idx+1];    
    }
}

int query(int *a, int *tree, int *ss, int *se, int l , int r, int idx){
    if(r<ss or l>se)
        return 0;
    if(l<= ss and se <= r )
        return tree[idx];
    int mid=(ss+se)/2;
    int s1=query(a, tree, ss, mid, l, r, 2*idx);
    int s2=query(a, tree, mid+1, se, l, r, 2*idx+1);
    return (s1+s2);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n,q;
    cin>>n>>q;

    for(int i=0;i<n;i++)
        a[i]=0;
    int tree[4*MAX];
    buildTree(a, tree, 1, n, 1);

    while(q--){
        int p;
        cin>>p;
        if(p==1){
            int x;
            cin>>x;
            updateTree1(a, tree, 1, n, x,1,1);
        }
        if (p == 2){
            int x;
            cin >> x;
            updateTree2(a, tree, 1, n, x, 1, 2);
        }if (p == 3)
        {
            int x,y;
            cin >> x>>y;
            updateTree1(a, tree, 1, n, x, 1, 1);
        }
    }
    return 0;
}