#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>
#include <math.h>

using namespace std;

double distCal(int x1, int y1, int x2, int y2) {
    return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}


int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int N;
    cin >> N;
    int xpos[1001];
    int ypos[1011];
    for (int i = 0; i < N; i++) {
        cin >> xpos[i] >> ypos[i];
    }

    double minLongestDist = 123123123;
    int minx, miny;

    for (int i = 0; i < N; i++) {
        double max = 0;
        for (int j = 0; j < N; j++) {
            if (i == j)continue;
            double val = distCal(xpos[i], ypos[i], xpos[j], ypos[j]);
            if (max < val)max = val;
        }
        if (minLongestDist > max) {
            minLongestDist = max; 
            minx = xpos[i];
            miny = ypos[i];
        }
    }

    cout << minx << " " << miny;

    
    
}