#include<iostream>
#include<vector>

//outofbounds ��Ÿ�� ������ ��� �� 
//���� : MAX���� ����� ������ ���� �� ������...
#define MAX 1000000

using namespace std;

//17427�� ���� ������� �ϴ� ���ó� �ð��ʰ� �߻�
// �Է¹ް� ���ϰ� ����ϴ� ��ĺ��ٴ� �̸� MAX���� ���س��� ����ϴ� ���� �� ����
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(false);

	vector<long long> f(MAX + 1,1);
	vector<long long> d(MAX + 1, 0);

	d[1] = 1;

	for (int i = 2; i <= MAX; i++) {
		for (int j = 1; i * j <= MAX; j++) {
			f[i * j] += i;
		}
	}

	for (int i = 2; i <= MAX; i++) {
		d[i] = d[i - 1] + f[i];
	}

	int T,N;

	cin >> T;

	while (T--) {
		cin >> N;

		//long long gn = 0;

		//for (int i = 1; i <= N; i++) {
		//	int x = N / i;

		//	gn += x * i;
		//}

		//cout << gn << "\n";

		cout << d[N] << "\n";
	}
}