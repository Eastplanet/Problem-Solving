#include <iostream>
#include <cstring>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, m;
    cin >> n >> m;
    int** arr = new int* [n + 1];
    for (int i = 0; i < n + 1; i++) {
        arr[i] = new int[n + 1];
        memset(arr[i], 0, sizeof(int) * (n + 1));
    }
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            arr[i][j] = -1;
        }
    }

    for (int i = 0; i < m; i++) {
        int m1, m2, cost;
        cin >> m1 >> m2 >> cost;
        if (arr[m1][m2] != -1 && arr[m1][m2] < cost)continue;
        arr[m1][m2] = cost;
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            if (k == i)continue;
            for (int j = 1; j <= n; j++) {
                if (k == j)continue;
                if (i == j)continue;
                int mem1, mem2;
                mem1 = arr[i][k];
                mem2 = arr[k][j];
                if (mem1 == -1 || mem2 == -1)continue;
                if (arr[i][j] == -1)arr[i][j] = mem1 + mem2;
                else if (arr[i][j] > (mem1 + mem2))arr[i][j] = mem1 + mem2;
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (arr[i][j] == -1)cout << "0" << " ";
            else cout << arr[i][j] << " ";
        }
        cout << endl;
    }







    for (int i = 0; i < n + 1; i++) {
        delete arr[i];
    }
    delete arr;
}

