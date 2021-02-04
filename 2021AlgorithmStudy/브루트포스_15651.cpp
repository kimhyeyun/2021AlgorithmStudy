#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

#define MAX 9

int N, M;
bool visited[MAX];
int num[MAX];

void DFS(int idx, int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			cout << num[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = 1; i <= N; i++) {
		num[cnt] = i;
		DFS(i, cnt + 1);
	}
}

int main() {
	cin >> N >> M;

	DFS(0, 0);
}
