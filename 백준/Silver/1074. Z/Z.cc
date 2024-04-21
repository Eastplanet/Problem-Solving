#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int mynum;
void divisearch(int xlo, int xhi, int ylo, int yhi,int posy,int posx,int count) {
    //왼쪽위
    int nsize = 0;
    for (int i = xlo; i <= xhi; i++) {
        nsize++;
    }
    if (nsize == 2) {
        if (xlo == posx) {
            if (ylo == posy) {
                count = count + 1;
            }
            else count = count + 3;
        }
        else {
            if (ylo == posy) {
                count = count + 2;
            }
            else count = count + 4;
        }
        mynum = count;
        return;
    }
    int divixlo, divixhi, diviylo, diviyhi;
    int skip = 0;
    divixlo = xlo;
    divixhi = xhi-(nsize / 2);
    diviylo = ylo;
    diviyhi = yhi-(nsize / 2);
    //왼쪽?
    if (posx >= divixlo && posx <= divixhi) {
        //위?
        if (posy >= diviylo && posy <= diviyhi) {
            skip = 0;
        }
        else {
            skip = 2;
            diviylo = ylo + (nsize / 2);
            diviyhi = yhi;
        }
    }
    //오른쪽
    else {
        divixlo = (nsize / 2) + xlo;
        divixhi = xhi;
        //위?
        if (posy >= diviylo && posy <= diviyhi) {
            skip = 1;
        }
        else { 
            skip = 3;
            diviylo = ylo + (nsize / 2);
            diviyhi = yhi;
        }
    }
    int mem=0;
    for (int i = divixlo; i <= divixhi; i++) {
        mem++;
    }
    count = count + mem * mem * skip;
    divisearch(divixlo, divixhi, diviylo, diviyhi, posy, posx, count);
}



int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int n, r, c;
    cin >> n >> r >> c;
    int size = 1;
    for (int i = 0; i < n; i++) {
        size = size * 2;
    }
    divisearch(1, size, 1, size,r+1,c+1,0);
    cout << mynum-1;


}