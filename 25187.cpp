#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>

using namespace std;



//같은 경우 교환 X
//


int arr[100001];

int u[100001];

int find(int a) {
    if (u[a] < 0)return a;
    return u[a] = find(u[a]);
}

void merge(int a, int b) {
    a = find(a);
    b = find(b);

    if (a == b)return;

    if (u[a] < u[b]) {
        arr[a] += arr[b];
        arr[b] = 0;
        u[a] += u[b];
        u[b] = a;
        
    }
    else {
        arr[b] += arr[a];
        arr[a] = 0;
        u[b] += u[a];
        u[a] = b;
    }
}

int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    fill(&u[0], &u[100001], -1);

   
    int N; cin >> N;
    int M; cin >> M;
    int Q; cin >> Q;

    for (int i = 1; i <= N; i++) {
        cin >> arr[i];
        if (arr[i] == 0)arr[i] = -1;
    }

    for (int i = 0; i < M; i++) {
        int a, b;
        cin >> a >> b;
        merge(a, b);
    }

    for (int i = 0; i < Q; i++) {
        int temp;
        cin >> temp;
        int result = find(temp);
        if (arr[result] > 0)cout << "1\n";
        else cout << "0\n";
    }

    


    
    
    
}