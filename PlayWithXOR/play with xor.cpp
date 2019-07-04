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

int XOR(int n) {
	int temp = n%4;
	
	if(temp == 0) return n;
	else if(temp == 1) return 1;
	else if(temp == 2) return n+1;
	else if(temp == 3) return 0;
}
int main() {
	boost;
	//freopen("in010.txt", "r", stdin);
	//freopen("out010.txt", "w", stdout);
	int n, q;
	cin >> n >> q;
	while(q--) {
		int l, r;
		cin >> l >> r;
		if(r < l or r > n) return -1;
		int temp = XOR(r);
		int temp1 = XOR(l-1);
		int ans = temp xor temp1;
		cout<<ans<<'\n';
	}
	
	return 0;
}

