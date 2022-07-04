#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;


int dp[1001];


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);


    int N; cin >> N;

    dp[1] = 1; //현재 차례가 승리
    dp[2] = 0; //현재 차례가 패배
    dp[3] = 1;
    dp[4] = 1;
    for (int i = 5; i <= N; i++) {
        if (dp[i - 1] == 0)dp[i] = 1;
        if (dp[i - 3] == 0)dp[i] = 1;
        if (dp[i - 4] == 0)dp[i] = 1;
    }

    //assert
    if (N <= 5)cout << "-1";

    if (dp[N])cout << "SK";
    else cout << "CY";






}