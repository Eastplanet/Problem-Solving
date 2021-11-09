#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <stack>

using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;
    while (n--) {
        string a, b;
        cin >> a >> b;
        int ar[26] = {}, br[26] = {};
        for (int i = 0; i < a.length(); i++)ar[a[i] - 'a']++;
        for (int i = 0; i < b.length(); i++)br[b[i] - 'a']++;
        int flag = 1;
        for (int i = 0; i < 26; i++) {
            if (ar[i] != br[i])flag = 0;
        }
        if (flag)cout << "Possible" << "\n";
        else cout << "Impossible" << "\n";
    }
}
