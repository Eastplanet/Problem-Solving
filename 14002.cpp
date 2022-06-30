#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

int arr[1001];
int dp[1001];
int visited[1001];
int maxroot;


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N; cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
        dp[i] = 1;
    }



    int max = 1;

    for (int i = 0; i < N; i++) {
        for (int prev = 0; prev < i; prev++) {
            if (arr[i] > arr[prev]) {
                if (dp[i] < dp[prev] + 1) {
                    visited[i] = prev;
                    dp[i] = dp[prev] + 1;
                    if (max < dp[i]) {
                        maxroot = i;
                        max = dp[i];
                    }
                }
            }
        }
    }

    cout << max << '\n';

    int next = maxroot;
    vector<int>v;
    for (int i = 0; i < max; i++) {
        v.push_back(arr[maxroot]);
        maxroot = visited[maxroot];
    }

    for (int i = v.size() - 1; i >= 0; i--) {
        cout << v[i] << " ";
    }


}