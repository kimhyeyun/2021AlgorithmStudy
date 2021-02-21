#include<iostream>

#define MOD 1000000000
using namespace std;

int N;
int stairs[101][10]; //���� ������ ����, �ڴ� ������ ����

int main() {

	cin >> N;

	stairs[1][0] = 0;

	for (int i = 1; i < 10; i++)
		stairs[1][i] = 1;

	for (int i = 2; i <= N; i++) {
		for (int j = 0; j < 10; j++) {
			if (j == 0) {
				//�������� 0 �̶�� �տ� �ü� �ִ� ���ڴ� 1��
				stairs[i][0] = stairs[i - 1][1] % MOD;
			}
			else if (j == 9) {
				//�������� 9 ��� �տ� �� �� �ִ� ���ڴ� 8��
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