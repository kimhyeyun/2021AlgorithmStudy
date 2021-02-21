#include<iostream>

#define MOD 1000000000
#define MAX 201
using namespace std;

int N, K;
long long DP[MAX][MAX];  

int main() {
	cin >> N >> K;

	for (int i = 0; i <= N; i++)
		DP[1][i] = 1;

	//K개로 N을 만들 수 있는 경우의 수는 = K-1개로 0~N-1을 만든 경우의 수를 합친 것
	for (int i = 2; i <= K; i++) {
		for (int j = 0; j <= N; j++) {
			for (int k = 0; k <= j; k++) {
				DP[i][j] += DP[i - 1][k];
			}
			DP[i][j] %= MOD;
		}
	}

	cout << DP[K][N] << "\n";
}