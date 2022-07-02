#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

int dp[17][1 << 17];
int N;
int arr[17][17];
const int INF = 123456789;

int TSP(int leng, int idx, int visited) {
    if (leng == 0) {
        return 0;
    }
    if (dp[idx][visited] != -1)return dp[idx][visited];

    int val = INF;
    if (leng == 1) {
        //출발점으로 복귀 가능
        if (arr[idx][0] != 0)val = TSP(leng - 1, 0, visited) + arr[idx][0];
    }
    else {
        for (int i = 0; i < N; i++) {
            if (i == idx)continue;
            if (!(visited & (1 << i))) {
                if (arr[idx][i] != 0) {
                    val = min(val, TSP(leng - 1, i, visited | (1 << i)) + arr[idx][i]);
                }
            }
        }
    }

    return dp[idx][visited] = val;

}




int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    memset(dp, -1, sizeof(dp));
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> arr[i][j];
        }
    }



    cout << TSP(N, 0, 1);



}