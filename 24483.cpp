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
long long visited[100001];
int Count = 2;
long long sum = 0;

void dfs(int node) {

    for (auto next : adj[node]) {
        if (visited[next] != -1)continue;
        visited[next] = visited[node] + 1;
        sum += visited[next] * Count++;
        dfs(next);
    }
}

bool cmp(int a, int b) {
    return a > b;
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

    fill(&visited[0], &visited[100001], -1);

    for (int i = 0; i <= N; i++) {
        sort(adj[i].begin(), adj[i].end());
    }

    visited[R] = 0;
    dfs(R);


    cout << sum;

}