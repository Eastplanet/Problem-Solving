#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>
#include <math.h>

using namespace std;

typedef pair<int, int>P;

P connect[100001];
int disconnect[100001];
int linearDisconnect[100001];

int u[100001];

int find(int a) {
    if (u[a] < 0)return a;
    return u[a] = find(u[a]);
}

unsigned long long merge(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b)return 0;
    if (u[a] < u[b]) {
        int temp = u[a];
        int temp2 = u[b];
        u[a] += u[b];
        u[b] = a;
        return (unsigned long long)temp * (unsigned long long)temp2;
    }
    else {
        int temp = u[a];
        int temp2 = u[b];
        u[b] += u[a];
        u[a] = b;
        return (unsigned long long)temp * (unsigned long long)temp2;
    }
}


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N, M, Q; cin >> N >> M >> Q;

    fill(&u[0], &u[100001], -1);


    
    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        connect[i + 1] = P{ a,b };
    }

    for (int i = 0; i < Q; i++) {
        int temp; cin >> temp;
        linearDisconnect[i] = temp;
        disconnect[temp] = 1;
    }

    for (int i = 1; i <= M; i++) {
        if (disconnect[i] == 1)continue;
        
        merge(connect[i].first, connect[i].second);
    }

    unsigned long long sum = 0;

    for (int i = Q - 1; i >= 0; i--) {
        int idx = linearDisconnect[i];
        unsigned long long val = merge(connect[idx].first, connect[idx].second);
        sum += val;
    }

    cout << sum;
    
}