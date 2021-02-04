#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

#define MAX 21

int N;
int S[MAX][MAX];
bool visited[MAX];
int ans = 9999999999;

void DFS(int idx, int cnt) {
	if (cnt == N / 2) {
		//�ɷ�ġ ���
		vector<int> start, link;

		for (int i = 0; i < N; i++) {
			if (visited[i])
				start.push_back(i);
			else
				link.push_back(i);
		}

		int s = 0, l = 0;

		for (int i = 0; i < start.size(); i++) {
			for (int j = i + 1; j < start.size(); j++) {
				s += (S[start[i]][start[j]] + S[start[j]][start[i]]);
				l += (S[link[i]][link[j]] + S[link[j]][link[i]]);
			}
		}

		ans = min(ans, abs(s - l));
		return;
	}

	for (int i = idx; i < N; i++) {
		if (!visited[i]) {
			visited[i] = true;
			DFS(i, cnt + 1);
			visited[i] = false;
		}
	}
}

//start team �� link team���� ��������
int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++)
			cin >> S[i][j];
	}

	DFS(0, 0);

	cout << ans << "\n";

}