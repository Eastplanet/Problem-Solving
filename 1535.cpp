#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;


int N;
int happy[20];
int hp[20];
int dp[101][20];

int rec(int now, int nowHp) {
    if (now == N) {
        if (dp[nowHp][now] == -1)return 0;
        else return dp[nowHp][N - 1];
    }
    if (dp[nowHp][now] != -1)return dp[nowHp][now];

    int val = rec(now + 1, nowHp);
    if (nowHp - hp[now] > 0) {
        val = max(val,rec(now+1, nowHp - hp[now])+happy[now]);
    }

    dp[nowHp][now] = val;
    return val;

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    
    fill(&dp[0][0], &dp[100][20], -1);

    for (int i = 0; i < N; i++) {
        cin >> hp[i];
    }
    for (int i = 0; i < N; i++) {
        cin >> happy[i];
    }

    int val = rec(0, 100);

    if (val == -1)cout << "0";
    else cout << val;

}