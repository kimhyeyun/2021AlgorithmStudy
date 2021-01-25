#include<iostream>
#include<vector>

//outofbounds 런타임 에러가 계속 뜸 
//원인 : MAX값을 제대로 정하지 못함 글 잘읽자...
#define MAX 1000000

using namespace std;

//17427과 같은 방식으로 하니 역시나 시간초과 발생
// 입력받고 구하고 출력하는 방식보다는 미리 MAX까지 구해놓고 출력하는 것이 더 빠름
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