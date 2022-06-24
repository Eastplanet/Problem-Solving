#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

int N;
int arr[1001];
int dp[1001] = {};



int main() {
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++)cin >> arr[i];

    fill(&dp[0], &dp[1001], 1);

    int max = 1;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[j] > arr[i]) {
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (max < dp[i])max = dp[i];
                }
            }
        }
    }
   
    cout << max;
}