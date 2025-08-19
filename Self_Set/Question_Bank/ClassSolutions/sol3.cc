#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, C;
    cin >> N >> C;
    vector<int> A(N);
    for (int i = 0; i < N; ++i) cin >> A[i];

    int disturbance = 0;
    int oil = 0, min_oil = 0, max_oil = C;

    for (int i = 0; i < N; ++i) {
        if(A[i] == -1) oil--;
        else oil++;
        min_oil = min(oil, min_oil);
        max_oil = max(max_oil, oil);
    }
    int o1 = max_oil-C, o2 = 0-min_oil;
    if(o1 > o2) cout<<"0\n";
    else cout<<o2<<endl;
    return 0;
}
