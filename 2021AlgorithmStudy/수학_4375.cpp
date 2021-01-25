#include<iostream>
using namespace std;

int main() {
	int n;

	//*** 계속 틀리는 이유 while(!cin.eof()) 로 했는데 마지막에 한번더 숫자가 출력됨`	

	while (cin>>n) {
		int x = 1;

		//틀림;;; 아에 처음 부터 n으로 mod한 값으로 가야하는게 맞을듯
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
				// 위와 같이 하니 tmp가 너무 커져서 시간초과발생
				tmp = (tmp * 10) % n + 1;
				//으로 변경
				x++;
			}
		}

		cout << x << "\n";
	}
}