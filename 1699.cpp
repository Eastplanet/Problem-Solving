#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;


int dp[100001];


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    

    int N; cin >> N;
    
    dp[0] = 0;
    for (int i = 1; i <= N; i++) {
        dp[i] = i;
        for (int j = 2; j * j <= i; j++) {
            dp[i] = min(dp[i], dp[i - j * j] + 1);
        }
    }


    cout << dp[N];
    
  



}