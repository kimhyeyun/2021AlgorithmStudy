#include<iostream>
#include<string>
#include<math.h>
using namespace std;

int main() {
	string N;
	cin >> N;

	int len = N.length();

	//N이 한 자리 수라면 
	if (len == 1) {
		cout << N << "\n";
	}

	else {
		int ans = 0;
		
		//N의 자릿수 -1 의 길이를 가진 숫자들의 길이만 더해줌
		//ex. N = 120 len = 3 이면
		// 1~99 까지만 계산
		for (int i = 1; i < len; i++) {
			ans += (i * (9 * pow(10, i - 1)));
		}

		//100~120의 길이 계산
		int num = stoi(N);
		int tmp = pow(10, len - 1);

		ans += (len * (num - tmp + 1));

		cout << ans << "\n";
	}

}
