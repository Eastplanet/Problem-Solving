#include<iostream>
#include<algorithm>
#include<unordered_map>
#include<cstring>
#include<math.h>
#include<queue>
#include<vector>

using namespace std;

long long fibo[10001];


int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int T;
	cin >> T;
	int Tcount = 1;

	fibo[2] = 1;
	fibo[1] = 1;
	

	while (T--) {
		int P, Q;
		cin >> P >> Q;
		for (int i = 3; i <= P; i++) {
			fibo[i] = fibo[i - 2] % Q + fibo[i - 1] % Q;
		}


		cout << "Case #" << Tcount << ": ";
		cout << fibo[P] % Q<<'\n';
		Tcount++;
	}
}