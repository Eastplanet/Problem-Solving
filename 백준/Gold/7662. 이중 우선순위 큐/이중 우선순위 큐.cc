#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int T;
    cin >> T;
    while (T--) {
        map<int, int> ma;
        int k;
        cin >> k;
        for (int i = 0; i < k; i++) {
            char com;
            int val;
            cin >> com >> val;
            if (com == 'I') {
                ma[val]++;
            }
            else {
                if (ma.empty())continue;
                if (val == 1) {//최댓값 삭제
                    map<int, int>::reverse_iterator riter;
                    riter = ma.rbegin();
                    if (riter->second == 1)ma.erase(riter->first);
                    else ma[riter->first]--;
                }
                else {
                    map<int, int>::iterator iter;
                    iter = ma.begin();
                    if (iter->second == 1)ma.erase(iter->first);
                    else ma[iter->first]--;
                }
            }
        }
        if (ma.empty()) {
            cout << "EMPTY" << "\n";
        }
        else {
            map<int, int>::reverse_iterator riter;
            riter = ma.rbegin();
            cout << riter->first << " ";
            map<int, int>::iterator iter;
            iter = ma.begin();
            cout << iter->first << "\n";
        }
    }
}