#include <bits/stdc++.h>
using namespace std;
 
#define ll long long int
#define tc(t) int t;cin >> t; while(t--)
#define pb push_back
#define fi first
#define se second
#define debug1(x) cout<<#x<<" = "<<x<<'\n';
#define debug2(x, y) cout << #x << " = " << x << "   " << #y << " = " << y << "\n";
#define _ ios_base::sync_with_stdio(0);cin.tie(NULL);
 
int main() {_
	tc(t) {
		int n, m, k;
		cin >> n >> m >> k;
		int ans = -1;
	    // n\0_0/B
		for(int i = 2; i<=n/2; i++) {
			if(n%i == 0) {
			    if(__gcd(n/i, m) > k) {
					ans = max(n/i, ans);
				}
				if(__gcd(i, m) > k) {
					ans = max(i, ans);
				}
				
			}
		} 
		
		cout<<ans<<'\n';
	}
	return 0;
}
