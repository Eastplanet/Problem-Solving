#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;

int arr[9][9];

vector<int> getAbleMin(int x, int y) {
	int visited[10] = {};
	int tempx, tempy;
	tempx = x / 3;
	tempy = y / 3;
	int xpos=0, ypos=0;
	vector<int> vec;
	xpos += 3 * tempx;
	ypos += 3 * tempy;

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			int val = arr[i + ypos][j + xpos];
			visited[val] = 1;
		}
	}

	for (int i = 0; i < 9; i++) {
		int val = arr[y][i];
		visited[val] = 1;
		val = arr[i][x];
		visited[val] = 1;
	}

	for (int i = 1; i < 10; i++) {
		if (visited[i] == 0)vec.push_back(i);
	}

	return vec;

}


bool canInsert(int x, int y,int num) {
	int visited[10] = {};
	x = x / 3;
	y = y / 3;
	int xpos = 0, ypos = 0;
	xpos += 3 * x;
	ypos += 3 * y;

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			int val = arr[i + ypos][j + xpos];
			visited[val] = 1;
		}
	}

	for (int i = 0; i < 9; i++) {
		int val = arr[ypos][i];
		visited[val] = 1;
		val = arr[i][xpos];
		visited[val] = 1;
	}

	
	if (visited[num] == 1)return false;
	return true;

	

}

void sudoku() {


	int flag = 1;
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (arr[i][j] == 0) {
				flag = 0;
				vector<int> vec = getAbleMin(j, i);

				for (int k = 0; k < vec.size(); k++) {
					arr[i][j] = vec[k];
					sudoku();
					arr[i][j] = 0;
				}

				return;
			}
		}
	}

	if (flag) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cout << arr[i][j];
			}
			cout << "\n";
		}
		exit(0);
	}
}



int main(void)

{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	for (int i = 0; i < 9; i++) {
		string temp; cin >> temp;
		
		for (int j = 0; j < 9; j++) {
			arr[i][j] = temp[j] - '0';
		}
	}

	sudoku();


}

