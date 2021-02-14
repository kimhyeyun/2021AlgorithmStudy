#include<iostream>
#include<vector>
#include<algorithm>

#define MAX 13
using namespace std;

int S[MAX];
int k;
bool visited[MAX];
int result[MAX];

void Solve(int idx, int cnt) {
	if (cnt == 6) {
		for (int i = 0; i < cnt; i++)
			cout << result[i] << " ";
		cout << "\n";
		return;
	}

	for (int i = idx; i < k; i++) {
		if (!visited[i]) {
			result[cnt] = S[i];
			visited[i] = true;
			Solve(i, cnt + 1);
			visited[i] = false;
		}
	}
}

int main() {

	while (cin >> k && k) {          
		for (int i = 0; i < k; i++) {
			cin >> S[i];
		}

		Solve(0,0);
		cout << "\n";
	}
}