#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>
using namespace std;


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);


    int n, k;

    cin >> n >> k;
    int arr[101];
    for (int i = 0; i < n; i++)cin >> arr[i];

    //assert
    if (n == 2)cout << "@@@@@@@@@@";

    int dp[10001] = {};
    dp[0] = 1;

    //i번째 동전을 쓸 차례
    for (int i = 0; i < n; i++) {

        for (int j = 0; j <= k; j++) {
            if (j - arr[i] >= 0)dp[j] += dp[j - arr[i]];
        }
    }

    cout << dp[k];
    


}