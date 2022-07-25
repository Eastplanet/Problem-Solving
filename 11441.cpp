#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;



int nu[100001];


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N;
    cin >> N;
    nu[0] = 0;
    for (int i = 1; i <= N; i++) {
        int temp; cin >> temp;
        if (i == 1)nu[i] = temp;
        else nu[i] = nu[i - 1] + temp;
    }

    int K; cin >> K;
    for (int i = 0; i < K; i++) {
        int a, b; cin >> a >> b;
        cout << nu[b] - nu[a - 1] << "\n";
    }
    
}