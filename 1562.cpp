#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

int N;
int dp[101][10][1 << 10];
int modul = 1000000000;

int stair(int leng, int num, int visited) {
    if (leng == 1) {

        if (visited == 1023) {
            return 1;
        }
        return 0;

    }

    if (dp[leng][num][visited] != -1)
        return dp[leng][num][visited];

    if (num == 0)
        return dp[leng][num][visited] = stair(leng - 1, 1, visited | (1 << (num + 1))) % modul;
    if (num == 9)
        return dp[leng][num][visited] = stair(leng - 1, 8, visited | (1 << (num - 1))) % modul;

    return dp[leng][num][visited] =
        (stair(leng - 1, num - 1, visited | (1 << (num - 1))) % modul +
            stair(leng - 1, num + 1, visited | (1 << (num + 1))) % modul) % modul;

}



int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    memset(dp, -1, sizeof(dp));
    cin >> N;


    int visited = 0;
    int val = 0;
    for (int i = 1; i <= 9; i++) {
        val = (val % modul + stair(N, i, 1 << i) % modul) % modul;
    }

    cout << val;

}