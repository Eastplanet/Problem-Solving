#include<iostream>
using namespace std;

int main() {
    int N;
    int M;
    cin >> N >> M;

    int arr[101][2];

    int packageMin = 1000000;
    int perItemMin = 1000000;
    for (int i = 0; i < M; i++) {
        cin >> arr[i][0] >> arr[i][1];
        if (arr[i][0] < packageMin)
            packageMin = arr[i][0];
        if (arr[i][1] < perItemMin)
            perItemMin = arr[i][1];
    }

    if (packageMin < perItemMin*6) {
        int count = N / 6;
        int price = count * packageMin;

        if (packageMin < perItemMin * (N % 6)) {
            price += packageMin;
        }
        else {
            price += (N % 6) * perItemMin;
        }
        cout << price;
    }
    else {
        int price = N * perItemMin;
        cout << price;
    }

}