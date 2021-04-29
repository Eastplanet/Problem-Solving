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
int baby[2];//[y][x] �����ġ
int babysize = 2;
int babyfeed = 0;
int movepos[4][2] = { {0,1},{0,-1},{1,0},{-1,0} };
int visited[20][20]; //�湮Ȯ��


bool isInside(int x, int y) {
    if (x < 0 || x >= N)return false;
    if (y < 0 || y >= N)return false;
    return true;
}
//��ǥ���� ���� ������, ũ�Ⱑ �۰ų� ������ Ȯ��
bool canigo(int x, int y) {
    if (isInside(x, y)) {
        if (space[y][x] <= babysize)return true;
        else return false;
    }
    else return false;
}
//������ �ִ� ���� ����� ��� ��ǥ�� �� ��������,���� ���� ��ǥ�� ����� �Դ´�.
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
            if (space[i][j] == 9) { //�Ʊ����� ������ġ ���
                baby[0] = i;
                baby[1] = j;
            }
        }
    }

    while (true) {
        vector <int> posx, posy, posdis; //�� ��ǥ���� ťó�� �ڷγְ� ������ ����
        vector <int> goalx, goaly, goaldis; //���� �� �ִ� ��ǥ�� ����
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) { //�湮 �迭 �ʱ�ȭ
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

            if (space[y][x] != 0 && space[y][x] != 9) { //xy��ǥ�� ������� ���
                if (space[y][x] < babysize) { // ������ �������
                    if (goalx.empty() || goaldis.back() >= dis) { //����Ȱ� ������ �ְ� ����Ȱ� ������ ����� �Ÿ��� ���ƾ���
                        goalx.push_back(x);
                        goaly.push_back(y);
                        goaldis.push_back(dis);
                    }
                    else { //����� �Ÿ����� ���� BFS����
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

        int index = search(goalx, goaly, goaldis); //����� ������ �ִ� ���̵��� ���尡����,�����̸�,������ ����� Ž��
        if (index == -1)break; //����� ����Ⱑ 0�̸� ����
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