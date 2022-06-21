#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>

using namespace std;

typedef pair<int, int>P;

int movepos[4][2] = { {0,1},{0,-1},{1,0},{-1,0} };
int n, m;
int arr[501][501];

bool canMove(int x, int y) {
	if (x < 0 || x >= m)return false;
	if (y < 0 || y >= n)return false;
	return true;
}

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> arr[i][j];
		}
	}

	int max = 0;
	int count = 0;
	queue<P> q;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 1) {
				count++;
				q.push(P(i, j));
				arr[i][j] = 0;
				int sum = 1;
				while (!q.empty()) {
					P curr = q.front(); q.pop();
					int x = curr.second;
					int y = curr.first;

					for (int z = 0; z < 4; z++) {
						int gox = x + movepos[z][0];
						int goy = y + movepos[z][1];
						if (canMove(gox, goy)) {
							if (arr[goy][gox] == 1) {
								arr[goy][gox] = 0;
								sum++;
								q.push(P(goy, gox));
							}
						}
					}

				}
				if (sum > max) { max = sum; }

			}
		}
	}

	cout << count<<'\n';
	cout << max;


}