#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;



int main() {
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    int arr[1001];
    //1 ÀÚ±â Â÷·Ê¿¡ ½Â¸®
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 0;
    arr[3] = 1;
    arr[4] = 1;
    long long N; cin >> N;
    for (int i = 5; i <= 6; i++) {
        if (arr[i - 1] == 0) {
            arr[i] = 1;
        }
        else if (arr[i - 3]==0) {
            arr[i] = 1;
        }
        else if (arr[i - 4]==0) {
            arr[i] = 1;
        }
        else {
            arr[i] = 0;
        }
    }

    N = N % 7;
    if (arr[N] == 0)cout << "CY";
    else cout << "SK";
    
}