#include<iostream>
using namespace std;

int main() {
	int N;
	
	cin >> N;

	//ó�� int���϶� Ʋ��
	long long gn = 0;

	for (int i = 1; i <= N; i++) {
		int x = N / i;

		gn += x * i;
	}

	cout << gn << "\n";
}