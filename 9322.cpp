#include<iostream>
#include<algorithm>
#include<unordered_map>
#include<cstring>

using namespace std;



int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int T; cin >> T;
	while (T--) {
		unordered_map<string, int>ma;
		int change[1001];
		string tran[1001];

		int n; cin >> n;


		for (int i = 1; i <= n; i++) {
			string key1; cin >> key1;
			ma[key1] = i;
		}
		for (int i = 1; i <= n; i++) {
			string key2; cin >> key2;
			change[i] = ma[key2];
			//change[a] = b; --> a번째 단어를 b 번째로 옮겨야 함
		}
		for (int i = 1; i <= n; i++) {
			string temp; cin >> temp;
			tran[change[i]] = temp;
		}

		for (int i = 1; i <= n; i++) {
			cout << tran[i] << " ";
		}
		cout << "\n";
	}





}