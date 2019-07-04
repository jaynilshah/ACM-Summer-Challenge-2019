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
#define nax 100005

int main() {_
	//freopen("in03.txt", "r", stdin);
	//freopen("out03.txt", "w", stdout);
	int n, k;
	cin >> n >> k;
	
	int arr[nax] = {};	
	arr[1] = n & k; arr[2] = n|k; arr[3] = n ^ k; 
	
	for(int i = 1; i<=29523; i++) {
		arr[3*i+1]  = arr[i] & k;
		arr[3*i+2]  = arr[i] | k;
		arr[3*i+3]  = arr[i] ^ k;
	}
	
	int level[11] = {};
	if(n%2 == 0) level[0] = 1;
	int num[11] = {};
	num[0] = 1;
	
	for(int i = 1; i<=10; i++) {
		int start = (pow(3, i) - 1)/2; 
		int end = start + pow(3, i) - 1;
		num[i] = end - start + 1;
		for(int j = start; j<=end; j++) {
			if(arr[j]%2 == 0) level[i] ++;
		}
	}
	int q;
	cin >> q;
	while(q--) {
		int steps;
		cin >> steps;
		int g = __gcd(num[steps], level[steps]);
		if(level[steps] == 0) cout<<"All odd\n";
		else cout<<num[steps]/g + level[steps]/g<<'\n';	
	}
	
	return 0;
}
