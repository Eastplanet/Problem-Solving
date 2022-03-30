#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>


using namespace std;
typedef pair<int, int>P;
vector<P> adj[100001];
int dist[100001];
int maxLeng = 0;
int maxIdx;

void dfs(int root) {

	for (P next : adj[root]) {

		int node = next.first;
		int val = next.second;

		//방문한적있으면 스킵
		if (dist[node] != -1)continue;

		dist[node] = dist[root] + val;
		if (dist[node] > maxLeng) {
			maxLeng = dist[node];
			maxIdx = node;
		}

		dfs(node);
	}

}




int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int V;
	cin >> V;



	for (int i = 0; i < V; i++) {
		int pa, ch = 0, val;
		cin >> pa;
		while (true) {
			cin >> ch;
			if (ch == -1)break;
			cin >> val;
			adj[pa].push_back(P(ch, val));
		}
	}

	fill(&dist[0], &dist[100001], -1);

	dist[1] = 0;
	dfs(1);

	fill(&dist[0], &dist[100001], -1);

	dist[maxIdx] = 0;
	dfs(maxIdx);

	cout << maxLeng;



}