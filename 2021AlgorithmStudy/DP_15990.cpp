#include<iostream>

#define MAX 100001
#define MOD 1000000009
using namespace std;

long long DP[MAX][4] = { 0, };

int main() {
	int T;
	int N;
	
	cin >> T;

	DP[1][1] = 1;
	DP[2][2] = 1;

	DP[3][1] = 1;
	DP[3][2] = 1;
	DP[3][3] = 1;

	for (int i = 4; i <= MAX; i++) {
		DP[i][1] = (DP[i - 1][2] + DP[i - 1][3])%MOD;
		DP[i][2] = (DP[i - 2][1] + DP[i - 2][3])%MOD;
		DP[i][3] = (DP[i - 3][1] + DP[i - 3][2])%MOD;
	}

	while (T--) {
		cin >> N;
		cout << (DP[N][1] + DP[N][2] + DP[N][3]) % MOD << "\n";
	}
}