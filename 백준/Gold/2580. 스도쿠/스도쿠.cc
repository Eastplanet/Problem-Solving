#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int section[3][3] = { {1,2,3},{4,5,6},{7,8,9} };

void backtrack(int arr[10][10]) {
    int exist[10] = { };
    for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 10; j++) {
            if (arr[i][j] == 0) {
                //옆으로 있는지 확인
                for (int a = 1; a < 10; a++) {
                    exist[arr[i][a]] = 1;
                    exist[arr[a][j]] = 1;
                }

                int xSect, ySect;
                if (j <= 3)xSect = 0;
                else if (j <= 6)xSect = 1;
                else xSect = 2;
                if (i <= 3)ySect = 0;
                else if (i <= 6)ySect = 1;
                else ySect = 2;
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        int y = section[ySect][a];
                        int x = section[xSect][b];
                        exist[arr[y][x]] = 1;
                    }
                }

                for (int e = 1; e < 10; e++) {
                    if (exist[e]==0) {
                        arr[i][j] = e;
                        backtrack(arr);
                        arr[i][j] = 0;
                    }
                }
                return;
            }
        }
    }
    //0존재안함 -> 완성
    for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 10; j++) {
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }
    exit(0);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int arr[10][10];
    for (int i = 1; i < 10; i++) {
        for (int j = 1; j < 10; j++) {
            cin >> arr[i][j];
        }
    }
    backtrack(arr);
}
