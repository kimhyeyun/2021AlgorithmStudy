#include<iostream>
#include<vector>

#define MAX 1000001

using namespace std;

//에라토스테네스의 채를 이용하지만 미리 해놓기에는 범위가 너무 많아서 
//B까지만 한 후 출력
int main() {
	vector<bool> prime(MAX, true);

	prime[1] = false;

	int A, B;
	cin >> A >> B;

	for (int i = 2; i <= B; i++) {
		for (int j = 2; i * j <= B; j++) {
			prime[i * j] = false;
		}
	}

	for (int i = A; i <= B; i++)
		if (prime[i])
			cout << i << "\n";
}
