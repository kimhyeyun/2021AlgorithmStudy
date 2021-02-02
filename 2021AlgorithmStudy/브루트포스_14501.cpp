#include<iostream>
#include<vector>
using namespace std;

int N;
vector<int> j_time;
vector<int> j_pay;

int m_pay = 0;

void Solve(int idx_t, int sum, int add){
	if (idx_t == N + 1) {
		m_pay = max(m_pay, sum);
		return;
	}
	
	else if (idx_t > N + 1) {
		m_pay = max(m_pay, sum - add);
		return;
	}

	for (int i = idx_t + j_time[idx_t]; i <= N + j_time[idx_t]; i++)
		Solve(i, sum + j_pay[idx_t], j_pay[idx_t]);

}

int main() {
	cin >> N;

	j_time.push_back(0);
	j_pay.push_back(0);

	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;

		j_time.push_back(x);
		j_pay.push_back(y);
	}


	for (int i = 1; i <= N; i++)
		Solve(i, 0, j_pay[i]);

	cout << m_pay << "\n";
}