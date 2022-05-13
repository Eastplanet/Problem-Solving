#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;

int arr[1000001];

int find(int n) {
    if (arr[n] < 0)return n;
    else return arr[n] = find(arr[n]);
}

void merge(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b)return;

    if (arr[a] < arr[b]) {
        arr[a] += arr[b];
        arr[b] = a;
    }
    else {
        arr[b] += arr[a];
        arr[a] = b;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;
    int count = 1;
    while (T--) {
        cout << "Scenario " << count << ":\n";
        int N, K;
        fill(arr, arr + 1000001, -1);
        cin >> N >> K;
        for (int i = 0; i < K; i++) {
            int a, b;
            cin >> a >> b;
            merge(a, b);
        }

        int m;
        cin >> m;
        for (int i = 1; i <= m; i++) {
            int u, v;
            cin >> u >> v;
            u = find(u);
            v = find(v);

            if (u == v)cout << 1 << '\n';
            else cout << 0 << '\n';
        }
        count++;
        cout << "\n";
    }
}