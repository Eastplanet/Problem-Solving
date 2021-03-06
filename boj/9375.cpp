#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
using namespace std;



int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--) {
        map<string, int>ma;
        int total = 1;
        int n;
        cin >> n;
        for (int i = 0; i < n; i++) {
            string a, b;
            cin >> a >> b;
            ma[b]++;
        }
        map<string, int>::iterator iter;
        for (iter = ma.begin(); iter != ma.end(); iter++) {
            total = total * (iter->second + 1);
        }
        total--;
        cout << total << "\n";
    }

}