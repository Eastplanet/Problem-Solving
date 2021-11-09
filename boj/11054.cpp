#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>

using namespace std;



int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin >> n;
    int arr[1001] = {};
    int dp[1001][2] = {};
    fill(&dp[0][0], &dp[1000][2], 1);
    for (int i = 1; i <= n; i++)cin >> arr[i];
    int maxi = -1;
    if (n == 1)maxi = 1;
    for (int i = 2; i <= n; i++) {
        int zero = 0;
        int one = 0;
        for (int j = 1; j < i; j++) {
            if (arr[i] > arr[j]) {
                if (zero < dp[j][0])zero = dp[j][0];
            }
            else if (arr[i] < arr[j]) {
                if (dp[j][0] < dp[j][1])one = max(one, dp[j][1]);
                else one = max(one, dp[j][0]);

            }
        }
        dp[i][0] = zero + 1;
        dp[i][1] = one + 1;
        if (maxi < dp[i][0])maxi = dp[i][0];
        if (maxi < dp[i][1])maxi = dp[i][1];
        //cout <<i<<"to   "<<dp[i][0]<<" "<<dp[i][1]<<"\n";

    }
    cout << maxi;
}
