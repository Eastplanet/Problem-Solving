#include <iostream>
#include <vector>
#include<algorithm>
#include<stdio.h>
#include<cstring>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, m, r;
    cin >> n >> m >> r;

    int** arr = new int* [n + 1];
    for (int i = 0; i < n + 1; i++) {
        arr[i] = new int[n + 1];
        memset(arr[i], 0, sizeof(int) * (n + 1));
    }

    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            arr[i][j] = 10000000;
        }
    }

    int itemarr[101];
    for (int i = 1; i <= n; i++) {
        int mem;
        cin >> mem;
        itemarr[i] = mem;
    }

    for (int i = 0; i < r; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        arr[a][b] = c;
        arr[b][a] = c;
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] > arr[i][k] + arr[k][j])arr[i][j] = arr[i][k] + arr[k][j];
            }
        }
    }

    for (int i = 1; i <= n; i++) {
        arr[i][i] = 0;
    }

    int max = -1;
    for (int i = 1; i <= n; i++) {
        int sum = itemarr[i];
        for (int j = 1; j <= n; j++) {
            if (i == j)continue;
            if (arr[i][j] <= m)sum = sum + itemarr[j];
        }
        if (max == -1)max = sum;
        if (max < sum)max = sum;
    }
    cout << max;






    for (int i = 0; i < n + 1; i++) {
        delete arr[i];
    }
    delete arr;

}

