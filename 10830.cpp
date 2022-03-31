#include<iostream>
#include<vector>
#include<algorithm>


typedef long long LL;
using namespace std;
int modul = 1000;


struct arrData {
	LL val[5][5] = {};
};


int N;

arrData matrixSquare(arrData a, arrData b){
	arrData c;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			LL sum = 0;
			for (int k = 0; k < N; k++) {
				sum = (sum + (a.val[i][k] % modul) * (b.val[k][j] % modul)) % modul;
			}
			c.val[i][j]=sum;
		}
	}

	return c;
}


arrData recurFact(arrData arr , LL B){

	arrData result;
	arrData temp;
	if (B == 1) {
		return arr;
	}

	if (B % 2 == 0) {

		temp = matrixSquare(arr, arr);
		if (B == 2)return temp;
		result = recurFact(temp, B / 2);

	}
	else {

		temp = matrixSquare(arr, arr);
		if (B == 3)return matrixSquare(temp, arr);
		result = matrixSquare(recurFact(temp, B / 2),arr);

	}
	

	return result;
}


int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	arrData arr;

	LL B;
	cin >> N;
	cin >> B;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr.val[i][j];
			arr.val[i][j] %= modul;
		}
	}

	arrData result = recurFact(arr, B);

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cout << result.val[i][j] << " ";
		}
		cout << "\n";
	}



}