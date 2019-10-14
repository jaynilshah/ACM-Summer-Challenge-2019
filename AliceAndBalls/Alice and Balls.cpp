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
	ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	boost;
	//freopen("in09.txt", "r", stdin);
	//freopen("out09.txt", "w", stdout);
	int n;
	cin >> n;
	
	int red = 0, blue = 0;
	for(int i = 0; i<n; i++) {
		char ch;
		cin >> ch;
		if(ch == 'R') red = i+1;
		else blue = i+1;
	}
	cout<<min(red, blue); 
	return 0;
}
