#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

long long arr[1000001];


int N;


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 4;

    for (int i = 4; i <= 1000000; i++) {
        long long temp= arr[i - 1] % 1000000009 + arr[i - 2] % 1000000009 + arr[i - 3] % 1000000009;
        arr[i] = temp % 1000000009;
    }

    int T;
    cin >> T;

    while (T--) {
        cin >> N;
        cout << arr[N] << '\n';
    }
    
    

}