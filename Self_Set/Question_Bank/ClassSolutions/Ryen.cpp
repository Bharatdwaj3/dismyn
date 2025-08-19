#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int minJumps(int N, int X, int Y, const vector<int>&A){
    vector<bool>visited(N, false);
    queue<pair<int, int>>q;

    int srt = X-1;
    int end = Y-1;

    q.push({srt, 0});
    visited[srt]=true;

    while(!q.empty()){
        int curr=q.front().first;
        int jumps=q.front().second;
        q.pop();
        if(curr==end)
            return jumps;
        int step=A[curr];

        int reducedStep=step%N;
        int left=(curr-reducedStep+N)%N;
        int right=(curr+reducedStep)%N;
    
        if(!visited[right]){
            visited[right]=true;
            q.push({right, jumps+1});
        }
        if(!visited[left]){
            visited[left]=true;
            q.push({left, jumps+1});
        }
    }
    return -1;
}

int main(){
    int N, X, Y;
    cin >> N >> X >> Y;
    
    vector<int> A(N);

    for(int i=0;i<N;i++){
        cin>>A[i];
    }

    int result = minJumps(N, X, Y, A);
    cout << result << endl;

    return 0;
}