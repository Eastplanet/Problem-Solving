#include<iostream>
#include<algorithm>
#include<vector>
#include<map>
using namespace std;

int arr[200001];
int find(int a) {
	if (arr[a] < 0)return a;
	return arr[a] = find(arr[a]);
}
void merge(int a, int b) {
	a = find(a);
	b = find(b);
	if (a == b)return;
	if (a < b) {
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


	int T;
	cin >> T;
	while (T--) {
		map<string, int>ma;
		int cnt = 1;
		fill(&arr[0], &arr[200001], -1);

		int F;
		cin >> F;
		for (int i = 0; i < F; i++) {
			string a, b;
			cin >> a >> b;
			if (ma[a] == 0) {
				ma[a] = cnt;
				cnt++;
			}
			if (ma[b] == 0) {
				ma[b] = cnt;
				cnt++;
			}
			merge(ma[a], ma[b]);
			cout << -arr[find(ma[a])] << '\n';
		}

	}

}