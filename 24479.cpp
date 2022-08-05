#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>
#include <math.h>

using namespace std;


int N, M, R;
vector <int> adj[100001];
int visited[100001];
int Count = 1;

void dfs(int node) {
    
    for (auto next : adj[node]) {
        if (visited[next] != 0)continue;
        visited[next] = Count++;
        dfs(next);
    }
}


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> N >> M >> R;
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for (int i = 0; i <= N; i++) {
        sort(adj[i].begin(), adj[i].end());
    }
    
    visited[R] = Count++;
    dfs(R);

    for (int i = 1; i <= N; i++) {
        cout << visited[i] << "\n";
    }

}