#include <bits/stdc++.h>

using namespace std;

int main() {
//    freopen("in03.txt", "r", stdin);
//    freopen("out03.txt", "w", stdout);
    int t;
    cin >> t;
    while (t--) {
        int n, k, sum = 0, ans, l, r;
        cin >> n >> k;
        vector<int> st(n);  //stack
        // input stack
        for (int i = 0; i < n; i++) {
            cin >> st[i];
        }
        // pop k elements into bucket
        for (int i = 0; i < k; i++) {
            sum += st[i];
        }
        ans = sum;
        l = 0;
        r = k - 1;
        while (r - l > 0) {
            sum -= st[l];
            sum -= st[r];
            ans = max(ans, sum);
            l++;
            r--;
        }
        cout << ans << endl;
    }
    return 0;
}
