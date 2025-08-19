#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int maxActivities(vector<pair<int, int>>&intervals){
   sort(intervals.begin(), intervals.end(), [](const pair<int, int>&a, const pair<int, int>&b){
    return a.second <  b.second;
   });
   
   int count=0,end=-1;

    for(const auto&interval:intervals){
        if(interval.first>end){
            count++;
            end=interval.second;
        }
    }
    return count;
}

int main(){
    vector<pair<int, int>> intervals = {{1,3},{2,4},{3,5}};
    cout << maxActivities(intervals) << endl;
    return 0;
}