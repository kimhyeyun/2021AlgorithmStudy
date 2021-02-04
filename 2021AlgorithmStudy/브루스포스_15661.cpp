#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

#define MAX 20

int N;
int S[MAX][MAX];
bool visited[MAX];
int ans = 9999999999;

int Cal(vector<int> tmp) {
	int sum = 0;

	for (int i = 0; i < tmp.size(); i++) {
		for (int j = 0; j < tmp.size(); j++) {
			if (i == j)
				continue;
			
			sum += S[tmp[i]][tmp[j]];
		}
	}
	return sum;
}

void DFS(int idx, int cnt) {
	if (cnt == N / 2) {
		//능력치 계싼
		vector<int> start, link;

		for (int i = 0; i < N; i++) {
			if (visited[i])
				start.push_back(i);
			else
				link.push_back(i);
		}

		int s = Cal(start);
		int l = Cal(link);

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

//start team 과 link team으로 나눠야함
int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++)
			cin >> S[i][j];
	}

	DFS(0, 0);

	cout << ans << "\n";

}