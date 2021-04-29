#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<vector>
#include<queue>
using namespace std;
int N;
int space[20][20];
int time_ = 0;
int baby[2];//[y][x] 상어위치
int babysize = 2;
int babyfeed = 0;
int movepos[4][2] = { {0,1},{0,-1},{1,0},{-1,0} };
int visited[20][20]; //방문확인


bool isInside(int x, int y) {
    if (x < 0 || x >= N)return false;
    if (y < 0 || y >= N)return false;
    return true;
}
//좌표값이 범위 밖인지, 크기가 작거나 같은지 확인
bool canigo(int x, int y) {
    if (isInside(x, y)) {
        if (space[y][x] <= babysize)return true;
        else return false;
    }
    else return false;
}
//먹을수 있는 가장 가까운 모든 좌표들 중 가장위쪽,가장 왼쪽 좌표의 물고기 먹는다.
int search(vector<int> goalx, vector<int> goaly, vector<int> goaldis) {
    if (goaly.size() == 0)return -1;
    int minx, miny, minindex, mindis;
    mindis = goaldis[0];
    for (int i = 0; i < goaldis.size(); i++) {
        if (mindis >= goaldis[i]) {
            mindis = goaldis[i];
            minindex = i;
        }
    }
    miny = goaly[0];
    for (int i = 0; i < goaly.size(); i++) {
        if (miny >= goaly[i] && mindis == goaldis[i]) { miny = goaly[i]; minindex = i; }
    }
    minx = goalx[0];
    for (int i = 0; i < goalx.size(); i++) {
        if ((goaly[i] == miny && minx > goalx[i]) && mindis == goaldis[i]) {
            minx = goalx[i];
            minindex = i;
        }
    }
    return minindex;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> space[i][j];
            if (space[i][j] == 9) { //아기상어의 최초위치 기억
                baby[0] = i;
                baby[1] = j;
            }
        }
    }

    while (true) {
        vector <int> posx, posy, posdis; //갈 좌표들을 큐처럼 뒤로넣고 앞으로 빼고
        vector <int> goalx, goaly, goaldis; //먹을 수 있는 좌표들 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) { //방문 배열 초기화
                visited[i][j] = 0;
            }
        }
        posx.push_back(baby[1]);
        posy.push_back(baby[0]);
        posdis.push_back(0);


        while (!posx.empty()) { //BFS
            int x, y;
            int dis;
            x = posx[0];
            y = posy[0];
            dis = posdis[0];
            posx.erase(posx.begin());
            posy.erase(posy.begin());
            posdis.erase(posdis.begin());
            if (visited[y][x])continue;
            visited[y][x] = 1;

            if (space[y][x] != 0 && space[y][x] != 9) { //xy좌표가 물고기일 경우
                if (space[y][x] < babysize) { // 먹을수 있을경우
                    if (goalx.empty() || goaldis.back() >= dis) { //저장된게 없으면 넣고 저장된게 있으면 저장된 거리와 같아야함
                        goalx.push_back(x);
                        goaly.push_back(y);
                        goaldis.push_back(dis);
                    }
                    else { //저장된 거리보다 길경우 BFS종료
                        break;
                    }
                    continue;

                }
            }






            int gox, goy;
            for (int i = 0; i < 4; i++) { //BFS
                gox = x + movepos[i][0];
                goy = y + movepos[i][1];
                if (canigo(gox, goy)) {
                    posx.push_back(gox);
                    posy.push_back(goy);
                    posdis.push_back(dis + 1);
                }
            }
        }

        int index = search(goalx, goaly, goaldis); //저장된 먹을수 있는 먹이들중 가장가깝고,위쪽이며,왼쪽인 물고기 탐색
        if (index == -1)break; //저장된 물고기가 0이면 종료
        space[baby[0]][baby[1]] = 0;
        space[goaly[index]][goalx[index]] = 9;
        time_ = time_ + goaldis[index];
        baby[0] = goaly[index];
        baby[1] = goalx[index];
        babyfeed++;
        if (babyfeed == babysize) {
            babyfeed = 0;
            babysize++;
        }







    }
    cout << time_;
}