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
	//freopen("in14.txt", "r", stdin);
	//freopen("out14.txt", "w", stdout);
	int n;
	cin >> n;
	int a[n][n];
	int count = 1;
	for(int j = 0; j<n; j++) {
		for(int i = 0; i<n; i++) {
			if(i>=j) {
				a[i][j] = count;
				count++;
			}
		}
	}
	for(int i = 0; i<n; i++) {
		for(int j = 0; j<n; j++) {
			if(i >= j) cout<<a[i][j]<<' ';
		}
		cout<<'\n';
	}
	return 0;
}

