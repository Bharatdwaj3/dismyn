#include<iostream>
#include<vector>
using namespace std;

int gcd(int a, int b){
    return b==0?a:gcd(b,a%b);
}

int main(){
    string s;
    cin >> s;
    vector<int> freq(26, 0);
    for(char c: s)
        freq[c-'c']++;
    int ans=0;
    for(int f: freq){
        if(f) ans = (ans==0) ? f : gcd(ans,f);
    }
    cout<<ans<<endl;
}