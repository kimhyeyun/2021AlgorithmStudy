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

	//K���� N�� ���� �� �ִ� ����� ���� = K-1���� 0~N-1�� ���� ����� ���� ��ģ ��
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