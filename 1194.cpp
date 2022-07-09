#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

struct P
{
	int x, y, move, key;
};

char arr[51][51];
int N, M;
int visited[51][51][1 << 6];
int movepos[4][2] = { {0,1},{0,-1},{1,0},{-1,0} };
const int INF = 123456789;
int minV = INF;


bool canmove(int x, int y) {
	if (x < 0 || x >= M)return false;
	if (y < 0 || y >= N)return false;
	if (arr[y][x] == '#')return false;
	return true;
}

int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);


	cin >> N >> M;
	P start;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
			if (arr[i][j] == '0') {
				start = { j,i,0,0 };
				arr[i][j] = '.';
			}
		}



	queue<P> q;
	visited[start.y][start.x][start.key] = 1;
	q.push(start);

	while (!q.empty()) {
		P curr = q.front(); q.pop();

		//'1'로바꿔야함
		if (arr[curr.y][curr.x] == '1') {
			if (minV > curr.move)minV = curr.move;
			break;
		}

		for (int i = 0; i < 4; i++) {
			int gox, goy;
			gox = curr.x + movepos[i][0];
			goy = curr.y + movepos[i][1];
			if (canmove(gox, goy)) {
				if (!visited[goy][gox][curr.key]) {
					if (arr[goy][gox] >= 'a' && arr[goy][gox] <= 'f') {

						visited[goy][gox][curr.key] = 1;

						int idx = arr[goy][gox] - 'a';
						int getKey = curr.key | (1 << idx);
						visited[goy][gox][getKey] = 1;

						q.push(P{ gox,goy,curr.move + 1,getKey });
					}
					else if (arr[goy][gox] >= 'A' && arr[goy][gox] <= 'F') {
						int idx = arr[goy][gox] - 'A';
						if (curr.key & (1 << idx)) {
							visited[goy][gox][curr.key] = 1;
							q.push(P{ gox,goy,curr.move + 1,curr.key });
						}
					}
					// . 이거나 1 이거나
					else {
						visited[goy][gox][curr.key] = 1;
						q.push(P{ gox,goy,curr.move + 1,curr.key });
					}
				}
			}
		}
	}

	if (minV == INF)cout << "-1";
	else cout << minV;







}