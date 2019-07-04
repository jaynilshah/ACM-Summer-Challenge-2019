// without comparator
#include <bits/stdc++.h>
#define pb push_back
using namespace std;
int main() {
    int n;
    cin >> n;
    vector<string> v[11];
    for(int i = 0; i<n; i++) {
        string username;
        cin >> username;
        int si = int(username.length());
        v[si].pb(username);
    }
    for(int i = 1; i<=10; i++) sort(v[i].begin(), v[i].end());
 
    vector<string> mike;
    for(int i = 1; i<=10; i++) {
        for(int j = int(v[i].size())-1; j>=0; j--) {
            mike.pb(v[i][j]);
        }
    }
    
    //for(int i = 0; i<mike.size(); i++) cout<<mike[i]<<'\n';
    
    int q;
    cin >> q;
    while(q--) {
        int idx;
        cin >> idx;
        cout<<mike[idx-1]<<'\n';
    }
}
