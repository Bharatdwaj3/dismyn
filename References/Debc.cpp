#include<iostream>
#include<unordered_map>
#include<vector>
#include<algorithm>
#include<climits>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<int> arr(n);
    unordered_map<int, int>m;
    for(int i=0;i<n;i++){
        cin >> arr[i], m[arr[i]]++;
    }

    vector<int> freq;
    for(auto& it: m) freq.push_back(it.second);
    sort(freq.begin(), freq.end());
    int maxCount=0;
    for(int i=freq.back();i>0;i--){
        int cnt=i, val=i/2, idx=freq.size()-2;
        while(val>0&&idx>=0){
            if(freq[idx]>=val)
                cnt+=val;
            else break;
            val /= 2;
            idx--;
        }
        maxCount=max(maxCount, cnt);
    }
    cout << maxCount << endl;
}