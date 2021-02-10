#include<iostream>
using namespace std;

#define MAX 21
int N, S;
int num[MAX];
int cnt = 0;

void Solve(int idx, int sum) {
	sum += num[idx];

	if (idx >= N)
		return;
	if (sum == S) 
		cnt++;

	Solve(idx + 1, sum - num[idx]);
	Solve(idx + 1, sum);
}

int main() {
	cin >> N >> S;

	for (int i = 0; i < N; i++)
		cin >> num[i];

	Solve(0, 0);

	cout << cnt << "\n";
}