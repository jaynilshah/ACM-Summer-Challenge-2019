#include <bits/stdc++.h>
using namespace std;
#define nax 100005
#define mod 1000000007
 
int main() {
    int q;
    cin >> q;
    
    //prebuild the answer
    int dp[nax] = {};
    dp[1] = 1; dp[2] = 3;
    for(int i = 3; i<=nax; i++) dp[i] = (dp[i-1]%mod + (2*dp[i-2])%mod)%mod;

    while(q--) {
        int n;
        cin >> n;
        cout<<dp[n]<<'\n';
    }
}