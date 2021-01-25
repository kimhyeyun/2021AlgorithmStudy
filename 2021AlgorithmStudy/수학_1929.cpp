#include<iostream>
#include<vector>

#define MAX 1000001

using namespace std;

//�����佺�׳׽��� ä�� �̿������� �̸� �س��⿡�� ������ �ʹ� ���Ƽ� 
//B������ �� �� ���
int main() {
	vector<bool> prime(MAX, true);

	prime[1] = false;

	int A, B;
	cin >> A >> B;

	for (int i = 2; i <= B; i++) {
		for (int j = 2; i * j <= B; j++) {
			prime[i * j] = false;
		}
	}

	for (int i = A; i <= B; i++)
		if (prime[i])
			cout << i << "\n";
}
