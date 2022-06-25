#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;

string arr[16];

string join(string a) {
    string temp = a;
    temp[temp.size() - 1] = ',';
    temp += a;
    temp += "}";
    return temp;
}

int main() {
    ios::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);

    arr[0] = "{}";
    arr[1] = "{{}}";
    
    for (int i = 2; i < 16; i++) {
        arr[i] = join(arr[i - 1]);
    }

    int T;
    cin >> T;
    while (T--) {
        string a, b;
        cin >> a >> b;
        int anum, bnum;
        for (int i = 0; i < 16; i++) {
            if (arr[i] == a)anum = i;
            if (arr[i] == b)bnum = i;
        }
        cout << arr[anum + bnum] << '\n';
    }
    
}