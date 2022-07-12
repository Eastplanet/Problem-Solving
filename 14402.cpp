#include<iostream>
#include<algorithm>
#include<map>
#include<unordered_map>

using namespace std;

unordered_map<string, int>ma;

int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int q;
	cin >> q;



	int count = 0;
	for (int i = 0; i < q; i++) {
		string name, op;
		cin >> name >> op;
		if (op == "+") {
			ma[name]++;
		}
		else {
			if (ma[name] == 0)count++;
			else ma[name]--;
		}
	}

	unordered_map<string, int>::iterator iter;
	for (iter = ma.begin(); iter != ma.end(); iter++) {
		count += iter->second;
	}

	cout << count;

}