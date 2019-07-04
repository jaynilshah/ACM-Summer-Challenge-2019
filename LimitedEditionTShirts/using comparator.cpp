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

bool comp(const pair<int, string > &a, const pair<int, string > &b) {
	if(a.first < b.first) 
		return true;
	else if(a.first == b.first) {
		return(a.second > b.second);
	}
	else
		return false;
}
int main() {_
	//freopen("in04.txt", "r", stdin);
	//freopen("out04.txt", "w", stdout);
	int n;
	cin >> n;
	string s[n];
	vector<pair<int, string > > v;
	for(int i = 0; i<n; i++) {
		cin >> s[i];
		v.pb({int(s[i].length()), s[i]});
	}
	sort(v.begin(), v.end(), comp);
	int q;
	cin >> q;
	while(q--) {
		int idx;
		cin >> idx;
		cout<<v[idx-1].se<<'\n';
	}
	return 0;
}

