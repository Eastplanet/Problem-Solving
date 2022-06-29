#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

int T, W;
int arr[1001];
int dp[1001][31][2];

int zadoo(int idx, int move, int tree) {
    if (idx == T)return 0;
    if (dp[idx][move][tree] != -1)return dp[idx][move][tree];

    int val;
    if (arr[idx] == tree) val = zadoo(idx + 1, move, tree) + 1;
    else val = zadoo(idx + 1, move, tree);

    if (move > 0) {
        int nexttree = (tree == 1) ? 2 : 1;

        if (arr[idx] == tree) val = max(val, zadoo(idx + 1, move - 1, nexttree));
        else val = max(val, zadoo(idx + 1, move - 1, nexttree) + 1);
    }

    dp[idx][move][tree] = val;
    return val;
}


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    cin >> T >> W;
    for (int i = 0; i < T; i++)cin >> arr[i];
    fill(&dp[0][0][0], &dp[1000][30][2], -1);


    cout << zadoo(0, W, 1);


}