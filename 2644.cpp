#include<iostream>
#include<algorithm>
#include<unordered_map>
#include<cstring>
#include<math.h>
#include<queue>
#include<vector>

using namespace std;



vector<int>adj[101];
int visited[101];


int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n; cin >> n;
	int find1, find2;
	cin >> find1 >> find2;
	int m;
	cin >> m;



	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	queue<int> q;
	q.push(find1);
	visited[find1] = 1;
	while (!q.empty()) {
		int curr = q.front(); q.pop();
		if (curr == find2) {
			cout << visited[find2] - 1;
			return 0;
		}

		for (auto next : adj[curr]) {
			if (visited[next])continue;
			visited[next] = visited[curr] + 1;
			q.push(next);
		}

	}

	cout << "-1";



}