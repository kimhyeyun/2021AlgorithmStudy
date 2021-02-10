#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	int N;
	vector<int> v;
	
	cin >> N;

	for (int i = 1; i <= N; i++) {
		int x;
		cin >> x;
		v.push_back(x);
	}

	if (next_permutation(v.begin(), v.end())) {
		for (int i = 0; i < v.size(); i++)
			cout << v[i] << " ";
		cout << "\n";
	}

	else
		cout << -1 << "\n";
}