#include<iostream>
using namespace std;

int main() {
	int N;
	
	cin >> N;

	//처음 int형일때 틀림
	long long gn = 0;

	for (int i = 1; i <= N; i++) {
		int x = N / i;

		gn += x * i;
	}

	cout << gn << "\n";
}