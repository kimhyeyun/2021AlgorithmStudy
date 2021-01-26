#include<iostream>
using namespace std;

//처음부터 마지막까지 모든 경우의 수로 좌우위아래로 교환하고 
//한줄씩 가로 세로로 동일한 갯수를 세고 맥스 구하기

char board[51][51];
int N;
int ans = 0;

void check() {
	for (int i = 0; i < N; i++) {
		int cnt = 1;
		for (int j = 1; j < N; j++) {
			if (board[i][j] == board[i][j - 1])
				cnt++;
			else {
				ans = max(cnt, ans);
				cnt = 1;
			}
		}
		ans = max(ans, cnt);
	}

	for (int i = 0; i < N; i++) {
		int cnt = 1;
		for (int j = 1; j < N; j++) {
			if (board[j - 1][i] == board[j][i])
				cnt++;
			else {
				ans = max(ans, cnt);
				cnt = 1;
			}
		}
		ans = max(ans, cnt);
	}
}

void solve() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N - 1; j++) {
			//1. 가로로 옆과 교환
			char tmp = board[i][j];
			board[i][j] = board[i][j + 1];
			board[i][j + 1] = tmp;
			check();

			//원상복귀
			board[i][j + 1] = board[i][j];
			board[i][j] = tmp;

			//2. 세로로 옆과 교환
			tmp = board[j][i];
			board[j][i] = board[j + 1][i];
			board[j + 1][i] = tmp;
			check();

			//원상복귀
			board[j + 1][i] = board[j][i];
			board[j][i] = tmp;
		}
	}
}


int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++)
			cin >> board[i][j];
	}

	solve();

	cout << ans << "\n";
}