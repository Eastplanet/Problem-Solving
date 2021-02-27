#include <iostream>
#include <cstring>
#include <vector>
#include<algorithm>
using namespace std;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    cin >> n;
    int** arr = new int* [n + 1];
    for (int i = 0; i < n + 1; i++) {
        arr[i] = new int[n + 1];
        memset(arr[i], 0, sizeof(int) * (n + 1));
    }
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            arr[i][j] = 1000;
        }
    }

    for (int i = 0;; i++) {
        int f1, f2;
        cin >> f1 >> f2;
        if (f1 == -1 && f2 == -1)break;
        arr[f1][f2] = 1;
        arr[f2][f1] = 1;
    }

    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int mem1, mem2;
                mem1 = arr[i][k];
                mem2 = arr[k][j];
                if (arr[i][j] > (mem1 + mem2))arr[i][j] = mem1 + mem2;
            }
        }
    }
    vector <int> ap;
    int min = -1;

    for (int i = 1; i <= n; i++) {
        int max = -1;
        for (int j = 1; j <= n; j++) {
            if (i == j)continue;
            if (max == -1) {
                max = arr[i][j];
            }
            else if (max < arr[i][j])max = arr[i][j];
        }
        if (min == -1) {
            min = max;
            ap.push_back(i);
        }
        else if (min > max) {
            min = max;
            ap.erase(ap.begin(), ap.end());
            ap.push_back(i);
        }
        else if (min == max) {
            ap.push_back(i);
        }
    }
    sort(ap.begin(), ap.end());

    cout << min << " " << ap.size() << endl;
    for (int i = 0; i < ap.size(); i++) {
        cout << ap[i] << " ";
    }




    for (int i = 0; i < n + 1; i++) {
        delete arr[i];
    }
    delete arr;
}

