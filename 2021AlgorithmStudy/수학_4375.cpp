#include<iostream>
using namespace std;

int main() {
	int n;

	//*** ��� Ʋ���� ���� while(!cin.eof()) �� �ߴµ� �������� �ѹ��� ���ڰ� ��µ�`	

	while (cin>>n) {
		int x = 1;

		//Ʋ��;;; �ƿ� ó�� ���� n���� mod�� ������ �����ϴ°� ������
		/*if (n < 10)
			x = 2;
		else if (n < 100)
			x = 3;
		else if (n < 1000)
			x = 4;
		else
			x = 5;

		long long tmp = 0;
		for (int i = 1; i <= x; i++) {
			tmp = tmp * 10 + 1;
		}*/
		
		long long tmp = 1;
		
		while (1) {
			if (tmp % n == 0)
				break;
			else {
				/*tmp = tmp * 10 + 1;*/
				// ���� ���� �ϴ� tmp�� �ʹ� Ŀ���� �ð��ʰ��߻�
				tmp = (tmp * 10) % n + 1;
				//���� ����
				x++;
			}
		}

		cout << x << "\n";
	}
}