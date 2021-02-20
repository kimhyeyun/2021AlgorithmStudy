#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	int N;
	vector<int> DP;

	cin >> N;

	DP.push_back(0);
	DP.push_back(0);

	for (int i = 2; i <= N; i++) {
		DP.push_back(DP[i - 1] + 1);

		if (i % 2 == 0)
			DP[i] = min(DP[i / 2]+1, DP[i]);
		if (i % 3 == 0)
			DP[i] = min(DP[i / 3]+1, DP[i]);
	}

	cout << DP[N] << "\n";
}