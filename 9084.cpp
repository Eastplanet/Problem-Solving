#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

int N, M;
int arr[21];
int dp[21][10001];

int coin(int idx, int nowVal) {
    if (idx == N) {
        if (nowVal == 0)return 1;
        else return 0;
    }
    if (dp[idx][nowVal] != -1)return dp[idx][nowVal];

    int val = 0;
    for (int i = 0; i < 10001; i++) {
        if (nowVal - arr[idx] * i >= 0)val += coin(idx + 1, nowVal - arr[idx] * i);
        else break;
    }
    
    return dp[idx][nowVal] = val;

}


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int T; cin >> T;


    while (T--) {
        fill(&dp[0][0], &dp[20][10001], -1);
        cin >> N;
        for (int i = 0; i < N; i++)cin >> arr[i];
        cin >> M;
        cout << coin(0, M)<<'\n';
    }


}