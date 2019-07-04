#include <bits/stdc++.h>
using namespace std;
 
#define ll long long int
#define tc(t) ll t;cin >> t; while(t--)
#define pb push_back
#define fi first
#define se second
#define debug1(x) cout<<#x<<" = "<<x<<'\n';
#define debug2(x, y) cout << #x << " = " << x << "   " << #y << " = " << y << "\n";
#define boost ios_base::sync_with_stdio(0);cin.tie(NULL);
#define mod 1000000007
 
ll power(ll a, ll b) { if(b==0) return 1; else if(b%2 == 0) return power((a*a)%mod, b/2); else return ((a%mod)* power( (a*a)%mod, (b-1)/2 )%mod)%mod;}
ll isPrime(ll x) {ll i, flag = 1; if(x == 0 || x == 1) flag = 0; for(i = 2; i<=sqrt(x); i++) { if(x%i == 0) {flag = 0; break;}} return flag;}
 
int main() {
	boost;
	ll n, k;
	cin >> n >> k;
	priority_queue<ll> pq;
	ll a[n] = {};
	for(int i = 0; i<n; i++) cin >> a[i];
	pq.push(a[n-1]);
	ll ans = 0;
	for(int i = n-1; i>=0; i--) {
		ans = max(ans, k*(pq.top()-a[i]));
		pq.push(a[i]);
	}
	cout<<ans;
	return 0;
}
