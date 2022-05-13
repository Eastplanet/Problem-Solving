#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>

using namespace std;

int movepos[6][3] = { {0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0} };

int L, R, C;
char arr[31][31][31];
int visited[31][31][31];

bool canMove(int x, int y, int z) {
    if (x < 0 || x >= C)return false;
    if (y < 0 || y >= R)return false;
    if (z < 0 || z >= L)return false;
    if (arr[z][y][x] == '.' || arr[z][y][x] == 'E')return true;
    return false;
}

typedef struct {
    int z, y, x, d;
}P;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    while (true) {
        fill(&visited[0][0][0], &visited[30][30][31], 0);
        cin >> L >> R >> C;
        if (L == 0 && R == 0 && C == 0)break;
        queue <P> q;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    cin >> arr[i][j][k];
                    if (arr[i][j][k] == 'S') {
                        visited[i][j][k] = 1;
                        q.push(P{ i,j,k,0 });
                    }
                }
            }
        }
        int flag = 1;
        while (!q.empty()) {
            P curr = q.front(); q.pop();
            if (arr[curr.z][curr.y][curr.x] == 'E') {
                flag = 0;
                cout << "Escaped in " << curr.d << " minute(s).\n";
            }

            for (int i = 0; i < 6; i++) {
                int gox, goy, goz;
                gox = curr.x + movepos[i][0];
                goy = curr.y + movepos[i][1];
                goz = curr.z + movepos[i][2];
                if (canMove(gox, goy, goz)) {
                    if (visited[goz][goy][gox])continue;
                    visited[goz][goy][gox] = 1;
                    q.push(P{ goz,goy,gox,curr.d + 1 });
                }
            }

        }
        if (flag == 1)cout << "Trapped!\n";
    }



}