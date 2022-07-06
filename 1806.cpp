#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;


int arr[100001];


int main(void)

{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int N, S; cin >> N >> S;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}


	int start = 0, end = 0;
	int min = 1234567;

	int nowVal = 0;
	nowVal += arr[end];
	while (start != N) {

		if (nowVal >= S) {
			if (min > end - start + 1)min = end - start + 1;

			nowVal -= arr[start];
			start++;


		}
		else {

			if (end != N - 1) {
				end++;
				nowVal += arr[end];
			}
			else {
				break;
			}
		}



	}

	if (min == 1234567)cout << "0";
	else cout << min;

}

