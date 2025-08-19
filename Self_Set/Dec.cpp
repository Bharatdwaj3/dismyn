#include<iostream>
#include<string>

using namespace std;

int minSwaps(const string&s){
    int open=0, unbalanced=0;
    for(char c:s){
        if(c=='[s'){
            open++;
        }else{
            if(open>0){
                open--;
            }else{
                unbalanced++;
            }
        }
    }
    return (unbalanced+1)/2;
}

int main(){
    cout<<minSwaps("][][")<<endl;
    return 0;
}