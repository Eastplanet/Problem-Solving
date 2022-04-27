#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int arr[1000001];
int find(int a) {
	if (arr[a] < 0)return a;
	return find(arr[a]);
}

void merge(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b)return;
	if (arr[a] < arr[b]) {
		arr[a] += arr[b];
		arr[b] = a;
	}
	else {
		arr[b] += arr[a];
		arr[a] = b;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	fill(&arr[0], &arr[1000001], -1);
	int n, m;
	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		int command, a, b;
		cin >> command >> a >> b;
		if (command == 0) {
			merge(a, b);
		}
		else {
			a = find(a);
			b = find(b);
			if (a == b) {
				cout << "yes" << '\n';
			}
			else {
				cout << "no" << '\n';
			}
		}
	}


}