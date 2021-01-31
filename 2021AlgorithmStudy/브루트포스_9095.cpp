#include<iostream>
#include<vector>
using namespace std;

int N[11];

void Solve() {
	for (int i = 4; i < 11; i++) {
		N[i] = N[i - 1] + N[i - 2] + N[i - 3];
	}
}

int main() {
	int T, n;
	
	N[1] = 1;
	N[2] = 2;
	N[3] = 4;

	Solve();

	cin >> T;

	while (T--) {
		cin >> n;
		cout << N[n] << "\n";
	}
}