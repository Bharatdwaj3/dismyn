#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(){
    int E, N, count=0;
    cin >> E >> N;
    vector<int> exer(N);

    for(int i=0;i<N;i++)
    cin>>exer[i];
    sort(exer.rbegin(), exer.rend());
    for(int i=0;i<N;i++){
        if(E<=0)
            break;
        E -= exer[i];
        count++;
        if(E<=0) break;
        E-= exer[i];
        count++;
    }
    cout << (E<=0?count:-1)<<endl; 

}