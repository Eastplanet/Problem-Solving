#include<iostream>
#include<vector>
#include<algorithm>
#include<cstring>
#include<vector>
#include<queue>
using namespace std;
int N, M;
int size_;//N의 자릿수
int min_ = 1000000;
int button[10] = { 0 };//1이면고장

int check(vector<int> arr) {// 1 다'0'으로 구성
    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] != 0)return false;
    }
    return true;
}

int double_check(vector<int> arr)
{
    int flag = 0;//0일때 0이아닌수까지 탐색 1일때 0나오면 아웃
    for (int i = arr.size() - 1; i >= 0; i--) {
        if (arr[i] == 0 && flag == 1)return true;
        if (arr[i] != 0)flag = 1;
    }
    if (flag == 0)return true;
    return false;
}
//필요한거. 0이 고장났을때 00423 은 누를수 있어야하고
// 00404, 00400 은 못눌러야한다.
//0을 누를수 있게하고 나중에 걸러내는 함수 만들자
void dfs(int lv,vector<int> arr) {
    if (lv == size_ + 1) {
        if (double_check(arr)&&button[0])return;
        int buf = 1;
        int sum = 0;
        int size;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr[i] * buf;
            buf *= 10;
        }
        if (sum >= 1000000)size = 7;
        else if (sum >= 100000)size = 6;
        else if (sum >= 10000)size = 5;
        else if (sum >= 1000)size = 4;
        else if (sum >= 100)size = 3;
        else if (sum >= 10)size = 2;
        else size = 1;
        int mem = N - sum;
        if (mem < 0)mem = -mem;
        if (min_ > mem + size) {
            min_ = mem + size;
        }
    }
    else {
        for (int i = 0; i <= 9; i++) {
            if (button[i]&&i!=0)continue; 
            
            arr.push_back(i);
            dfs(lv + 1, arr);
            arr.pop_back();
        }
    }
}


int main()
{
    ios_base::sync_with_stdio(false);
     cin.tie(0);
    cout.tie(0);
    cin >> N >> M;
    for (int i = 0; i < M; i++) {
        int a;
        cin >> a;
        button[a] = 1;
    }
    if (N >= 100000)size_ = 6;
    else if (N >= 10000)size_ = 5;
    else if (N >= 1000)size_ = 4;
    else if (N >= 100)size_ = 3;
    else if (N >= 10)size_ = 2;
    else size_ = 1;
    vector<int> arr;
    dfs(0,arr);
    int mem = N - 100;
    
    if (mem < 0)mem = -mem;
    if (mem < min_)min_ = mem;
    cout << min_;

}