#include<iostream>
#include<algorithm>
#include<vector>
#include<queue>
#include<cstring>
#include <string>

using namespace std;


int main(void)
{
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	
	int mon,day;
    cin >>mon>>day;
    
    if(mon > 2){
        cout << "After";
    }
    else if(mon == 2){
        if(day > 18){
            cout << "After";
        }
        else if(day == 18){
            cout << "Special";
        }
        else{
            cout << "Before";
        }
    }
    else{
        cout << "Before";
    }



	
}