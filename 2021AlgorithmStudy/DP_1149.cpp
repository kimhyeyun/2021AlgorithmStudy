#include<iostream>

#define MAX 1001
using namespace std;

int Home[MAX][3] = { 0, };
int Price[MAX][3];
int N;

int main() {
	cin >> N;

	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < 3; j++)
			cin >> Price[i][j];
	}

	for (int i = 1; i <= N; i++) {
		Home[i][0] = min(Home[i - 1][1], Home[i - 1][2]) + Price[i][0];
		Home[i][1] = min(Home[i - 1][0], Home[i - 1][2]) + Price[i][1];
		Home[i][2] = min(Home[i - 1][0], Home[i - 1][1]) + Price[i][2];
	}


	cout << min(Home[N][0], min(Home[N][1], Home[N][2])) << "\n";
}