#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;


int dp[1500001];
int T[1500001];
int P[1500001];
int N;

int job(int idx) {
    if (idx == N)return 0;
    if (dp[idx] != -1)return dp[idx];

    int val = job(idx + 1);

    if (idx + T[idx] <= N)
        val = max(val, job(idx + T[idx]) + P[idx]);
    dp[idx] = val;
    return val;
}

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> T[i] >> P[i];
    }



    fill(&dp[0], &dp[1500001], -1);

    cout << job(0);



}