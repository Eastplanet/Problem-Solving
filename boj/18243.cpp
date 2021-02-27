#include <iostream>
#include <cstring>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, k;
    cin >> n >> k;
    int** arr = new int* [n + 1];
    for (int i = 0; i < n + 1; i++) {
        arr[i] = new int[n + 1];
        memset(arr[i], 0, sizeof(int) * (n + 1));
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            arr[i][j] = 1000000;//INF
        }
    }
    for (int i = 0; i < k; i++) {
        int a1, a2;
        cin >> a1 >> a2;
        arr[a1][a2] = 1;
        arr[a2][a1] = 1;
    }
    int maxnum = 0;
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] > arr[i][k] + arr[k][j])arr[i][j] = arr[i][k] + arr[k][j];
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        int num = 0;
        for (int j = 1; j <= n; j++) {
            if (i == j)continue;
            if (num < arr[i][j])num = arr[i][j];
        }
        if (maxnum < num)maxnum = num;
    }
    if (maxnum <= 6)cout << "Small World!";
    else cout << "Big World!";



    for (int i = 0; i < n + 1; i++) {
        delete arr[i];
    }
    delete arr;
}

