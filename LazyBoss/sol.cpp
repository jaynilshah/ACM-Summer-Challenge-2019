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
#define mod 1000000007

ll power(ll a, ll b) { 
	if(b==0) return 1; 
	else if(b%2 == 0) return power((a*a)%mod, b/2); 
	else return ((a%mod)* power( (a*a)%mod, (b-1)/2 )%mod)%mod;
}
	

int main() {_

	//freopen("in05.txt", "r", stdin);
	//freopen("out05.txt", "w", stdout);
	ll n, k, i;
	cin >> n >> k;
	// n = employees, k = number of projects.
	assert(n > 0 and n <= 1000000000000000000);
	assert(k > 0 and k <= 100000);
	
	ll sum = 0;
	for(i = 1; i<=k; i++) {
		ll temp = power(i, n);
		sum = (sum + temp)%mod;
	}
	assert(sum > 0 and sum < mod);
	cout<<sum<<'\n';
	return 0;
}

