#include <iostream>
#include <vector>

using namespace std;

int main() {
//    freopen("sample_input.txt", "r", stdin);
//    freopen("sample_output.txt", "w", stdout);
    int t;
    cin >> t;
    while (t--) {
        int n, k, ans = 0;
        cin >> n >> k;
        vector<int> v(n);
        for (int i = 0; i < n; i++) {
            cin >> v[i];
        }
        int maxset = 1 << n;
        int subset = 1;
        for (; subset < maxset; subset++) {
            int temp_sum = 0;
            for (int i = 0; i < n; i++) {
                if (subset & (1 << i)) temp_sum += v[i];
            }
            if (temp_sum % k == 0) ans++;
        }
        cout << ans << endl;
    }
    return 0;
}
