#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int u[10001];
int find(int a) {
	if (u[a] < 0)return a;
	return u[a] = find(u[a]);
}

void merge(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b)return;
	if (a < b) {
		u[a] += u[b];
		u[b] = a;
	}
	else {
		u[b] += u[a];
		u[a] = b;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	fill(&u[0], &u[10001], -1);

	int N, M, k;
	cin >> N >> M >> k;

	int arr[10001];
	for (int i = 1; i <= N; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		merge(a, b);
	}

	int groupMinMoney[10001];
	fill(&groupMinMoney[0], &groupMinMoney[10001], 100000000);

	for (int i = 1; i <= N; i++) {
		int temp = find(i);
		if (groupMinMoney[temp] > arr[i]) {
			groupMinMoney[temp] = arr[i];
		}
	}

	int sum = 0;
	for (int i = 1; i <= N; i++) {
		if (groupMinMoney[i] == 100000000)continue;
		sum += groupMinMoney[i];
	}

	if (sum <= k) {
		cout << sum;
	}
	else {
		cout << "Oh no";
	}




}