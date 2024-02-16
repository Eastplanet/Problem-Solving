#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int maxi = 0;
int r, c;

char arr[21][21];
int movepos[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
int canigo(int x, int y) {//r=y c=x
    if (x < 0 || x >= c)return false;
    else if (y < 0 || y >= r)return false;
    return true;
}



void maxilooter(int x, int y, int lot[26], int length) {

    if (maxi < length )maxi = length ;
    lot[arr[y][x] - 'A'] = 1;
    for (int i = 0; i < 4; i++) {
        int gox = x + movepos[i][0];
        int goy = y + movepos[i][1];
        if (canigo(gox, goy)) {
            int mem = arr[goy][gox] - 'A';
            if (lot[mem] == 0) {
                maxilooter(gox, goy, lot, length + 1);
            }

        }
    }
    lot[arr[y][x] - 'A'] = 0;




}




int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> r >> c;
    for (int i = 0; i < r; i++) {
        string mem;
        cin >> mem;
        for (int j = 0; j < mem.size(); j++) {
            arr[i][j] = mem[j];
        }
    }

    int lot[26] = { 0 };

    maxilooter(0, 0, lot, 1);
    cout << maxi;


}
