#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int arr[30000];
    int c;
    cin >> c;
    for (int i = 0; i < c; i++) {
        cin >> arr[i];
    }
    int max = 0;
    for (int i = 0; i < c; i++) {
        int sum = 0;
        for (int j = i; j < c; j++) {
            if (i == j)continue;
            if (arr[i] > arr[j])sum = sum + 1;
            if (arr[i] < arr[j])break;
        }
        if (max < sum)max = sum;
    }
    cout << max;
}