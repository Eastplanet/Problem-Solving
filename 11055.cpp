#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N; int arr[1001]; cin >> N;

    int dp[1001];
    int max = 0;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
        dp[i] = arr[i];
        if (max < arr[i])max = arr[i];
    }




    for (int i = 0; i < N; i++) {
        for (int prev = 0; prev < i; prev++) {
            if (arr[i] > arr[prev]) {
                if (dp[i] < dp[prev] + arr[i]) {
                    dp[i] = dp[prev] + arr[i];
                    if (max < dp[i])max = dp[i];
                }
            }
        }
    }

    cout << max;
}