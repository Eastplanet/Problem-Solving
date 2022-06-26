#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N;
    cin >> N;
    int arr[1001];
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }
    int dp[1001];
    fill(&dp[0], &dp[1001], 1);

    int maxV = 1;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
                if (dp[i] < dp[j] + 1) {

                    dp[i] = dp[j] + 1;
                    if (maxV < dp[i])maxV = dp[i];
                }
            }
        }
    }

    cout << maxV;

}