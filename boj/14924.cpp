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
    int s, t, d;
    cin >> s >> t >> d;
    int temp = 2 * s;
    int temp2 = d / temp;
    cout << t * temp2;
    
}
