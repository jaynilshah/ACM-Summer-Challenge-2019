#include <bits/stdc++.h>

using namespace std;

int main() {
//    freopen("in03.txt", "r", stdin);
//    freopen("out03.txt", "w", stdout);
    int n;
    long long MOD = 1e9 + 7, sa = 0, sb = 0;
    cin >> n;
    set<int> a, b;
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        if (a.find(temp) != a.end())
            a.erase(temp);
        else
            a.insert(temp);
    }
    for (int i = 0; i < n; i++) {
        int temp;
        cin >> temp;
        if (b.find(temp) != b.end())
            b.erase(temp);
        else
            b.insert(temp);
    }
    for (auto it = a.begin(); it != a.end(); it++) sa += (long long)(*it);
    for (auto it = b.begin(); it != b.end(); it++) sb += (long long)(*it);
    sa %= MOD;
    sb %= MOD;

    cout << sa << endl
         << sb << endl;
    if (sa < sb)
        cout << "Bob";
    else if (sa > sb)
        cout << "Alice";
    else
        cout << "Tie";

    return 0;
}
