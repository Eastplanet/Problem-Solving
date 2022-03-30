#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
#include<map>
using namespace std;
typedef pair<char, int>P;

map<char, int>ma;
vector<P> s;
string temp;
string boom;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	cin >> temp;
	cin >> boom;
	int boomSize = boom.size();
	for (int i = 0; i < boom.size(); i++) {
		ma[boom[i]] = i + 1;
	}


	for (int i = 0; i < temp.size(); i++) {

		if (s.empty()) {
			if (ma[temp[i]] == 1)s.push_back(P(temp[i], ma[temp[i]]));
			else s.push_back(P(temp[i], 0));
		}
		else {
			if (ma[temp[i]] != 0 && ma[temp[i]] != 1) {
				if (s.back().second == ma[temp[i]] - 1) {
					s.push_back(P(temp[i], ma[temp[i]]));
				}
				else {
					s.push_back(P(temp[i], 0));
				}
			}
			else {
				s.push_back(P(temp[i], ma[temp[i]]));
			}
		}

		//¹®ÀÚ¿­ Æø¹ß
		while (!s.empty() && (s.back().second == boomSize)) {
			for (int i = 0; i < boomSize; i++) {
				s.pop_back();
			}

		}
	}


	if (s.empty())cout << "FRULA";
	else {
		for (int i = 0; i < s.size(); i++) {
			cout << s[i].first;
		}
	}




}