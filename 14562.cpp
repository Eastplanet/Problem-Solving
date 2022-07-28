#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

struct P {
    int score, count, Bscore;
};

int main() {
    ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    int T;
    cin >> T;
    while (T--) {
        int A, B;
        cin >> A >> B;


        queue<P> q;
        q.push(P{ A,0,B });

        while (!q.empty()) {
            P curr = q.front(); q.pop();
            if (curr.score == curr.Bscore) {
                cout << curr.count << "\n";
                break;
            }

            if (curr.score > curr.Bscore)continue;

            q.push(P{ curr.score + 1,curr.count+1,curr.Bscore });
            q.push(P{ curr.score * 2,curr.count+1,curr.Bscore + 3 });


        }


    }
    
}