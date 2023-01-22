#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <queue>

using namespace std;

char arr[1001];
int dp[1001];

const int INF = 123456789;

bool isValid(char curr,char next) {
    if (curr == 'B' && next == 'O')return true;
    if (curr == 'O' && next == 'J')return true;
    if (curr == 'J' && next == 'B')return true;
    
    return false;
}


int main()
{

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    fill(&dp[0], &dp[1001], INF);

    int N; cin >> N;
    for (int i = 1; i <= N; i++)cin >> arr[i];

    dp[1] = 0;

    for (int i = 1; i <= N; i++) {
        for (int j = i + 1; j <= N; j++) {
            if (!isValid(arr[i], arr[j])) continue;

            if (dp[j] > dp[i] + (j - i) * (j - i)) {
                dp[j] = dp[i] + (j - i) * (j - i);
            }
        }
    }

    if (dp[N] == INF)cout << "-1";
    else cout << dp[N];
   


    


    
    
    
}