#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

int movepos[4][2] = { {0,1},{0,-1},{1,0},{-1,0} };
int n, m;
bool isInside(int x, int y) {
    if (x<1 || x>m)return false;
    if (y<1 || y>n)return false;
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;
    int** arr = new int* [n + 1];
    for (int i = 0; i < n + 1; i++) {
        arr[i] = new int[m + 1];
        memset(arr[i], 0, sizeof(int) * (m + 1));
    }


    int map[101][101] = { 0 };
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            map[i][j] = 1;
        }
    }

    for (int i = 1; i <= n; i++) {
        string mem;
        cin >> mem;
        for (int j = 0; j < mem.size(); j++) {
            arr[i][j + 1] = mem[j] - '0';
        }
    }


    queue <int> quex;
    queue <int> quey;
    quex.push(1);
    quey.push(1);
    map[1][1] = 1;
    while (quex.size() != 0) {

        int x = quex.front();
        int y = quey.front();
        quex.pop();
        quey.pop();
        if (y == n && x == m)break;
        int gx, gy;

        for (int i = 0; i < 4; i++) {
            gx = x + movepos[i][0];
            gy = y + movepos[i][1];
            if (isInside(gx, gy)) {
                if (arr[gy][gx] == 1) {
                    if (map[gy][gx] != 1)continue;
                    quex.push(gx);
                    quey.push(gy);
                    map[gy][gx] = map[y][x] + 1;
                }
            }
        }




    }

    cout << map[n][m];







    for (int i = 0; i < n + 1; i++) {
        delete arr[i];
    }
    delete arr;
}