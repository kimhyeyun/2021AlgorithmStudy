#include<iostream>

#define MAX 100001
#define MOD 9901
using namespace std;

int ZOO[MAX][3];

int main() {
	int N;

	cin >> N;

	for(int i = 0; i < 3; i++)
		ZOO[1][i] = 1;
	

	for (int i = 2; i <= N; i++) {
		ZOO[i][0] = (ZOO[i - 1][0] + ZOO[i - 1][1] + ZOO[i - 1][2]) % MOD;
		ZOO[i][1] = (ZOO[i - 1][0] + ZOO[i - 1][2]) % MOD;
		ZOO[i][2] = (ZOO[i - 1][0] + ZOO[i - 1][1]) % MOD;
	}

	cout << (ZOO[N][0] + ZOO[N][1] + ZOO[N][2]) % MOD << "\n";

}