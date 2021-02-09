#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

#define MAX 10000

int N, M;
vector<int> n;
bool visited[MAX];
int num[MAX];

void DFS(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			cout << num[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = 0; i < N; i++) {
		int x = n[i];
		num[cnt] = x;
		DFS(cnt + 1);
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int x;
		cin >> x;
		n.push_back(x);
	}

	sort(n.begin(), n.end());

	DFS(0);
}
