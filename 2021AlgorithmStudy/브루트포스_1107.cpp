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
	//N : ���ϴ� ä�� , M:���峭 ��ư�� ���� , x : ���峭 ��ư, �� : ����

	cin >> N >> M;
	
	while (M--) {
		cin >> x;
		broken[x] = true;
	}

	//������ +, - �θ� �̵��ϴ� ���
	int ans = abs(N - now);

	//�̵� ������ ä���� 0~500,000 ������ �ִ� 2*N ���� -�� �̵��ϴ� �͵� ����
	for (int i = 0; i <= MAX; i++) {
		if (Ispossible(i)) {
			int tmp = abs(N - i) + to_string(i).length();
			ans = min(ans, tmp);
		}
	}

	cout << ans << "\n";


}