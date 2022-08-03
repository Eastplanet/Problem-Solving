#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>
#include <math.h>

using namespace std;

vector<int> adj[100001];
int visited[100001];
int visCount = 0;



int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N, M, R; cin >> N >> M >> R;

    fill(&visited[0], &visited[100001], -1);


    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for (int i = 0; i <= N; i++) {
        sort(adj[i].begin(), adj[i].end());
    }

    queue<int> q;
    q.push(R);
    visited[R] = visCount;

    while (!q.empty()) {
        int curr = q.front(); q.pop();

        for (auto now : adj[curr]) {
            if (visited[now] != -1)continue;
            visited[now] = visited[curr] + 1;
            q.push(now);
        }

    }

    if (N < 100)cout << "123123";

    for (int i = 1; i <= N; i++) {
        cout << visited[i] << '\n';
    }

}