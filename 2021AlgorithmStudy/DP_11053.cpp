#include<iostream>
using namespace std;

int N;
int ans = 0;
int nums[1001];
int DP[1001];

int main() {
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> nums[i];
	
	for (int i = 0; i < N; i++) {
		DP[i] = 1;
		int curval = nums[i];
		for (int j = 0; j < i; j++) {
			int tmp = nums[j];
			if (tmp < curval)
				DP[i] = max(DP[i], DP[j] + 1);
		}
		ans = max(DP[i], ans);
	}

	cout << ans << "\n";
}