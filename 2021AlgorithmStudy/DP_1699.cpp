#include<iostream>
using namespace std;

int N;
int DP[100001];

int main() {

	cin >> N;

	for (int i = 1; i <= N; i++) {
		//최악의 경우, 1의 제곱으로만 되는 경우
		DP[i] = i;

		for (int j = 1; j * j <= i; j++) {
			DP[i] = min(DP[i], DP[i - j * j] + 1);
		}
		
	}

	cout << DP[N] << "\n";
}