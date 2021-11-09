#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>

using namespace std;


int arr[100000];
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    for (int i = 0; i < n; i++)cin >> arr[i];
    int x;
    cin >> x;
    sort(&arr[0], &arr[n]);
    int c = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] + arr[j] == x)c++;
            else if (arr[i] + arr[j] > x)break;
        }
    }
    cout << c;

}
