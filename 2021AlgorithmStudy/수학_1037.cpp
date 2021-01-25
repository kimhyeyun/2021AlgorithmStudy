#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int n, x;

	vector<int> factor;

	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> x;
		factor.push_back(x);
	}
	
	if (factor.size() > 2)
		sort(factor.begin(), factor.end());

	int num = factor[0];
	int num2 = factor.back();

	cout << num * num2 << "\n";

	
}