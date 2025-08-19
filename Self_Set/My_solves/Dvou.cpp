#include<iostream>
#include<array>

using namespace std;

int main(){
    array<int, 5> numbers{1,2,3,4,5};
    cout << "The elements are : "<<endl;
    for(const int num: numbers){
        cout<<num<<" ";
    }
}