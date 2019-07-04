#include <bits/stdc++.h>
using namespace std;

#define pb push_back
#define debug1(x) cout<<#x<<" = "<<x<<'\n';
#define debug2(x, y) cout << #x << " = " << x << "   " << #y << " = " << y << "\n";
#define boost ios_base::sync_with_stdio(0);cin.tie(NULL);

int n, m;
char a[11][11]; 
vector<string> v;

void path(string curr, int r, int c) {
	if(r == n-1) {
		for(int i = c; i<m; i++) curr += a[r][i];
		v.pb(curr);
		return;
	}
	if(c == m-1) {
		for(int i = r; i<n; i++) curr += a[i][c];
		v.pb(curr);
		return;
	}
	curr += a[r][c];
	
	path(curr, r+1, c); // down
	path(curr, r, c+1); // right
}

int main() {
	boost;
	//freopen("in03.txt", "r", stdin);
	//freopen("out03.txt", "w", stdout);
	int t;
	cin >> t;
	while(t--) {
		v.clear();
		int k;
		cin >> n >> m >> k;
		
		for(int i = 0; i<n; i++) 
			for(int j = 0; j<m; j++) cin >> a[i][j];
		
		string curr = "";
		path(curr, 0, 0);
		
		vector<string> local;
		for(int i = 0; i<v.size(); i++) {
			int flag = 0;
			for(int j = 0; j<int(v[i].size()); j++) {
				if(v[i][j] == 'a' or v[i][j] == 'e' or v[i][j] == 'i' or v[i][j] == 'o' or v[i][j] == 'u') {
					flag = 1;
				}
			}
			if(flag) local.pb(v[i]);
		}
		sort(local.begin(), local.end());
		int si = local.size();
		if(si < k) cout<<-1<<'\n';
		else cout<<local[k-1]<<'\n';
	}

	return 0;
}

