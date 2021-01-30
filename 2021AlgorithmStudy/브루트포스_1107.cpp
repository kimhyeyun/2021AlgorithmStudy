#include<iostream>
#include<string>
#include<vector>
using namespace std;

#define MAX 1000000

vector<bool> broken(10, false);

bool Ispossible(int num) {
	string n_st = to_string(num);
	for (int i = 0; i < n_st.length(); i++) {
		if (broken[n_st[i] - '0'])
			return false;
	}
	return true;
}


int main() {
	int now = 100;
	int N, M, x;
	int l;
	//N : 원하는 채널 , M:고장난 버튼의 갯수 , x : 고장난 버튼, ㅣ : 길이

	cin >> N >> M;
	
	while (M--) {
		cin >> x;
		broken[x] = true;
	}

	//오로지 +, - 로만 이동하는 경우
	int ans = abs(N - now);

	//이동 가능한 채널은 0~500,000 이지만 최대 2*N 부터 -로 이동하는 것도 가능
	for (int i = 0; i <= MAX; i++) {
		if (Ispossible(i)) {
			int tmp = abs(N - i) + to_string(i).length();
			ans = min(ans, tmp);
		}
	}

	cout << ans << "\n";


}