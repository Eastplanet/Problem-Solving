#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include <string>

using namespace std;


string arr;
int N;
long long minV = 12345678911;
long long maxV  = 0;

long long change(string a) {
    long long sum = 0;
    for (int i = 0; i < a.size(); i++) {
        sum *= 10;
        sum = sum + (a[i] - '0');
    }
    return sum;
}

string revChange(long long a) {
    string temp;

    temp = to_string(a);
    
    if (temp.size() == N) {
        string temp2;
        temp2 += "0";
        temp2 += temp;
        return temp2;
    }
    else {
        return temp;
    }
}

void sub(string a) {
    if (a.size() == N + 1) {
        long long val = change(a);
        if (val > maxV)
            maxV = val;

        if (val < minV)minV = val;
        return;
    }
    
    if (a.size() == 0) {
        for (int i = 0; i < 10; i++) {
            string temp = a;
            temp += (i + '0');
            sub(temp);
        }
    }
    else {
        int visited[10] = {};
        for (int i = 0; i < a.size(); i++) {
            visited[(a[i] - '0')] = 1;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i] == 1)continue;

            int idx = a.size() - 1;
            if (idx == -1)idx = 0;
            int prev = (a[idx] - '0');
            char cmp = arr[idx];

            if (cmp == '>') {
                if (prev > i) {
                    visited[i] = 1;
                    string temp = a;
                    temp += (i + '0');
                    sub(temp);
                    visited[i] = 0;
                }
            }
            else {
                if (prev < i) {
                    visited[i] = 1;
                    string temp = a;
                    temp += (i + '0');
                    sub(temp);
                    visited[i] = 0;
                }
            }

        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < N; i++) {
        char temp;
        cin >> temp;
        arr += temp;
    }
    if (arr == "<") {
        cout << "123123" << '\n';
        cout << "123123" << '\n';
    }

    string temp = "";

    sub(temp);

    cout << revChange(maxV) << '\n';
    cout << revChange(minV) << '\n';


}