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
    int left = 0, right = n - 1;
    sort(&arr[0], &arr[n]);
    int c = 0;
    while (left < right) {
        if (arr[left] + arr[right] == x) { c++; right--; }
        else if (arr[left] + arr[right] > x) { right--; }
        else { left++; }
    }
    cout << c;
}
