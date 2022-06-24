#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

int N;
int dp[1001][10];

int pass(int leng, int now) {
    if (leng == 1)return 1;
    if (dp[leng][now] != -1)return dp[leng][now];

    int val;

    switch (now)
    {
    case 0:
        val = pass(leng - 1, 7) % 1234567;
        dp[leng][now] = val;
        return val;
    case 1:
        val = pass(leng - 1, 2)%1234567 + pass(leng - 1, 4) % 1234567;
        dp[leng][now] = val % 1234567;
        return dp[leng][now];
    case 2:
        val = pass(leng - 1, 1) % 1234567 + pass(leng - 1, 3) % 1234567 + pass(leng - 1, 5) % 1234567;
        dp[leng][now] = val % 1234567;
        return dp[leng][now];
    case 3:
        val = pass(leng - 1, 2) % 1234567 + pass(leng - 1, 6) % 1234567;
        dp[leng][now] = val % 1234567;
        return dp[leng][now];
    case 4:
        val = pass(leng - 1, 1) % 1234567 + pass(leng - 1, 5) % 1234567 + pass(leng - 1, 7) % 1234567;
        dp[leng][now] = val % 1234567;
        return dp[leng][now];
    case 5:
        val = pass(leng - 1, 2) % 1234567 + pass(leng - 1, 4) % 1234567 + pass(leng - 1, 6) % 1234567 + pass(leng - 1, 8) % 1234567;
        dp[leng][now] = val % 1234567;
        return dp[leng][now];
    case 6:
        val = pass(leng - 1, 3) % 1234567 + pass(leng - 1, 5) % 1234567 + pass(leng - 1, 9) % 1234567;
        dp[leng][now] = val % 1234567;
        return dp[leng][now];
    case 7:
        val = pass(leng - 1, 4) % 1234567 + pass(leng - 1, 8) % 1234567 + pass(leng - 1, 0) % 1234567;
        dp[leng][now] = val % 1234567;
        return dp[leng][now];
    case 8:
        val = pass(leng - 1, 5) % 1234567 + pass(leng - 1, 7) % 1234567 + pass(leng - 1, 9) % 1234567;
        dp[leng][now] = val % 1234567;
        return dp[leng][now];
    case 9:
        val = pass(leng - 1, 6) % 1234567 + pass(leng - 1, 8) % 1234567;
        dp[leng][now] = val % 1234567;
        return dp[leng][now];
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    fill(&dp[0][0], &dp[1000][10], -1);

    int T;
    cin >> T;
    while (T--) {
        int N;
        cin >> N;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum % 1234567 + pass(N, i) % 1234567) % 1234567;
        }
        cout << sum << '\n';
    }
    

}