#include<iostream>
#include<queue>
#include<fstream>
#include<tuple>
#include<algorithm>

using namespace std;

struct P {
	int s, e, d = 100000;
};
P arr[100000];

bool cmp(P a, P b) {
	return a.d < b.d;
}

int u[1001];

int find(int a) {
	if (u[a] < 0)return a;
	return u[a] = find(u[a]);
}

void merge(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b)return;
	if (u[a] < u[b]) {
		u[a] += u[b];
		u[b] = a;
	}
	else {
		u[b] += u[a];
		u[a] = b;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N; cin >> N;
	int M; cin >> M;
	for (int i = 0; i < M; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		arr[i] = P{ a,b,c };
	}

	sort(arr, arr + M, cmp);
	fill(u, u + 1001, -1);
	int sum = 0;
	int count = 0;
	for (int i = 0; i < M; i++) {
		if (count == N - 1)break;

		P curr = arr[i];
		if (find(curr.s) == find(curr.e))continue;

		merge(curr.s, curr.e);
		sum += curr.d;
		count++;
	}

	cout << sum;
}