#include<iostream>

#define MAX 501
using namespace std;

int Triangle[MAX][MAX];

int main() {
	int N;

	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j <= i; j++) {
			cin >> Triangle[i][j];
		}
	}

	for (int i = 1; i < N; i++) {
		for (int j = 0; j <= i; j++) {
			if (j == 0)
				Triangle[i][j] += Triangle[i - 1][j];
			else if (j == i)
				Triangle[i][j] += Triangle[i - 1][j - 1];
			else {
				Triangle[i][j] += max(Triangle[i - 1][j - 1], Triangle[i - 1][j]);
			}
		}
	}

	int ans = 0;

	for (int i = 0; i < N; i++)
		ans = max(ans, Triangle[N - 1][i]);

	cout << ans << "\n";
}