#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;
    int k;
    cin >> k;
    int arr[2][7] = {};
    for (int i = 0; i < n; i++) {
        int a, b;
        cin >> a >> b;
        arr[a][b]++;
    }
    
    int totalRoom = 0;
    for (int i = 0; i < 2; i++) {
        for (int j = 1; j <= 6; j++) {
            int z = arr[i][j] % k;
            if (z != 0)z = 1;
            totalRoom += arr[i][j] / k + z;
        }
    }
    cout << totalRoom;
}
