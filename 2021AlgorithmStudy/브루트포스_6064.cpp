#include<iostream>
using namespace std;

//�ù���... ���� Ʋ�� x,y �� M,N�� ���� �� �� �ִ� ��찡 ����..
int gcd(int M, int N) {
	if (M > N) {
		while (1) {
			int a = M / N;
			int b = M % N;

			if (b == 0)
				return N;
			else {
				M = N;
				N = b;
			}
		}
	}
	else {
		while (1) {
			int a = N / M;
			int b = N % M;

			if (b == 0)
				return M;
			else {
				N = M;
				M = b;
			}
		}
	}
}
//
//int main() {
//	int T;
//	cin >> T;
//	
//	while (T--) {
//		int M, N, x, y;
//		cin >> M >> N >> x >> y;
//
//		int lastyear = (M * N) / gcd(M, N);
//		int Year;
//			bool flag = false;
//
//			if (x > M || y > N)
//				cout << -1 << "\n";
//
//			else if (x == y)
//				cout << x << '\n';
//
//		else {
//			for (int m = (lastyear - x) / (M+1); m > 0; m--) {
//				Year = (M+1) * m + x;
//				/*for (int n = (lastyear - y) / N; n > 0; n--) {
//					if (Year == N * n + y) {
//						flag = true;
//						break;
//					}
//				}*/
//				
//				if ((Year - y) % (N+1) == 0) {
//					flag = true;
//					break;
//				}
//			}
//
//			if (flag)
//				cout << Year << "\n";
//			else
//				cout << -1 << "\n";
//		}
//	}
//}


//year�� �÷����鼭 x�� y�� �����ϳ��� ��������� ã�ƺ���!
int main() {
	int T;
	cin >> T;

	while (T--) {
		int  M, N, x, y;
		cin >> M >> N >> x >> y;

		int lcm = (N * M) / gcd(N, M);

		int year = x;
		bool flag = false;

		while (lcm >= year) {
			int y_ = year % N;
			if (y_ == 0)
				y_ = N;
			if (y_ == y) {
				flag = true;
				break;
			}

			year += M;
		}

		if (flag)
			cout << year << "\n";
		else
			cout << "-1" << "\n";
		
	}
}