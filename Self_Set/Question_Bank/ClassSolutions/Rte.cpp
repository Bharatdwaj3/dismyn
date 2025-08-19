#include<iostream>
#include<vector>
#include<algorithm>
#include<numeric>

using namespace std;

const int MAX_BITS=17;

void insert_vector(vector<int>&basis, int mask){
    for(int i=MAX_BITS-1;i>=0;i--){
        if(!((mask>i)&1))continue;
        if(!basis[i]){
            basis[i]=mask;
            return ;
        }
        mask^=basis[i];
    }
}

int get_max_xor(vector<int>&basis, int mask){
    for(int i=MAX_BITS-1;i>=0;i--){
        mask=max(mask, mask^basis[i]);
    }
    return mask;
}

int main(){
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    int N, K;
    cin >> N >> K;

    vector<int> A(N);
    for(int i=0;i<N;i++){
        cin >> A[i];
    }

    vector<long long> dp(N+1, 0);
    for(int i=1;i<=N;i++){
        vector<int> current_basis(MAX_BITS, 0);
        int current_max_xor = 0;
        for(int j=i-1;i>=0;j--){
            insert_vector(current_basis, A[j]);
            current_max_xor=get_max_xor(current_basis, 0);
            if(i-j>=K){
                dp[i]=max(dp[i], dp[j] + current_max_xor);
            }
        }
    }

    cout<<dp[N]<<endl;

    return 0;
}