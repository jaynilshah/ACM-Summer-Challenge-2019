#include <bits/stdc++.h>

typedef long long ll;

using namespace std;

vector<ll> min_time(100005, INT_MAX);  // index i gives min time between height i-1 and i
vector<int> height(100005, -1);
vector<vector<int> > adj(100005);

void dfs(int node, int h) {
    // set height
    height[node] = h;
    // iteratate through all its adjacent nodes
    for (int i = 0; i < (int)adj[node].size(); i++) {
        // skip if visited
        if (height[adj[node][i]] != -1) continue;
        // update the min time
        min_time[h + 1] = min(min_time[h + 1], (ll)node + (ll)adj[node][i]);
        // recurse
        dfs(adj[node][i], h + 1);
    }
    return;
}

int main() {
//    freopen("in05.txt", "r", stdin);
//    freopen("out05.txt", "w", stdout);

    int n, q;
    cin >> n;
    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    // call at root node with height 0
    dfs(1, 0);

    // convert min_time into prefix sum of itself
    min_time[0] = 0;
    for (int i = 2; i <= n - 1; i++) min_time[i] += min_time[i - 1];

    // start queries
    cin >> q;
    while (q--) {
        int x, y;
        cin >> x >> y;
        x = height[x];
        y = height[y];
        // make sure y is not smaller
        if (y < x) swap(x, y);
        cout << min_time[y] - min_time[x] << endl;
    }

    return 0;
}
