#include<iostream>
#include<algorithm>
#include<unordered_map>
#include<cstring>
#include<math.h>
#include<queue>
#include<vector>

using namespace std;

int Count = 0;
const int INF = 123456789;
int N, S;
int arr[20];
int visited[20];

void back(int idx, int sum) {

	if (sum == S){
		Count++;
	}

	if (sum == INF) {
		for (int i = 0; i < N; i++) {
			visited[i] = 1;
			back(i, arr[i]);
			visited[i] = 0;
		}
	}
	else {
		for (int i = idx + 1; i < N; i++) {
			if (visited[i] == 1)continue;
			visited[i] = 1;
			back(i, sum + arr[i]);
			visited[i] = 0;
		}
	}

}




int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> N >> S;

	
	for (int i = 0; i < N; i++)cin >> arr[i];

	back(0, INF);

	cout << Count;

	
}