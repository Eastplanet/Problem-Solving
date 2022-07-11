#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

int N;
int arr[51];
int dp[51][1001];
int M, S;



int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N >> S >> M;
	for (int i = 0; i < N; i++)cin >> arr[i];

	if (S - arr[0] >= 0)dp[0][S - arr[0]] = 1;
	if (S + arr[0] <= M)dp[0][S + arr[0]] = 1;


	for (int i = 1; i < N; i++) {

		for (int j = 0; j <= 1000; j++) {
			if (j - arr[i] >= 0 && dp[i - 1][j] == 1)dp[i][j - arr[i]] = 1;
			if (j + arr[i] <= M && dp[i - 1][j] == 1)dp[i][j + arr[i]] = 1;
		}


	}


	int max = -1;
	for (int i = 0; i <= 1000; i++) {
		if (dp[N - 1][i] != 0)max = i;
	}

	cout << max;

}