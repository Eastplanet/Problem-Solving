#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;


int dp[1001];





int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int T;
    cin >> T;
    while (T--) {
        vector<char>a;
        vector<char>b;
        string tempa, tempb;
        cin >> tempa >> tempb;
        for (int i = 0; i < tempa.size(); i++)a.push_back(tempa[i]);
        for (int i = 0; i < tempb.size(); i++)b.push_back(tempb[i]);


        sort(a.begin(),a.end());
        sort(b.begin(), b.end());

        if (a.size() != b.size()) {
            cout << tempa << " & " << tempb << " are NOT anagrams." << endl;
            continue;
        }
        else {
            int flag = 0;
            for (int i = 0; i < a.size(); i++) {
                if (a[i] != b[i]) {
                    cout << tempa << " & " << tempb << " are NOT anagrams." << endl;
                    flag = 1;
                    break;
                }
            }

            if (flag)continue;
            else {
                cout << tempa << " & " << tempb << " are anagrams." << endl;
            }
        }

    }
    

    
}