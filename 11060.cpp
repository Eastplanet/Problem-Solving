#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;


typedef pair<int, int>P;
int arr[1001];
int visited[1001];
queue <P> q;




int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N; cin >> N;
    for (int i = 0; i < N; i++)cin >> arr[i];

    q.push(P(0, 0));
    visited[0] = 1;

    while (!q.empty()) {
        P curr = q.front(); q.pop();
        if (curr.first == N - 1) {
            cout << curr.second;
            return 0;
        }

        for (int i = 1; i <= arr[curr.first]; i++) {
            if (visited[curr.first + i])continue;
            visited[curr.first + i] = 1;
            q.push(P(curr.first + i, curr.second + 1));
        }
    }

    cout << "-1";
    
}