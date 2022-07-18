#include<iostream>
#include<algorithm>
#include<unordered_map>
#include<cstring>
#include<math.h>
#include<queue>
#include<vector>

using namespace std;

int L, C;
char arr[15];
char aei[5] = { 'a','e','i','o','u'};
int visited[15];
int isAei[15];
int totalCount = 0;

void back(int idx, int aeiCount, int Count) {
	if (Count == L) {
		if (aeiCount < 1 || Count - aeiCount < 2)return;

		for (int i = 0; i < 15; i++) {
			if(visited[i]==1)cout << arr[i];
		}
		cout << endl;
	}
	else if (Count > L)return;

	for (int i = idx + 1; i < C; i++) {
		if (visited[i] == 1)continue;
		visited[i] = 1;

		if (isAei[i]) back(i, aeiCount+1, Count+1);
		else back(i, aeiCount, Count+1);

		visited[i] = 0;

	}
}


int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> L >> C;
	for (int i = 0; i < C; i++) { 
		cin >> arr[i]; 
	}



	sort(arr, arr + C);

	for (int i = 0; i < C; i++) {
		for (int j = 0; j < 5; j++) {
			if (arr[i] == aei[j])isAei[i] = 1;
		}
	}

	

	for (int i = 0; i < C; i++) {
		visited[i] = 1;
		if (isAei[i]) back(i, 1, 1);
		else back(i, 0, 1);
		visited[i] = 0;
	}



	
}