#include<iostream>
using namespace std;

//처음에는 gcd를 재귀형식으로 구현을 했었는데 segmentation falut 에러가 발생 -> 함수가 스택에 계속 쌓이면서 메모리 초과
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