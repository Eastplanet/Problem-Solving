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
    int arr[101] = {};
    int arrm[101] = {};
    int n;
    cin >> n;
    
    while (n--) {
        int k;
        cin >> k;
        if (k >= 0)arr[k]++;
        else arrm[-k]++;
    }
    int v;
    cin >> v;
    if (v >= 0)cout << arr[v];
    else cout << arrm[-v];
}
