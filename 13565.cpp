#include<iostream>
#include<algorithm>
#include<unordered_map>
#include<cstring>
#include<math.h>
#include<queue>
#include<vector>

using namespace std;


typedef pair<int, int>P;
int M, N;
int arr[1001][1001];
int visited[1001][1001];
int movepos[4][2] = { {0,1},{0,-1},{1,0},{-1,0} };

bool canMove(int x, int y) {
	if (x < 0 || x >= M)return false;
	if (y < 0 || y >= N)return false;
	return true;
}


int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;
		for (int j = 0; j < M; j++) {
			arr[i][j] = temp[j] - '0';
		}
	}



	queue<P>q;


	for (int i = 0; i < M; i++) {
		if (arr[0][i] == 0) {
			q.push(P(0, i));
			visited[0][i] = 1;


		}
	}


	while (!q.empty()) {
		P curr = q.front(); q.pop();
		int x = curr.second;
		int y = curr.first;
		if (y == N - 1) {
			cout << "YES";
			return 0;
		}

		for (int i = 0; i < 4; i++) {
			int gox, goy;
			gox = movepos[i][0] + x;
			goy = movepos[i][1] + y;
			if (canMove(gox, goy) == false)continue;
			if (visited[goy][gox] == 1)continue;
			if (arr[goy][gox] == 1)continue;

			visited[goy][gox] = 1;
			q.push(P(goy, gox));
		}
	}

	cout << "NO";




}