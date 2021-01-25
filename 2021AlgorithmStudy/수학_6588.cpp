#include<iostream>
#include<vector>

#define MAX 1000001

using namespace std;

int main() {
	std::cin.tie(NULL);
	std::ios::sync_with_stdio(0);
	vector<bool> prime(MAX, true);

	prime[1] = false;

	//이전문제와 다른 방식의 에라토스테네스의 체 
	for (int i = 2; i*i < MAX; i++) {
		if (!prime[i])
			continue;

		for (int j = i*i; j < MAX; j+=i) {
			prime[j] = false;
		}
	}

	int N;

	while (1) {
		cin >> N;

		bool flag = true;

		if (N == 0)
			break;
		
		else {
			for (int i = 3; i < N; i++) {
				if (prime[i] && prime[N - i]) {
					cout << N << " = " << i << " + " << N-i << "\n";
					flag = false;
					break;
				}
			}
			if (flag)
				cout << "Goldbach's conjecture is wrong." << "\n";
		}
	}

}