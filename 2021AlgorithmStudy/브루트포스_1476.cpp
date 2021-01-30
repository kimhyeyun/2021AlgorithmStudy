#include<iostream>
using namespace std;

// 비효율적이지만 브루트 포스 알고리즘을 이용하여 풀이하는 
// 문제이므로 년도를 증가하면서 15, 28, 19의 공통 배수 찾기

int main() {
	int E, S, M;
	
	cin >> E >> S >> M;

	int year = 1;

	while (1) {
		if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0)
			break;
		year++;
	}

	cout << year << "\n";
}