#include<iostream>
#include<vector>
#include<algorithm>


using namespace std;
typedef pair<int, int>P;
vector<P> adj[10001];
int maxLeng = 0;

int dfs(int root) {
	
	//터미널 노드일 경우
	if (adj[root].empty()) {
		return 0;
	}

	int max = 0, max2 = 0;
	
	for (int i = 0; i < adj[root].size(); i++) {
		int temp = dfs(adj[root][i].first) + adj[root][i].second;
		if (max < temp) {

			if (max2 < max) {
				max2 = max;
			}

			max = temp;
		}
		else if (max2 < temp) {
			max2 = temp;
		}
	}

	if (maxLeng < max + max2) {
		maxLeng = max + max2;
	}



	return max;

}




int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
 
	int n;
	cin >> n;


	for (int i = 0; i < n-1; i++) {
		int pa, ch, val;
		cin >> pa >> ch >> val;
		//adj[부모] = P(자식,가중치)
		adj[pa].push_back(P(ch, val));
	}

	int max = dfs(1);

	cout << maxLeng;





}