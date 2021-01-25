#include<iostream>
#include<vector>

#define MAX 1001

using namespace std;


//에라토스테네스의 채를 이용하여 구현
int main() {
	vector<bool> prime(MAX, true);

	prime[1] = false;

	for (int i = 2; i < MAX; i++) {
		for (int j = 2; i * j < MAX; j++) {
			prime[i * j] = false;
		}
	}

	int T, N;

	int ans = 0;

	cin >> T;
	while (T--) {
		cin >> N;
		if (prime[N])
			ans++;
	}

	cout << ans << "\n";
}
