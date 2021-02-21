#include<iostream>
using namespace std;

int main() {
	int N;
	long long FB[91][2];

	cin >> N;

	FB[1][0] = 0;
	FB[1][1] = 1;

	for (int i = 2; i <= N; i++) {
		FB[i][0] = FB[i - 1][1] + FB[i - 1][0];
		FB[i][1] = FB[i - 1][0];
	}

	cout << FB[N][1] + FB[N][0] << "\n";
}