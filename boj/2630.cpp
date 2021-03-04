#include <iostream>
#include <algorithm>
#include <vector>
#include<cstring>
using namespace std;
int color[2] = { 0 };//Èò,ÆÄ

void cutPaper(int x, int y, int size, int** arr) {
    int check = 0;
    check = arr[y][x];
    for (int i = y; i < y + size; i++) {
        for (int j = x; j < x + size; j++) {
            if (check != arr[i][j])check = -1;
        }
    }
    if (check == -1) {
        cutPaper(x, y, size / 2, arr);
        cutPaper(x + size / 2, y, size / 2, arr);
        cutPaper(x, y + size / 2, size / 2, arr);
        cutPaper(x + size / 2, y + size / 2, size / 2, arr);
    }
    else {
        color[check]++;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    cin >> n;
    int** arr = new int* [n];
    for (int i = 0; i < n; i++) {
        arr[i] = new int[n];
        memset(arr[i], 0, sizeof(int) * n);
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    cutPaper(0, 0, n, arr);
    cout << color[0] << "\n";
    cout << color[1];






    for (int i = 0; i < n; i++) {
        delete arr[i];
    }
    delete arr;
}