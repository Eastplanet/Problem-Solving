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
int visCount = 1;

bool cmp(int a, int b) {
    return a > b;
}


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N, M, R; cin >> N >> M >> R;


    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    for (int i = 0; i <= N; i++) {
        sort(adj[i].begin(), adj[i].end(), cmp);
    }

    queue<int> q;
    q.push(R);
    visited[R] = visCount++;

    while (!q.empty()) {
        int curr = q.front(); q.pop();

        for (auto now : adj[curr]) {
            if (visited[now] != 0)continue;
            visited[now] = visCount++;
            q.push(now);
        }

    }


    for (int i = 1; i <= N; i++) {
        cout << visited[i] << '\n';
    }

}