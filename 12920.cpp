#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

int itemCount = 0;
int N, M;
int weight[3000], happy[3000];
int dp[3000][10001];

int backpack(int now, int nowWei) {
    if (now == itemCount)return 0;
    if (dp[now][nowWei] != -1)return dp[now][nowWei];

    int val = backpack(now + 1, nowWei);
    if (nowWei - weight[now] >= 0)
        val = max(val, backpack(now + 1, nowWei - weight[now]) + happy[now]);

    dp[now][nowWei] = val;
    return val;
}

int main() {
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    fill(&dp[0][0], &dp[2999][10001] , -1);
    cin >> N >> M;

    
    for (int i = 0; i < N; i++) {
        int w, h, c;
        cin >> w >> h>> c;
        int k = 1;
        while (c > 0) {
            if (c > k) {
                c = c - k;
                weight[itemCount] = k * w;
                happy[itemCount] = k * h;
                itemCount++;
                k = k * 2;
            }
            else {
                
                weight[itemCount] = c * w;
                happy[itemCount] = c * h;
                itemCount++;
                c = c - c;
            }
        }
    }
    

    int val = backpack(0, M);
    cout << val;

}