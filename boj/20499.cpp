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
    int k, d, a;
    char z;
    cin >> k >> z >> d >> z >> a;
    if (k + a < d || d == 0)cout << "hasu";
    else cout << "gosu";
}
