#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);



    while (true) {
        long long A, B;
        cin >> A >> B;
        if (A == 0 && B == 0)break;


        if (A > B)cout << "Yes\n";
        else cout << "No\n";
    }






}