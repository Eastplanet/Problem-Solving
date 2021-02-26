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
    //map init
    int** map = new int* [n + 1];
    for (int i = 0; i < n + 1; i++) {
        map[i] = new int[n + 1];
        memset(map[i], 0, sizeof(int) * n + 1);
    }
    //INF
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            map[i][j] = 10000;
        }
    }
    for (int i = 0; i < m; i++) {
        int mem[2];
        cin >> mem[0] >> mem[1];
        map[mem[0]][mem[1]] = 1;
        map[mem[1]][mem[0]] = 1;
    }
    int min = -1;
    int minindex = -1;
    //floyd mashal
    for (int k = 1; k <= n; k++) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int ik, kj;
                ik = map[i][k];
                kj = map[k][j];
                if (map[i][j] > (ik + kj))map[i][j] = ik + kj;
            }
        }

    }
    //cabin
    for (int k = 1; k <= n; k++) {
        int cabin = 0;
        for (int i = 1; i <= n; i++) {
            if (i == k)continue;
            cabin = cabin + map[k][i];
        }
        if (min == -1) {
            min = cabin;
            minindex = k;
        }
        else if (min > cabin) {
            min = cabin;
            minindex = k;
        }
    }
    cout << minindex;








    for (int i = 0; i < n + 1; i++) {
        delete[]map[i];
    }
    delete[]map;
}

