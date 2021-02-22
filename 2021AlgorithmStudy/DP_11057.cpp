#include<iostream>

#define MOD 10007
#define MAX 1001
using namespace std;

int N;
int NUM[MAX][10];

int main() {
	cin >> N;

	for (int i = 0; i < 10; i++)
		NUM[1][i] = 1;

	for (int i = 2; i <= N; i++) {
		for (int j = 0; j <10; j++) {
			for (int k = 0; k <= j; k++) {
				NUM[i][j] = (NUM[i][j] + NUM[i - 1][k]) % MOD;
			}
		}
	}

	int sum = 0;

	for (int i = 0; i < 10; i++)
		sum = (sum + NUM[N][i]) % MOD;

	cout << sum << "\n";
}