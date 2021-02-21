#include<iostream>
using namespace std;

int N;
int num[1000001] = { 0, };
int sum[1000001] = { 0, };
int ans = -1000;

int main() {

	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> num[i];

	for (int i = 0; i < N; i++) {
		sum[i] = max(sum[i - 1] + num[i], num[i]);
		ans = max(ans, sum[i]);
	}

	cout << ans << "\n";


}