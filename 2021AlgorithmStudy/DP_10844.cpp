#include<iostream>

#define MOD 1000000000
using namespace std;

int N;
int stairs[101][10]; //앞은 숫자의 길이, 뒤는 마지막 숫자

int main() {

	cin >> N;

	stairs[1][0] = 0;

	for (int i = 1; i < 10; i++)
		stairs[1][i] = 1;

	for (int i = 2; i <= N; i++) {
		for (int j = 0; j < 10; j++) {
			if (j == 0) {
				//마지막이 0 이라면 앞에 올수 있는 숫자는 1뿐
				stairs[i][0] = stairs[i - 1][1] % MOD;
			}
			else if (j == 9) {
				//마지막이 9 라면 앞에 올 수 있는 숫자는 8뿐
				stairs[i][9] = stairs[i - 1][8] % MOD;
			}
			else {
				stairs[i][j] = (stairs[i - 1][j - 1] + stairs[i - 1][j + 1]) % MOD;
			}
		}
	}

	int ans = 0;

	for (int i = 0; i < 10; i++) {
		ans = (ans + stairs[N][i]) % MOD;
	}

	cout << ans % MOD << "\n";
}