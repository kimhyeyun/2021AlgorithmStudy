#include<iostream>
#include<string>
#include<math.h>
using namespace std;

int main() {
	string N;
	cin >> N;

	int len = N.length();

	//N�� �� �ڸ� ����� 
	if (len == 1) {
		cout << N << "\n";
	}

	else {
		int ans = 0;
		
		//N�� �ڸ��� -1 �� ���̸� ���� ���ڵ��� ���̸� ������
		//ex. N = 120 len = 3 �̸�
		// 1~99 ������ ���
		for (int i = 1; i < len; i++) {
			ans += (i * (9 * pow(10, i - 1)));
		}

		//100~120�� ���� ���
		int num = stoi(N);
		int tmp = pow(10, len - 1);

		ans += (len * (num - tmp + 1));

		cout << ans << "\n";
	}

}
