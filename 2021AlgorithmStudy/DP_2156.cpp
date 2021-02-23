#include<iostream>

#define MAX 10001
using namespace std;

int Wine[MAX] = { 0, };
int DP[MAX] = { 0, };

int main() {
	int N;

	cin >> N;

	for (int i = 1; i <= N; i++)
		cin >> Wine[i];

	DP[1] = Wine[1];
	DP[2] = Wine[1] + Wine[2];

	for (int i = 3; i <= N; i++) {
		DP[i] = max(DP[i - 2] + Wine[i], Wine[i] + Wine[i - 1] + DP[i - 3]);
		DP[i] = max(DP[i], DP[i - 1]);
	}

	int answer = 0;

	for (int i = 1; i <= N; i++)
		answer = max(answer, DP[i]);

	cout << answer << "\n";
}