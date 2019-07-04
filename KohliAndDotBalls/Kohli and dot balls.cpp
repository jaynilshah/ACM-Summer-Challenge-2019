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

int main() {
	boost;
	//freopen("in06.txt", "r", stdin);
	//freopen("out06.txt", "w", stdout);
	int n, i;
	cin >> n;
	int a[n+1] = {}, zero[n+1] = {}, one[n+1] = {}, diff_pos[2*n+1] = {}, diff_neg[2*n+1] = {};
	for(i = 1; i<=n; i++) {
		cin >> a[i];
		if(a[i]) one[i] = one[i-1] + 1, zero[i] = zero[i-1];
		else one[i] = one[i-1],zero[i] = zero[i-1] + 1;
	}
	for(i = 1; i<=n; i++) {
		if(one[i]-2*zero[i] >= 0) {
			diff_pos[one[i]-2*zero[i]] = i;
		} else diff_neg[2*zero[i]-one[i]] = i;
	}
	int ans = 0;
	for(i = 1; i<=n; i++) {
		int x = one[i-1]-2*zero[i-1];
		if(x >= 0) {
			int pos = diff_pos[x];
			ans = max(ans, pos-i+1);
		} else {
			int pos = diff_neg[-x];		
			ans = max(ans, pos-i+1);	
		}
	}
	cout<<ans;
	return 0;
}
