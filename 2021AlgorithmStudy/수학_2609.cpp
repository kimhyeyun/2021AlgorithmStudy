#include<iostream>
using namespace std;

//ó������ gcd�� ����������� ������ �߾��µ� segmentation falut ������ �߻� -> �Լ��� ���ÿ� ��� ���̸鼭 �޸� �ʰ�
int gcd(int x, int y) {
	while (1) {
		int a = x / y;
		int b = x % y;

		if (b == 0)
			return y;
		else {
			x = y;
			y = b;
		}
	}
}

int main() {
	int x, y;
	cin >> x >> y;

	int g = gcd(x, y);


	int l = (x * y) / g;

	cout << g << "\n" << l << "\n";
}