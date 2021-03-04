#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;
int papernum[3];

void cutpaper(int x, int y, int size, int** arr) {
    int check = arr[y][x];
    for (int i = y; i < y + size; i++) {
        for (int j = x; j < x + size; j++) {
            if (check != arr[i][j])check = 2;
        }
    }
    if (check == 2) {
        cutpaper(x, y, size / 3, arr);
        cutpaper(x + size / 3, y, size / 3, arr);
        cutpaper(x + (size / 3) * 2, y, size / 3, arr);

        cutpaper(x, y + size / 3, size / 3, arr);
        cutpaper(x + size / 3, y + size / 3, size / 3, arr);
        cutpaper(x + (size / 3) * 2, y + size / 3, size / 3, arr);

        cutpaper(x, y + (size / 3) * 2, size / 3, arr);
        cutpaper(x + size / 3, y + (size / 3) * 2, size / 3, arr);
        cutpaper(x + (size / 3) * 2, y + (size / 3) * 2, size / 3, arr);
    }
    else {
        if (check == -1)papernum[2]++;
        else papernum[check]++;
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

    cutpaper(0, 0, n, arr);
    cout << papernum[2] << "\n" << papernum[0] << "\n" << papernum[1];




    for (int i = 0; i < n; i++) {
        delete arr[i];
    }
    delete arr;

}