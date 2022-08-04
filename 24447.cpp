#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>
#include <math.h>

using namespace std;

vector<int> adj[100001];
long long visited[100001];
long long visCount = 1;
long long sum = 0;



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
    visited[R] = 0;
    visCount++;

    while (!q.empty()) {
        int curr = q.front(); q.pop();

        for (auto now : adj[curr]) {
            if (visited[now] != -1)continue;
            visited[now] = visited[curr] + 1;
            sum += visited[now] * visCount++;
            q.push(now);
        }

    }


    cout << sum;

}