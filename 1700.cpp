#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N;
    cin >> N;
    int K;
    cin >> K;
    int arr[101];
    int search[101];
    for (int i = 0; i < K; i++)cin >> arr[i];
    int count = 0;

   


    vector <int> v;
    for (int i = 0; i < K; i++) {

        if (v.empty()) {
            v.push_back(arr[i]);
            continue;
        }
        else {
            int flag = 0;
            for (int item : v) {
                if (item == arr[i]) {
                    flag = 1;
                }
            }
            if(flag==1)continue;
        }

        if (v.size() != N) {
            v.push_back(arr[i]);
            continue;
        }
        else {
            fill(&search[0], &search[101], 1000);
            for (int j = i; j < K; j++) { 
                if(search[arr[j]] > j)search[arr[j]] = j; 
            }
            int max = 0;
            int maxIdx;

            for (int item : v) {
                if (max < search[item]) {
                    max = search[item];
                    maxIdx = item;
                }
            }

            for (int j = 0; j < v.size();j++) {
                if (v[j] == maxIdx) {
                    v.erase(v.begin() + j);
                    count++;
                    v.push_back(arr[i]);
                    break;
                }
            }
        }

    }

    cout << count;


}