#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

int N, M;
int dp[1001][1001];
int arr[1001][1001];
int maxV = 0;


int main(void)

{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		string temp; cin >> temp;
		for (int j = 0; j < M; j++) {
			arr[i][j] = temp[j] - '0';
			if (arr[i][j] == 1)maxV = 1;
		}
	}


	for (int i = 0; i < N; i++)dp[i][0] = arr[i][0];
	for (int j = 0; j < M; j++)dp[0][j] = arr[0][j];

	for (int i = 1; i < N; i++) {
		for (int j = 1; j < M; j++) {
			if (arr[i][j] == 1)dp[i][j] = min({ dp[i - 1][j - 1],dp[i - 1][j],dp[i][j - 1] }) + 1;
			if (maxV < dp[i][j])maxV = dp[i][j];
		}
	}

	cout << maxV * maxV;




}