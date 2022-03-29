#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>

using namespace std;
typedef pair<int, int>P;

typedef pair<P, P>TP;
//첫 페어=탐색하는 y,x 두번째 페어= 벽 파괴 여부, 현재까지 길이

int N, M;
int arr[1001][1001];
int visited[1001][1001];//방문 및 값
int movepos[4][2] = { {0,1},{0,-1},{1,0},{-1,0} };

bool canMove(int y, int x) {
	if (x<1 || x>M)return false;
	if (y<1 || y>N)return false;
	return true;
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
	cin >> N >> M;

	
	for (int i = 1; i <= N; i++) {
		string temp;
		cin >> temp;
		for (int j = 0; j < temp.size(); j++) {
			arr[i][j + 1] = temp[j] - '0';
		}
	}

	int minLeng = -1;
	queue<TP> q;
	fill(&visited[0][0], &visited[1000][1001], -1);

	q.push(TP(P(1, 1), P(0,1)));
	visited[1][1] = 1;
	
	while (!q.empty()) {
		P curr = q.front().first;
		int y = curr.first;
		int x = curr.second;
		
		int breakFlag = q.front().second.first;
		int leng = q.front().second.second;
		q.pop();
		if (y == N && x == M) {
			if (minLeng == -1)minLeng = leng;
			else if (minLeng > leng)minLeng = leng;
		}

		for (int i = 0; i < 4; i++) {
			int gox, goy;
			goy = y + movepos[i][0];
			gox = x + movepos[i][1];
			if (canMove(goy, gox)) {
				//벽안부순사람이 지나간 경우
				if (visited[goy][gox] == 1)continue;
				//벽 부순사람이 지나간 길을 벽 부순사람이 지나려는 경우
				if (visited[goy][gox] == 2 && breakFlag == 1)continue;


				//벽이 아닐 때
				if (arr[goy][gox] == 0) {
					q.push(TP(P(goy, gox), P(breakFlag, leng + 1)));
					//부순적 없는 사람이 지나감
					if (breakFlag == 0) {
						visited[goy][gox] = 1;
					}
					//부순적 있는 사람이 지나감
					else{
						visited[goy][gox] = 2;
					}
				}
				//벽일 때
				else {
					//부순적이 있으면 패스
					if (breakFlag == 1)continue;
					
					q.push(TP(P(goy, gox), P(1, leng + 1)));
					visited[goy][gox] = 2;

				}


			}
		}

	}

	cout << minLeng;

	



}