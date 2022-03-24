#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;



int top[4][8];

void spin(int select, int direct) {
    int temp;

    if (direct == 1) {

        temp = top[select][7];

        for (int i = 7; i > 0; i--) {
            top[select][i] = top[select][i - 1];
        }
        top[select][0] = temp;

    }
    else if (direct == -1) {

        temp = top[select][0];
        for (int i = 0; i < 7; i++) {
            top[select][i] = top[select][i + 1];
        }
        top[select][7] = temp;

    }
    else {
        cout << "error";
    }
}


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i = 0; i < 4; i++) {
        string temp;
        cin >> temp;
        for (int j = 0; j < temp.size(); j++) {
            top[i][j] = temp[j] - '0';
        }
    }

    
    int k;
    cin >> k;
    for (int i = 0; i < k; i++) {
        //1 2 3 4 선택 배열 0부터
        int select;
        cin >> select;
        select--;
        //direct 1 시계 -1 반시계
        int direct;
        cin >> direct;

        int turn[4] = {};
        
        int sign = select % 2;
        //n번째 톱니는 n%2가 sign과 같으면 direct방향으로 아니면 -1*direct방향으로

        int chain[4][4] = {};
        fill(&chain[0][0], &chain[3][4], 99999);
        if (top[0][2] != top[1][6]) {
            chain[0][1] = 1;
            chain[1][0] = 1;
        }
        if (top[1][2] != top[2][6]) {
            chain[1][2] = 1;
            chain[2][1] = 1;
        }
        if (top[2][2] != top[3][6]) {
            chain[2][3] = 1;
            chain[3][2] = 1;
        }

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 4; i++) {
                if (i == k)continue;
                for (int j = 0; j < 4; j++) {
                    if (i == j || j == k)continue;
                    if (chain[i][j] > chain[i][k] + chain[k][j]) {
                        chain[i][j] = chain[i][k] + chain[k][j];
                    }
                }
            }
        }

        chain[select][select] = 1;

        for (int i = 0; i < 4; i++) {
            if (chain[select][i] != 99999) {
                if (i % 2 == sign) {
                    spin(i, direct);
                }
                else {
                    spin(i, direct * -1);
                }
            }
        }
        


    }

    int sum = 0;
    if (top[0][0] == 1)sum += 1;
    if (top[1][0] == 1)sum += 2;
    if (top[2][0] == 1)sum += 4;
    if (top[3][0] == 1)sum += 8;
    cout << sum;
    
}