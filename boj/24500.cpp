#include<iostream>
#include<algorithm>
#include<vector>
#include<map>
using namespace std;

int arr[100000];
int flip[100000];
int bitSize = 0;

void tran(unsigned long long N) {
	if (N == 0) {
		arr[bitSize] = 0;
		bitSize++;
		return;
	}

	while (N > 0) {
		if (N % 2 == 1) {
			N = N / 2;
			arr[bitSize] = 1;
		}
		else {
			N = N / 2;
			arr[bitSize] = 0;
		}
		bitSize++;
	}



}

void bitflip() {
	for (int i = 0; i < bitSize; i++) {
		if (arr[i] == 0) {
			flip[i] = 1;
		}
		else {
			flip[i] = 0;
		}
	}
}

unsigned long long reTran() {
	unsigned long long sum = 0;
	unsigned long long gop = 1;

	for (int i = 0; i < bitSize; i++) {
		if (flip[i] == 1) {
			sum = sum + gop * flip[i];
			gop = gop * 2;
		}
		else {
			gop = gop * 2;
		}
	}

	return sum;
}



int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	unsigned long long N;
	cin >> N;

	tran(N);



	int flag = 1;

	for (int i = 0; i < bitSize; i++) {
		if (arr[i] == 0) {
			flag = 0;
			break;
		}
	}

	if (flag == 1) {
		cout << 1 << '\n';
		cout << N;
		return 0;
	}

	bitflip();

	unsigned long long result = reTran();


	cout << 2 << '\n';
	cout << result << " " << N;







}