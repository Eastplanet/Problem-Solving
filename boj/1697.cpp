#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

bool isInside(int num) {
    if (num < 0 || num>100000)return false;
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n, k;
    cin >> n >> k;
    int* arr = new int[100001];
    memset(arr, 0, sizeof(int) * 100001);
    int* visited = new int[100001];
    memset(visited, 0, sizeof(int) * 100001);
    queue <int> que;
    que.push(n);
    while (que.size() != 0) {
        int pos = que.front();

        que.pop();

        if (visited[pos] == 1)continue;
        visited[pos] = 1;
        if (pos == k)break;

        if (isInside(pos + 1)) {
            if ((arr[pos + 1] > arr[pos] + 1) || arr[pos + 1] == 0) {
                que.push(pos + 1); arr[pos + 1] = arr[pos] + 1;
            }
        }
        if (isInside(pos - 1)) {
            if ((arr[pos - 1] > arr[pos] + 1) || arr[pos - 1] == 0) {
                que.push(pos - 1); arr[pos - 1] = arr[pos] + 1;
            }
        }
        if (isInside(pos * 2)) {
            if ((arr[pos * 2] > arr[pos] + 1) || arr[pos * 2] == 0) {
                que.push(pos * 2); arr[pos * 2] = arr[pos] + 1;
            }
        }


    }
    cout << arr[k];

    delete arr;
    delete visited;
}