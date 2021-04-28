#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<vector>
#include<queue>
using namespace std;

int X, Y, Z;
int movepos[6][3]{ {0,1,0},{0,-1,0},{1,0,0},{-1,0,0},{0,0,1},{0,0,-1} };
int arr[100][100][100];
bool isInside(int x, int y, int z) {
    if (x < 0 || x >= X)return false;
    if (y < 0 || y >= Y)return false;
    if (z < 0 || z >= Z)return false;
    return true;
}
bool canItmove(int x, int y, int z) {
    if (isInside(x, y, z)) {
        if (arr[z][y][x] == -1)return false;
        return true;
    }
    return false;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> X >> Y >> Z;
    for (int k = 0; k < Z; k++) {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                cin >> arr[k][i][j];
            }
        }
    }


    int xarr[10000000], yarr[10000000], zarr[10000000];

    int xfront = 0, xback = 0, yfront = 0, yback = 0;
    int zfront = 0, zback = 0;
    for (int k = 0; k < Z; k++) {
        for (int i = 0; i < Y; i++) {

            for (int j = 0; j < X; j++) {

                if (arr[k][i][j] == 1) {
                    xarr[xback] = j;
                    yarr[yback] = i;
                    zarr[zback] = k;
                    xback++;
                    yback++;
                    zback++;
                }
            }


        }
    }
    while (xfront != xback) {
        int x, y, z;
        x = xarr[xfront];
        y = yarr[yfront];
        z = zarr[zfront];
        xfront++;
        yfront++;
        zfront++;
        int gox, goy, goz;
        for (int i = 0; i < 6; i++) {
            gox = x + movepos[i][0];
            goy = y + movepos[i][1];
            goz = z + movepos[i][2];
            if (canItmove(gox, goy, goz)) {
                if ((arr[goz][goy][gox] > arr[z][y][x] + 1) || arr[goz][goy][gox] == 0) {
                    arr[goz][goy][gox] = arr[z][y][x] + 1;
                    xarr[xback] = gox;
                    xback++;
                    yarr[yback] = goy;
                    yback++;
                    zarr[zback] = goz;
                    zback++;
                }
            }
        }
    }
    int max = 0;
    int flag = 0;
    for (int k = 0; k < Z; k++) {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (arr[k][i][j] > max)max = arr[k][i][j];
                if (arr[k][i][j] == 0)flag = 1;
            }
        }
    }
    if (flag)cout << -1;
    else cout << max - 1;

}