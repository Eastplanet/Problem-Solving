#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

const int Size = 2097152;
long long arr[2097152];
int N,M,K;

void construct() {
	for (int i = Size/2 - 1; i > 0; i--) {
		arr[i] = arr[i * 2] + arr[i * 2 + 1];
	}
}

void update(int i, long long val) {
	i += Size / 2;
	arr[i] = val;
	while (i > 1) {
		i /= 2;
		arr[i] = arr[i * 2] + arr[i * 2 + 1];
	}
}

long long sum(int findL, int findR, int nodeNum, int nodeL, int nodeR) {
	if (findR < nodeL || findL > nodeR)return 0;
	if (findL <= nodeL && findR >= nodeR)return arr[nodeNum];
	int mid = (nodeL + nodeR) / 2;
	return sum(findL, findR, nodeNum * 2, nodeL, mid) + sum(findL, findR, nodeNum * 2 + 1, mid + 1, nodeR);
}



int main(void)

{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	cin >> N >> M >> K;
	for (int i = 0; i < N; i++) cin >> arr[i + Size/2];

	construct();


	for (int i = 0; i < M + K; i++) {
		long long a, b, c;
		cin >> a >> b >> c;
		if (a == 1) {
			update(b-1, c);
		}
		else {
			cout << sum(b-1, c-1, 1, 0, Size / 2 - 1)<<'\n';
		}
	}
	

	

}

