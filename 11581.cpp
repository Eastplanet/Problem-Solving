#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;


const int INF = 123456789;



int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N;
    cin >> N;

    int arr[101][101];
    fill(&arr[0][0], &arr[100][101], INF);

    for (int i = 1; i <= N - 1; i++) {
        int C; cin >> C;

        for (int j = 0; j < C; j++) {
            int temp; cin >> temp;
            arr[i][temp] = 1;
        }
    }

    for (int k = 1; k <= N; k++) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] > arr[i][k] + arr[k][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
    }
    
    for (int i = 1; i <= N; i++) {
        if (arr[1][i]!=INF && arr[i][i] != INF) {
            cout << "CYCLE";
            return 0;
        }
    }

    cout << "NO CYCLE";
}