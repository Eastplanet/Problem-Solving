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

    char a[101];
    cin >> a;
    
    for (int i = 0;a[i]!='\0'; i++) {
        
        if (a[i] >= 'A' && a[i] <= 'Z')cout << (char)(a[i]-('A'-'a'));
        else cout << (char)(a[i] + ('A' - 'a'));


    }
 

    
}