#include<iostream>
#include<vector>
#include<algorithm>


typedef long long LL;
using namespace std;

char graph[10000][10000];

void drawBasicTrangle(int x, int y) {
	graph[y][x] = '*';

	graph[y + 1][x - 1] = '*';
	graph[y + 1][x + 1] = '*';

	graph[y + 2][x - 2] = '*';
	graph[y + 2][x - 1] = '*';
	graph[y + 2][x - 0] = '*';
	graph[y + 2][x + 1] = '*';
	graph[y + 2][x + 2] = '*';
}

void recursiveDraw(int x, int y, int size) {
	if (size == 3) {
		drawBasicTrangle(x, y);
		return;
	}
	else {
		size = size / 2;
		recursiveDraw(x, y, size);
		recursiveDraw(x - size, y + size, size);
		recursiveDraw(x + size, y + size, size);
	}

}



int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	fill(&graph[0][0], &graph[9999][10000], ' ');

	recursiveDraw(N - 1, 0, N);

	for (int i = 0; i < N; i++) {
		for (int j = 0; j <= 2 * N - 1; j++) {
			cout << graph[i][j];
		}
		cout << '\n';
	}
	
	
	

}