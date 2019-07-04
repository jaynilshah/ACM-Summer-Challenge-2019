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
	//freopen("in03.txt", "r", stdin);
	//freopen("out03.txt", "w", stdout);
	string s;
	cin >> s;
	int count = 0;
	int ans = 0;
	for(int i = 0; i<s.length(); i++) {
		if(s[i] == '(') {
			ans++;
			count++;
		} else if(s[i] == ')' and count > 0) {
			count --;
			ans++;
		}
	}
	cout<<ans-count<<'\n';
	return 0;
}
