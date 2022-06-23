#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <stack>

using namespace std;

int cost[101];
int dp[101][10001];
int MAX = 123456789;
int N, K;

int rec(int now, int k) {
	//끝한칸 뒤 idx까지 도착했지만 k를 전부 사용 못한경우 불가능
	if (now == N) {
		if (k == 0)return 0;
		else return MAX;
	}

	if (dp[now][k] != -1)return dp[now][k];

	//현재 idx의 코인을 하나도 안쓰고 다음 idx로 넘김
	int result = rec(now + 1, k);

	//현재 idx를 하나 쓰고 현재 idx로 넘김
	if (k >= cost[now])result = min(result, rec(now, k - cost[now]) + 1);
	dp[now][k] = result;
	return dp[now][k];

}

int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N >> K;

	for (int i = 0; i < N; i++) {
		cin >> cost[i];
	}

	fill(&dp[0][0], &dp[100][10001], -1);

	int ret = rec(0, K);
	if (ret == MAX)cout << "-1";
	else cout << ret;

}