#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int U[201];

int find(int a) {
	if (U[a] < 0)return a;
	return U[a] = find(U[a]);
}

void merge(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b)return;
	if (U[a] < U[b]) {
		U[a] += U[b];
		U[b] = a;
	}
	else {
		U[b] += U[a];
		U[a] = b;
	}
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	fill(&U[0], &U[201], -1);
	int n;
	cin >> n;
	int m;
	cin >> m;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			int temp;
			cin >> temp;
			if (temp == 1) {
				merge(i, j);
			}
		}
	}

	int prev;

	for (int i = 0; i < m; i++) {
		int temp;
		cin >> temp;

		if (i == 0) {
			prev = find(temp);
		}
		else {
			if (prev != find(temp)) {
				cout << "NO";
				return 0;
			}
		}
	}

	cout << "YES";

}