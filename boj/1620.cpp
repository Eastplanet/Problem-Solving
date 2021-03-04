#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;

map <string, int> ma;
map <int, string> ma2;




int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    char arr[9] = { '1','2','3','4','5','6','7','8','9' };
    int n, m;
    cin >> n >> m;
    string mem;
    for (int i = 1; i <= n; i++) {
        cin >> mem;
        ma[mem] = i;
        ma2[i] = mem;
    }
    for (int i = 0; i < m; i++) {
        cin >> mem;
        int flag = 1;//0 숫자 1글자
        for (int j = 0; j < 9; j++) {
            if (mem[0] == arr[j])flag = 0;
        }
        if (flag) {
            cout << ma[mem] << "\n";
        }
        else {
            cout << ma2[stoi(mem)] << "\n";
        }
    }
}