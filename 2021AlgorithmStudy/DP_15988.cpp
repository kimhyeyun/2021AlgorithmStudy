#include<iostream>

#define MOD 1000000009
using namespace std;

long long DP[1000001];

int main() {
	int T, N;

	DP[1] = 1;
	DP[2] = 2;
	DP[3] = 4;

	for (int i = 4; i < 1000001; i++) {
		DP[i] = (DP[i - 1] + DP[i - 2] + DP[i - 3]) % MOD;
	}

	cin >> T;

	while (T--) {
		cin >> N;
		cout << DP[N] % MOD << "\n";

	}
}