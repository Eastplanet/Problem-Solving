#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

struct T
{
	int idx, jewel;
};

typedef pair<int, int>P;

int N, M, K;
int jewelIsland[15];
int visited[101][1 << 14];
int maxV = 0;
vector<P>adj[101];



int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N >> M >> K;
	for (int i = 0; i < K; i++)cin >> jewelIsland[i];
	for (int i = 0; i < M; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		adj[a].push_back(P(b, c));
		adj[b].push_back(P(a, c));
	}


	queue<T> q;
	q.push(T{ 1,0 });

	for (int i = 0; i < K; i++) {
		if (jewelIsland[i] == 1) {
			q.push(T{ 1,1 << (i) });
		}
	}

	while (!q.empty()) {
		T curr = q.front(); q.pop();
		int count = 0;
		for (int i = 0; i < K; i++) {
			if ((curr.jewel >> i) & 1)count++;
		}

		if (curr.idx == 1 && visited[curr.idx][curr.jewel] == 1) {
			if (maxV < count)maxV = count;
			continue;
		}

		for (auto next : adj[curr.idx]) {
			//방문여부
			if (visited[next.first][curr.jewel])continue;
			//무게 초과 여부
			if (next.second < count)continue;

			int isFlag = 0;
			int isJewel = 0;
			for (int i = 0; i < K; i++) {
				if (jewelIsland[i] == next.first) {
					isFlag = 1;
					isJewel = i;
					break;
				}
			}

			//보석섬이든 아니든 보석을 안줍는 경우
			visited[next.first][curr.jewel] = 1;
			q.push(T{ next.first,curr.jewel });


			if (isFlag != 0) {
				visited[next.first][curr.jewel | (1 << isJewel)] = 1;
				q.push(T{ next.first,curr.jewel | (1 << isJewel) });
			}
		}
	}


	cout << maxV;





}