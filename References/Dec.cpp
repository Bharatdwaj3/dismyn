#include<iostream>
#include<vector>
using namespace std;

int main(){
    int n, m, H;
    cin >> n >> m >> H;
    int vptr = n-1, hptr = 0;
    vector<int> villians(n);

    for(int i=0;i<n;i++){
        cin>>villians[i];
    }
    while(vptr>=0&& hptr<m){
        int hpower=H;
        while(vptr>=0){
            int vpower = villians[vptr];
            if(hpower>vpower){
                hpower-=vpower;
                vptr--;
            }else if(hpower<vpower){
                hptr++;
                break;
            }else {
                vptr--;
                hptr++;
                break;
            }
        }
    }
    cout<<(vptr>=0 ? vptr +1:0)<<endl;
}