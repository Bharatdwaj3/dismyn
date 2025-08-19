#include<iostream>
#include<queue>
#include<unordered_set>

using namespace std;

int minMovesTOOne(int N){
    if(N==1)
    return 0;

    queue<pair<int, int>>q;
    unordered_set<int>visited;

    q.push({N, 0});
    visited.insert(N);

    while(!q.empty()){
        int current=q.front().first;
        int steps=q.front().second;
        q.pop();

        if(current % 3 == 0){
            int next=current/3;
            if(next==1) return steps+1;
            if(!visited.count(next)){
                visited.insert(next);
                q.push({next, steps+1});
            }
        }
        if(current%2==0){
            int next=current/2;
            if(next==1)
                return steps+1;
            if(!visited.count(next)){
                q.push({next, steps+1});
            }
        }

        int next=current-1;
        if(next==1) return steps+1;
        if(!visited.count(next)){
            visited.insert(next);
            q.push({next, steps+1});
        }
    }
}

int main(){
    int N;
    cin>>N;
    cout<<minMovesTOOne(N)<<endl;
    return 0;
}