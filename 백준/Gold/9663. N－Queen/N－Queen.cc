#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int movepos[8][2] = { {0,1},{1,0},{0,-1},{-1,0},{-1,1},{1,-1},{-1,-1},{1,1} };
int n;
int ncount = 0;

void debug(int arr[15][15]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << arr[i][j];
        }
        cout << "\n";
    }
}

int canigo(int x,int y,int arr[15][15]){
    if (x < 0 || x >= n)return false;
    else if (y < 0 || y >= n)return false;
    return true;
}

void putqueen(int x, int y,int arr[15][15],char tag) {
    int gox, goy;
    if (tag == '+') {
        arr[y][x]++;
        for (int i = 0; i < 8; i++) {
            gox = x + movepos[i][0];
            goy = y + movepos[i][1];
            for (;;) {
                if (canigo(gox, goy, arr))arr[goy][gox]++;
                else break;
                gox = gox + movepos[i][0];
                goy = goy + movepos[i][1];
               
            }
        }
    }
    else if (tag == '-') {
        arr[y][x]--;
        for (int i = 0; i < 8; i++) {
            gox = x + movepos[i][0];
            goy = y + movepos[i][1];
            for (;;) {
                if (canigo(gox, goy, arr))arr[goy][gox]--;
                else break;
                gox = gox + movepos[i][0];
                goy = goy + movepos[i][1];

            }
        }
    }
}


void nqueen(int nowqueencount, int column, int arr[15][15]) {
    if (nowqueencount == n) { ncount++; return; }
    for (int i = 0; i < n; i++) {
        if (arr[column][i] == 0) {
            putqueen(i, column, arr, '+');
            nqueen(nowqueencount + 1, column + 1, arr);
            putqueen(i, column, arr, '-');
        }
    }
}


int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
   
    cin >> n;
    int arr[15][15] = { 0 };
    nqueen(0, 0, arr);
    cout << ncount;
}