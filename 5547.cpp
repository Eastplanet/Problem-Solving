#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>

using namespace std;


typedef pair<int, int>P;

int arr[101][101];
int movePos[6][2] = { {0,1},{0,-1},{1,0},{1,1},{-1,0},{-1,-1} };
int W, H;

P calAdjIdx(int x, int y,int pos) {
    P idx;

    //문제에선 홀수
    if (y % 2 == 1) {
        switch (pos)
        {
        case 0:
            idx.first = x;
            idx.second = y - 1;
            break;
        case 1:
            idx.first = x + 1;
            idx.second = y - 1;
            break;
        case 2:
            idx.first = x + 1;
            idx.second = y;
            break;
        case 3:
            idx.first = x + 1;
            idx.second = y + 1;
            break;
        case 4:
            idx.first = x;
            idx.second = y + 1;
            break;
        case 5:
            idx.first = x - 1;
            idx.second = y;
            break;
        }
    }
    else {
        switch (pos)
        {
        case 0:
            idx.first = x - 1;
            idx.second = y - 1;
            break;
        case 1:
            idx.first = x;
            idx.second = y - 1;
            break;
        case 2:
            idx.first = x + 1;
            idx.second = y;
            break;
        case 3:
            idx.first = x;
            idx.second = y + 1;
            break;
        case 4:
            idx.first = x - 1;
            idx.second = y + 1;
            break;
        case 5:
            idx.first = x - 1;
            idx.second = y;
            break;
        }
    }

    return idx;
}

bool canMove(int x, int y) {

    if (x <= 0 || x > W)return false;
    if (y <= 0 || y > H)return false;
    return true;
}
//

int calLeng(int x, int y) {
    

    int sum = 0;

    int gox, goy;
    for (int i = 0; i < 6; i++) {
        P next = calAdjIdx(x, y, i);
        gox = next.first;
        goy = next.second;
        
        if (canMove(gox, goy) == false) {
            sum++;
        }
        else if (arr[goy][gox] == -1) {
            sum++;
        }
    }

    return sum;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    
    cin >> W >> H;
    

    for (int i = 1; i <= H; i++) {
        for (int j = 1; j <= W; j++) {
            cin >> arr[i][j];
        }
    }

    queue <P> q;

    int visited[101][101] = { };

    for (int i = 1; i <= H; i++) {
        for (int j = 1; j <= W; j++) {
            if (i == 1 || i == H || j == 1 || j == W) {

                if (arr[i][j] == 1 || arr[i][j]==-1)continue;

                q.push(P(j, i));
                

                while (!q.empty()) {
                    P cur = q.front();
                    q.pop();
                    arr[cur.second][cur.first] = -1;
                    visited[cur.second][cur.first] = 1;

                    for (int i = 0; i < 6; i++) {
                        P next = calAdjIdx(cur.first, cur.second, i);
                        int gox, goy;
                        gox = next.first;
                        goy = next.second;

                        if (canMove(gox, goy)&&arr[goy][gox]==0){
                            if (visited[goy][gox] == 1)continue;
                            if (arr[goy][gox] == 0) {
                                q.push(P(gox, goy));
                                visited[goy][gox] = 1;
                            }
                        }
                            
                    }

                }


            }
        }
    }

    int totalLeng = 0;
    for (int i = 1; i <= H; i++) {
        for (int j = 1; j <= W; j++) {
            if (arr[i][j] == 1) totalLeng += calLeng(j, i);
        }
    }

    cout << totalLeng;



  
    
}