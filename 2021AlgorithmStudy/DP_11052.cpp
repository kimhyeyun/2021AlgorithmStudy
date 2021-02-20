#include<iostream>

#define MAX 1001
using namespace std;

int main() {
	int Card[MAX] = { 0, };
	int P[MAX];
	int N;
	
	cin >> N;

	P[0] = 0;
	for (int i = 1; i <= N; i++)
		cin >> P[i];

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			Card[i] = max(Card[i], P[j] + Card[i - j]);
		}
	}

	cout << Card[N] << "\n";
}