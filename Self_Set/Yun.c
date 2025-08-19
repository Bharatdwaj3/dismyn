#include<stdio.h>
#include<stdlib.h>

void printSubset(int subset[], int size){
    printf(" ");
    for(int i=0;i<size;i++){
        printf("%d ",subset[i]);
    }
    printf("\n");
}

void generateSubsets(int arr[], int n, int index, int subset[], int subsetSize){
    if(index==n){
        printSubset(subset, subsetSize);
        return;
    }
    generateSubsets(arr, n, index+1, subset, subsetSize);
    subset[subsetSize]=arr[index];
    generateSubsets(arr, n, index+1, subset, subsetSize+1);
}

int main(){
    int arr={1,2,3};
    int n=sizeof(arr)/sizeof(arr[0]);
    int subset[n];

    printf("All subsets of {1,2,3}: \n");
    generateSubsets(arr,n,0,subset,0);

    return 0;
}