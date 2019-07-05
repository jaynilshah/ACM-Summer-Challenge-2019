#include<bits/stdc++.h>

using namespace std;

int main() {
	
//	freopen("in02.txt", "r", stdin);
//	freopen("out02.txt", "w", stdout);
	
	// max days - 60
	long long seq[61];
	seq[0] = 1;
	seq[1] = 1;
	seq[2] = 3;
	for(int i=3; i<61; i++) {
		seq[i] = seq[i-1] + 2*seq[i-2];
//		cout<<i<<" "<<seq[i]<<endl;
	}
	int t;
	cin>>t;
	while(t--) {
		int n;
		cin>>n;
		if(n==1) cout<<"2"<<endl;
		else {
			cout<<seq[n]+seq[n-1]+seq[n-1]+seq[n-2]<<endl;
		}
	}
	return 0;
}
