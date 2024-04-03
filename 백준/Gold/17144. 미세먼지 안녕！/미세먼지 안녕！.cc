#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int movePos[4][2] = { {0,1},{1,0},{0,-1},{-1,0} };
int arr[50][50];
int R, C, T;
typedef pair <int, int> P;
bool canMove(int y, int x) {
    if (y < 0 || y >= R)return false;
    if (x < 0 || x >= C)return false;
    if (arr[y][x] == -1)return false;
    return true;
}



int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    vector<P> airClear;
    cin >> R >> C >> T;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == -1) {
                airClear.push_back(make_pair(i, j));
            }
        }
    }
    while (T--) {
        queue<P> q;
        int sumarr[50][50] = {};
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != -1 && arr[i][j] != 0)q.push(make_pair(i, j));
            }
        }
        while (!q.empty()) {
            P p = q.front();
            q.pop();
            int count = 0;
            int dust = arr[p.first][p.second] / 5;
            int goy, gox;
            for (int i = 0; i < 4; i++) {
                goy = p.first + movePos[i][0];
                gox = p.second + movePos[i][1];
                if (canMove(goy, gox)) {
                    count++;
                    sumarr[goy][gox] += dust;
                }
            }
            dust = dust * count;
            arr[p.first][p.second] -= dust;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] += sumarr[i][j];
            }
        }




        int airX, airY;
        airY = airClear[0].first;
        airX = airClear[0].second;

        arr[airY - 1][airX] = 0;

        while (airY != 0) {
            arr[airY][airX] = arr[airY - 1][airX];
            airY--;
        }
        while (airX != C - 1){
            arr[airY][airX] = arr[airY][airX + 1];
            airX++;
        }
        while (airY != airClear[0].first) {
            arr[airY][airX] = arr[airY + 1][airX];
            airY++;
        }
        while (airX != airClear[0].second-1) {
            arr[airY][airX] = arr[airY][airX - 1];
            airX--;
        }
        arr[airClear[0].first][airClear[0].second] = -1;

        airY = airClear[1].first;
        airX = airClear[1].second;
        arr[airY + 1][airX] = 0;
        while (airY != R - 1) {
            arr[airY][airX] = arr[airY + 1][airX];
            airY++;
        }
        while (airX != C - 1) {
            arr[airY][airX] = arr[airY][airX + 1];
            airX++;
        }
        while (airY != airClear[1].first) {
            arr[airY][airX] = arr[airY - 1][airX];
            airY--;
        }
        while (airX != airClear[1].second - 1) {
            arr[airY][airX] = arr[airY][airX - 1];
            airX--;
        }
        arr[airClear[1].first][airClear[1].second] = -1;







    }
    int sum = 0;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (arr[i][j] != -1)sum += arr[i][j];
        }
    }
    cout << sum;



}
