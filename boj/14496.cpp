#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
using namespace std;
int** map;
int* dis;
int* vi;
#define INF 987654321
int a, b, num, m;

int minIndex() {
    int index = 1;
    int min = INF;
    for (int i = 1; i < num + 1; i++) {
        if (!vi[i] && min > dis[i]) {
            min = dis[i];
            index = i;
        }
    }
    return index;
}

void dijkstra(int start) {
    vi[start] = 1;
    for (int i = 1; i < num + 1; i++) {
        dis[i] = map[start][i];
    }

    int current;
    for (int i = 1; i < num - 1; i++) {
        current = minIndex();
        vi[current] = 1;
        for (int j = 1; j < num + 1; j++) {
            if (!vi[j]) {
                if (dis[j] > dis[current] + map[current][j])dis[j] = dis[current] + map[current][j];

            }
        }
    }
}




int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> a >> b >> num >> m;
    map = new int* [num + 1];
    for (int i = 0; i < num + 1; i++) {
        map[i] = new int[num + 1];
        fill(map[i], map[i] + num + 1, INF);
    }
    dis = new int[num + 1];
    vi = new int[num + 1];
    fill(vi, vi + num + 1, 0);
    for (int i = 0; i < m; i++) {
        int mem, mem2;
        cin >> mem >> mem2;
        map[mem][mem2] = 1;
        map[mem2][mem] = 1;
    }

    dijkstra(a);
    if (a == b)cout << "0";
    else if (dis[b] == 987654321)cout << "-1";
    else cout << dis[b];










    for (int i = 0; i < num + 1; i++) {
        delete map[i];
    }
    delete map;
    delete dis;
    delete vi;
}