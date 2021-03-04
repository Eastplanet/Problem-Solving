#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;
int component = 0;
int visited[1001] = { 0 };
int n;
vector <vector<int>> loot;
void dfs(int a) {
    visited[a] = 0;
    for (int i = 0; i < loot[a].size(); i++) {
        if (visited[loot[a][i]] == 1)dfs(loot[a][i]);
    }
}










int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int  m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        visited[i] = 1;
    }
    vector <int> mem;
    loot.assign(n + 1, mem);
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        loot[a].push_back(b);
        loot[b].push_back(a);
    }
    for (int i = 1; i <= n; i++) {
        if (visited[i] == 1) { dfs(i); component++; }
    }

    cout << component;


}