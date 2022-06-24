#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

int N, M;
int arr[1001][1001];
int dp[1001][1001][3];
int movePos[3] = { -1,0,1 };
const int INF = 123456789;

int moon(int n, int m, int dir) {
    if (n == -1)return 0;
    if (dp[n][m][dir] != INF)return dp[n][m][dir];
    
    int minV = INF;
    for (int i = 0; i < 3; i++) {
        if (i == dir)continue;
        if (m + movePos[i] < 0 || m + movePos[i] >= M)continue;

        minV = min(minV, moon(n - 1, m + movePos[i], i) + arr[n][m]);
    }

    dp[n][m][dir] = minV;
    
    return minV;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                dp[i][j][k] = INF;
            }
        }
    }

  
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> arr[i][j];
        }
    }

    int minV = INF;
    
    for (int j = 0; j < M; j++) {
        for (int i = 0; i < 3; i++) {
            minV = min(minV,moon(N-1, j, i));
        }
    }

    cout << minV;
    
    

}