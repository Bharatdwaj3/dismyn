#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int longestArithmeticSubArray(const vector<int>& nums){
    if(nums.size()<2) return nums.size();
    int maxlen=2;
    int currLen=2;
    int diff=nums[1]-nums[0];

    for(size_t i=2; i<nums.size(); i++){
        if(nums[i]-nums[i-1]==diff){
            ++currLen;
        }
    }
}

int main(){
    vector<int> nums={1,2,3,5,7,9};
    cout<<longestArithmeticSubArray(nums)<<endl;
    return 0;
}