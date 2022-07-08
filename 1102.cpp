#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

int N, P;
int arr[16][16];

int dp[1 << 16];
const int INF = 123456789;
int minV = INF;

int repair(int visited, int count) {
	if (count == P) return 0;
	if (dp[visited] != -1)return dp[visited];

	vector<int> notBreak;
	vector<int> Break;
	for (int i = 0; i < N; i++) {
		if ((visited >> i) & 1)notBreak.push_back(i);
		else Break.push_back(i);
	}

	int val = INF;
	for (int i = 0; i < notBreak.size(); i++) {
		for (int j = 0; j < Break.size(); j++) {

			int nB = notBreak[i];
			int B = Break[j];
			val = min(val, repair(visited | (1 << B), count + 1) + arr[nB][B]);
		}
	}

	return dp[visited] = val;
}



int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	memset(dp, -1, sizeof(dp));
	cin >> N;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			cin >> arr[i][j];

	string temp; cin >> temp;
	int visited = 0, count = 0;

	for (int i = 0; i < N; i++) {
		if (temp[i] == 'Y') {
			visited = visited | (1 << i);
			count++;
		}
	}
	cin >> P;



	if (count >= P) {
		cout << "0";
		return 0;
	}
	else if (count == 0) {
		cout << "-1";
		return 0;
	}
	cout << repair(visited, count);



}