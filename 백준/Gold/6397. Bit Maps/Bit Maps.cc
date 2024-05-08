#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>
#include<map>
#include <fstream>

using namespace std;


//ifstream fin;
//ofstream fout;

char arr[201][201];

string bit(int xlow, int xhigh, int ylow, int yhigh) {
    if (xlow == xhigh && ylow == yhigh) {
        string temp;
        temp += arr[yhigh][xhigh];
        return temp;
    }

    char check = '-';
    int flag = 1;
    for (int i = ylow; i <= yhigh && flag; i++) {
        for (int j = xlow; j <= xhigh && flag; j++) {
            if (check == '-')check = arr[i][j];
            if (check != arr[i][j]) {
                flag = 0;
            }
        }
    }
    //sector all char same
    if (flag) {
        string temp;
        temp += check;
        return temp;
    }

    //divide sector
    int xleng = xhigh - xlow + 1;
    int yleng = yhigh - ylow + 1;

    int xmid = xlow - 1 + (xleng / 2);
    if (xleng % 2 == 1)xmid++;

    int ymid = ylow - 1 + (yleng / 2);
    if (yleng % 2 == 1)ymid++;

    string total = "";

    //상, 하단으로 분리
    if (xleng == 1) {
        //상단 0~ mid까지
        //mid +1 ~N 이 하단
        total += "D";
        total += bit(xlow, xhigh, ylow, ymid);
        total += bit(xlow, xhigh, ymid + 1, yhigh);
        return total;
    }
    //좌, 우로 분리
    else if (yleng == 1) {
        total += "D";
        total += bit(xlow, xmid, ylow, yhigh);
        total += bit(xmid + 1, xhigh, ylow, yhigh);
        return total;
    }
    else { // 4개로 분리
        total += "D";
        string temp = bit(xlow, xmid, ylow, ymid);
        total += temp;
        total += bit(xmid + 1, xhigh, ylow, ymid);
        total += bit(xlow, xmid, ymid + 1, yhigh);
        total += bit(xmid + 1, xhigh, ymid + 1, yhigh);
        return total;
    }



}

void revBit(int xlow, int xhigh, int ylow, int yhigh, string& str) {
    if (str.front() != 'D') {
        for (int i = ylow; i <= yhigh; i++) {
            for (int j = xlow; j <= xhigh; j++) {
                arr[i][j] = str.front();
            }
        }
        str.erase(str.begin());
    }
    else {

        str.erase(str.begin());

        //divide sector
        int xleng = xhigh - xlow + 1;
        int yleng = yhigh - ylow + 1;

        int xmid = xlow - 1 + (xleng / 2);
        if (xleng % 2 == 1)xmid++;

        int ymid = ylow - 1 + (yleng / 2);
        if (yleng % 2 == 1)ymid++;

        string total = "";

        //상, 하단으로 분리
        if (xleng == 1) {
            //상단 0~ mid까지
            //mid +1 ~N 이 하단
            revBit(xlow, xhigh, ylow, ymid, str);
            revBit(xlow, xhigh, ymid + 1, yhigh, str);

            return;
        }
        //좌, 우로 분리
        else if (yleng == 1) {
            revBit(xlow, xmid, ylow, yhigh, str);
            revBit(xmid + 1, xhigh, ylow, yhigh, str);
            return;
        }
        else { // 4개로 분리

            revBit(xlow, xmid, ylow, ymid, str);
            revBit(xmid + 1, xhigh, ylow, ymid, str);
            revBit(xlow, xmid, ymid + 1, yhigh, str);
            revBit(xmid + 1, xhigh, ymid + 1, yhigh, str);
            return;
        }

    }
}










int main() {

    //fin.open("bitmap.inp");
    //fout.open("bitmap.out");

  

    while (true) {
        char type; cin >> type;
        if (type == '#')break;



        if (type == 'B') {
            int N, M; cin >> N >> M;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    cin >> arr[i][j];
                }
            }

            string ret = bit(1, M, 1, N);

            cout << "D";
            if (N >= 100)cout << " ";
            else if (N >= 10)cout << "  ";
            else cout << "   ";
            cout << N;

            if (M >= 100)cout << " ";
            else if (M >= 10)cout << "  ";
            else cout << "   ";
            cout << M << "\n";

            int count = 0;
            for (int i = 0; i < ret.length(); i++) {
                cout << ret[i];
                count++;
                if (count == 50) {
                    count = 0;
                    cout << "\n";
                }
            }
            if(count!= 0)cout << "\n";
            //cout << ret << "\n";

        }
        else {
            int N, M; cin >> N >> M;
            string str; cin >> str;

            revBit(1, M, 1, N, str);

            cout << "B";
            if (N >= 100)cout << " ";
            else if (N >= 10)cout << "  ";
            else cout << "   ";
            cout << N;

            if (M >= 100)cout << " ";
            else if (M >= 10)cout << "  ";
            else cout << "   ";
            cout << M << "\n";

            int count = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    cout << arr[i][j];
                    count++;
                    if (count == 50) {
                        count = 0;
                        cout << "\n";
                    }
                }
            }
            if(count!=0)cout << "\n";


        }
    }

    //fin.close();
    //fout.close();
}