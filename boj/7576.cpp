#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<vector>
#include<queue>
using namespace std;

int X, Y;
int movepos[4][2]{ {0,1},{0,-1},{1,0},{-1,0} };
int arr[1000][1000];
bool isInside(int x, int y) {
    if (x < 0 || x >= X)return false;
    if (y < 0 || y >= Y)return false;
    return true;
}
bool canItmove(int x, int y) {
    if (isInside(x, y)) {
        if (arr[y][x] == -1)return false;
        return true;
    }
    return false;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> X >> Y;
    for (int i = 0; i < Y; i++) {
        for (int j = 0; j < X; j++) {
            cin >> arr[i][j];
        }
    }


    int xarr[1000000], yarr[1000000];

    int xfront = 0, xback = 0, yfront = 0, yback = 0;
    for (int i = 0; i < Y; i++) {
        a
            for (int j = 0; j < X; j++) {

                if (arr[i][j] == 1) {
                    xarr[xback] = j;
                    yarr[yback] = i;
                    xback++;
                    yback++;
                }
            }


    }
    while (xfront != xback) {
        int x, y;
        x = xarr[xfront];
        y = yarr[yfront];
        xfront++;
        yfront++;
        int gox, goy;
        for (int i = 0; i < 4; i++) {
            gox = x + movepos[i][0];
            goy = y + movepos[i][1];
            if (canItmove(gox, goy)) {
                if ((arr[goy][gox] > arr[y][x] + 1) || arr[goy][gox] == 0) {
                    arr[goy][gox] = arr[y][x] + 1;
                    xarr[xback] = gox;
                    xback++;
                    yarr[yback] = goy;
                    yback++;
                }
            }
        }
    }
    int max = 0;
    int flag = 0;
    for (int i = 0; i < Y; i++) {
        for (int j = 0; j < X; j++) {
            if (arr[i][j] > max)max = arr[i][j];
            if (arr[i][j] == 0)flag = 1;
        }
    }
    if (flag)cout << -1;
    else cout << max - 1;

}