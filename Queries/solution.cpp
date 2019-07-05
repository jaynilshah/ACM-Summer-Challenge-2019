#include <bits/stdc++.h>
using namespace std;

int main() {
//    freopen("new-in07.txt", "r", stdin);
//    freopen("new-out07.txt", "w", stdout);
    int n, q;
    cin >> n;
    vector<long long> arr(n + 1), presum(n + 1, 0);
    for (int i = 1; i <= n; i++) {
        cin >> arr[i];
        presum[i] = presum[i - 1] + arr[i];
    }
    cin >> q;
    while (q--) {
        int c, l, r;
        cin >> c >> l >> r;
        if (c == 1) {
            int t1 = l, t2 = r;
            // reverse subarray
            while (t1 < t2) {
                swap(arr[t1], arr[t2]);
                t1++;
                t2--;
            }
            // update prefix sum
            for (int i = l; i <= r; i++) {
                presum[i] = presum[i - 1] + arr[i];
            }
        } else if (c == 2) {
            cout << presum[r] - presum[l - 1] << endl;
        } else
            return -1;
    }
    return 0;
}
