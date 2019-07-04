#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace __gnu_pbds;
using namespace std;
 
#define ordered_set tree<long long int, null_type, less<long long int>, rb_tree_tag, tree_order_statistics_node_update>
#define ll long long int
#define tc(t) int t;cin >> t; while(t--)
#define pb push_back
#define fi first
#define se second
#define debug1(x) cout<<#x<<" = "<<x<<'\n';
#define debug2(x, y) cout << #x << " = " << x << "   " << #y << " = " << y << "\n";
#define _ ios_base::sync_with_stdio(0);cin.tie(NULL);
 
int main() {_
	ll n;
	cin >> n;
	vector<pair<ll, ll > > v;
	ll arr[n] = {};
	for(int i = 0; i<n; i++) {
		cin >> arr[i];
		v.pb({arr[i], i});
	}
	sort(v.begin(), v.end());
	ordered_set s;
	ll ans = 0;
	for(int i = 0; i<n; i++) {
		ll pos = v[i].se;
		//debug1(pos)
		s.insert(pos);
		ll x = s.order_of_key(pos);
		ll si = i;
	
		//debug1(si-x)
	    ans += (si-x);    
	
	
	}
	cout<<ans;
	return 0;
}
