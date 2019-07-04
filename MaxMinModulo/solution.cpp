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

int main() {_
	//freopen("in00.txt", "r", stdin);
	//freopen("out00.txt", "w", stdout);
	ll n;
	cin >> n;
	ll arr[n+1] = {};
	ll k; cin >> k;
	priority_queue<ll, vector<ll>, greater<ll> > nin; 
	priority_queue<ll> nax;
	ll p = 0, q = 0;
	vector<ll> alice, bob;
	for(int i = 1; i<=n; i++) {
		ll inp; 
		cin >> inp;
		nax.push(inp);
		nin.push(inp);
		if(i >= k) {
			ll temp = nax.top();
			alice.pb(temp);
			nax.pop();
			p += (temp);
			
			ll temp1 = nin.top();
			bob.pb(temp1);
			nin.pop();
			q += (temp1);
		}
	}
	for(int i = 0; i<alice.size(); i++) cout<<alice[i]<<' ';cout<<'\n';
	for(int i = 0; i<bob.size(); i++) cout<<bob[i]<<' ';cout<<'\n';
	ll g = __gcd(p, q);
	//debug2(p, q);
	ll ans = ((p/g)%mod + (q/g)%mod)%mod;
	cout<<ans;
	return 0;
}
