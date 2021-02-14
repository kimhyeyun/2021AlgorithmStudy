#include<iostream>
#include<algorithm>
#include<vector>

#define MAX 11
using namespace std;

int N;
int City[MAX][MAX];
bool visited[MAX];
int ans = 9999999;

//start :  �̵��ϴ� ��, destination : ó���� ����߰� �������� �����Ұ�
void Solve(int start, int destination, int sum, int cnt) {
	//���ø� ���� �湮�ϰ�, ������� �����ߴٸ�
	if (cnt == N && start == destination) {
		ans = min(ans, sum);	
		return;
	}

	for (int i = 0; i < N; i++) {
		// �� �� �ְ�, �湮�����ʾҴٸ�
		if (City[start][i] != 0 && !visited[i]) {
			visited[i] = true;
			sum += City[start][i];

			Solve(i, destination, sum, cnt + 1);

			visited[i] = false;
			sum -= City[start][i];
				
		}
	}
}

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++)
			cin >> City[i][j];
	}

	for (int i = 0; i < N; i++) {
		Solve(i, i, 0, 0);
	}
	cout<<ans<<"\n";
}


