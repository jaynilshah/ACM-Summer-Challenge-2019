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

ll isPrime(ll x) {
	ll i, flag = 1; 
	if(x == 0 || x == 1) flag = 0; 
	for(i = 2; i<=sqrt(x); i++) { 
		if(x%i == 0) {
			flag = 0; 
			break;
		}	
	} 
	return flag;
}

int main() {_
	//freopen("in03.txt", "r", stdin);
	//freopen("out03.txt", "w", stdout);
	int t;
	cin >> t;
	while(t--) {
		ll n;
		cin >> n;
		if(isPrime(n)) {
			cout<<1<<'\n';
		}
		else if(n%2 == 0) {
			cout<<2<<'\n';
		}
		else {
			if(isPrime(n-2)) {
				cout<<2<<'\n';
			}
			else cout<<3<<'\n';
		}
	}
	return 0;
}
