#include <stdio.h>
#include <stdbool.h>

// Check if there's a subset with given sum
bool hasSubsetSum(int arr[], int n, int index, int targetSum, int currentSum){
    if (index == n){
        return currentSum == targetSum;
    }

    if (hasSubsetSum(arr, n, index + 1, targetSum, currentSum)){
        return true;
    }
    if (hasSubsetSum(arr, n, index + 1, targetSum, currentSum + arr[index])){
        return true;
    }
    return false;
}

int main(){
    int arr[] = {3, 34, 4, 12, 5, 2};
    int n = sizeof(arr) / sizeof(arr[0]);
    int targetSum = 9;

    if (hasSubsetSum(arr, n, 0, targetSum, 0)){
        printf("Found a subset with sum %d\n", targetSum);
    }
    else{
        printf("No subset found with sum %d\n", targetSum);
    }

    return 0;
}