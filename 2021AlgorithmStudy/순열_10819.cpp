#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int N, x;
	vector<int> v;
	int m = 0;

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> x;
		v.push_back(x);
	}
	
	sort(v.begin(), v.end());

	do {
		int sum = 0;
		for (int i = 1; i < N; i++) {
			sum += abs(v[i - 1] - v[i]);
		}
		m = max(sum, m);
	} while (next_permutation(v.begin(), v.end()));

	cout << m << "\n";
}