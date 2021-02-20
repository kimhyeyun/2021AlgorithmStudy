#include<iostream>

#define MAX 1001
#define MOD 10007
using namespace std;

int main() {
	int N;
	int Board[MAX];

	cin >> N;
	
	Board[1] = 1;
	Board[2] = 3;

	for (int i = 3; i <= N; i++) {
		Board[i] = (Board[i - 1] + 2 * Board[i - 2]) % MOD;
	}

	cout << Board[N] << "\n";
}