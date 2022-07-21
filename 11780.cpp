#include<iostream>
#include<algorithm>
#include<unordered_map>
#include<cstring>
#include<math.h>
#include<queue>
#include<vector>

using namespace std;

struct P{
	int y, x;
};

const int INF = 12345678;
int N, M;
int arr[101][101];
int visit[101][101];

vector<int> pathFind(int start, int end) {
	vector<int> path;
	int middle = visit[start][end];

	if (start == middle) {
		path.push_back(end);
		return path;
	}
	else {
		vector<int> head = pathFind(start, middle);
		vector<int> tail = pathFind(middle, end);

		for (int i = 0; i < tail.size(); i++) {
			head.push_back(tail[i]);
		}

		return head;
	}
}



int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	fill(&arr[0][0], &arr[100][101], INF);

	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		if (arr[a][b] != 0) {
			if (arr[a][b] < c)continue;
		}
		arr[a][b] = c;
		visit[a][b] = a;

	}

	for (int k = 1; k <= N; k++) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (k == i || k == j || i == j)continue;
				if (arr[i][k] + arr[k][j] < arr[i][j]) {
					visit[i][j] = k;
					arr[i][j] = arr[i][k] + arr[k][j];
				}

			}
		}
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (arr[i][j] == INF) {
				cout << "0"<<" ";
			}
			else {
				cout << arr[i][j] << " ";
			}
		}
		cout << endl;
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			if (arr[i][j] == INF)cout << "0" << endl;
			else {
				vector<int> path = pathFind(i, j);
				

				cout << path.size()+1 << " ";
				cout << i << " ";
				for (int z = 0; z < path.size(); z++) {
					cout << path[z] << " ";
				}
				cout << endl;
				

			}
		}

	}

}