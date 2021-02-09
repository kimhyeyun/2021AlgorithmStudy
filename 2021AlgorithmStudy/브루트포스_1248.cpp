#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

#define MAX 10
char S[MAX][MAX];
int NUM[MAX];
int N;

bool Check(int idx) {
	int sum = 0;

	for (int i = idx; i >= 0; i--) {
		sum += NUM[i];
		if (S[i][idx] == '+' && sum <= 0)
			return false;
		if (S[i][idx] == '-' && sum >= 0)
			return false;
		if (S[i][idx] == '0' && sum != 0)
			return false;
	}
	return true;
	}

void DFS(int count) {
	if (count == N) {
		for (int i = 0; i < N; i++)
			cout << NUM[i] << " ";
		cout << "\n";

		exit(0);
	}

	for (int i = -10; i <= 10; i++) {
		NUM[count] = i;
			if (Check(count))
			DFS(count + 1);
	}
}

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = i; j < N; j++)
			cin >> S[i][j];
	}

	DFS(0);


}