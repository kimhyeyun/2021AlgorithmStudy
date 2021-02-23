#include<iostream>

#define MAX 1001
using namespace std;

int NUM[MAX];
int DP[MAX];

int main() {
	int N;
	int max = 0;
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> NUM[i];

	for (int i = 0; i < N; i++) {
		DP[i] = NUM[i];
		for (int j = 0; j < i; j++) {
			if (NUM[i] > NUM[j] && DP[i]<DP[j]+NUM[i]) {
				DP[i] = DP[j] + NUM[i];
			}
		}

		if (max < DP[i])
			max = DP[i];
	}

	cout << max << "\n";

}