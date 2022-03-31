#include<iostream>
#include<vector>
#include<algorithm>


typedef long long LL;
using namespace std;



LL arr[100001];
int N;

int findIdx(int idx) {
	LL val = arr[idx];
	LL fVal = -val;

	int start = 0;
	int end = N - 1;
	int mid = (start + end) / 2;


	while (start <= end) {

		if (end - start <= 2) {
			LL min = 10000000000;
			int minIdx;
			for (int i = start; i <= end; i++) {
				if (i == idx)continue;
				if (abs(fVal - arr[i]) < min) {
					min = abs(fVal - arr[i]);
					minIdx = i;
				}
			}
			return minIdx;
		}


		if (arr[mid] == fVal) {
			return mid;
		}
		else if (arr[mid] < fVal) {
			start = mid;
			mid = (start + end) / 2;
			
		}
		else {
			end = mid;
			mid = (start + end) / 2;
		}
	}

}




int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	LL min = 10000000000;
	int minIdx1,minIdx2;

	for (int i = 0; i < N; i++) {
		int fIdx = findIdx(i);
		if (abs(arr[i] + arr[fIdx]) < min) {
			min = abs(arr[i] + arr[fIdx]);
			minIdx1 = i;
			minIdx2 = fIdx;


		}
	}

	cout << arr[minIdx1] << " " << arr[minIdx2];




}