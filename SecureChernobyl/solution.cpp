#include <bits/stdc++.h>

using namespace std;

#define ll long long

int main() {
//    freopen("in03.txt", "r", stdin);
//    freopen("out03.txt", "w", stdout);
    int t;
    cin >> t;
    while (t--) {
        ll n;
        cin >> n;
        ll ans = (n * (n - 1)) / 2;
        ans = (ans * (ans - 1)) / 2;
        ans = ans - (n * (n - 1) * (n - 2)) / 2;
        cout << ans << endl;
    }
    return 0;
}
