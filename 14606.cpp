#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <stack>

using namespace std;

typedef pair<int, int>P;




int main()
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	stack <int> s;
	int N;
	cin >> N;
	
	int arr[11] = {};
	
	for (int i = 2; i <= N; i++) {
		arr[i] = i - 1 + arr[i - 1];
	}

	cout << arr[N];

}