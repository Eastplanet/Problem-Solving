#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;



int main() {
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    int arr[1001];
    //0 Áö±Ý Â÷·Ê°¡ ½Â¸® 1 Áö±Ý Â÷·Ê°¡ ÆÐ¹è
    arr[1] = 1;
    arr[2] = 0;
    arr[3] = 1;
    arr[4] = 0;
    int N; cin >> N;
    for (int i = 5; i <= N; i++) {
        if (arr[i - 1] == 1) {
            arr[i] = 0;
        }
        else if (arr[i - 3]==1) {
            arr[i] = 0;
        }
        else if (arr[i - 4]) {
            arr[i] = 0;
        }
        else {
            arr[i] = 1;
        }
    }

    if (arr[N] == 0)cout << "SK";
    else cout << "CY";
    
}