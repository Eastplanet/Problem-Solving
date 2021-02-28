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
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;

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

        for (int i = 1; i <= m; i++) {
            int a, b, c;
            cin >> a >> b >> c;
            arr[a][b] = c;
            arr[b][a] = c;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][k] + arr[k][j] < arr[i][j])arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            arr[i][i] = 0;
        }
        int ka;
        cin >> ka;
        int* karr = new int[ka];
        for (int i = 0; i < ka; i++) {
            cin >> karr[i];
        }
        int min = -1;
        int minnum;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < ka; j++) {
                sum = sum + arr[karr[j]][i];
            }
            if (min == -1) { min = sum; minnum = i; }
            if (min > sum) { min = sum; minnum = i; }
        }

        cout << minnum << endl;

        delete karr;

        for (int i = 0; i < n + 1; i++) {
            delete arr[i];
        }
        delete arr;
    }
}

