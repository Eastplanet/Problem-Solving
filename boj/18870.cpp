#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <cstring>
using namespace std;




int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    cin >> n;
    int* arr = new int[n];
    map <int, int> ma;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        ma[arr[i]] = 1;
    }
    map <int, int>::iterator iter;
    int count = 0;
    for (iter = ma.begin(); iter != ma.end(); iter++) {
        iter->second = count;
        count++;
    }
    for (int i = 0; i < n; i++) {
        cout << ma[arr[i]] << " ";
    }










    delete arr;
}