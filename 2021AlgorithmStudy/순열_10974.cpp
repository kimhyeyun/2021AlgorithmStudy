#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
	int N;
	vector<int> v;

	cin >> N;
	for (int i = 1; i <= N; i++)
		v.push_back(i);

	do {
		for (int i = 0; i < v.size(); i++)
			cout << v[i] << " ";
		cout << "\n";
	} while (next_permutation(v.begin(), v.end()));
}