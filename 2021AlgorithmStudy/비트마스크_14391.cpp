	#include<iostream>
	using namespace std;

	int N, M, ans;
	int Rectangle[4][4];
	bool visited[4][4] = { false, };

	void Solve(int n, int sum) {
		int x = n / M;
		int y = n % M;

		if (n >= N * M) {
			ans = max(ans, sum);
			return;
		}

		if (visited[x][y])
			Solve(n + 1, sum);

		else {
			int tmp, nx, ny;
			tmp = Rectangle[x][y];
			visited[x][y] = true;
			Solve(n + 1, sum + tmp);
			visited[x][y] = false;

			//밑으로
			for (int i = 1; i < N - x; i++) {
				nx = x + i;
				tmp *= 10;
				tmp += Rectangle[nx][y];

				for (int j = 1; j <= i; j++)
					visited[x + j][y] = true;

				Solve(n + 1, sum + tmp);

				for (int j = 1; j <= i; j++)
					visited[x + j][y] = false;
			}

			tmp = Rectangle[x][y];

			//오른쪽으로
			for (int i = 1; i < M - y; i++) {
				ny = y + i;
				if (visited[x][ny])
					return;
				tmp *= 10;
				tmp += Rectangle[x][ny];

				for (int j = 1; j <= i; j++)
					visited[x][y + j] = true;

				Solve(n + 1, sum + tmp);

				for (int j = 1; j <= i; j++)
					visited[x][y + j] = false;
			}

		}
	}

	int main() {
		string s;
		cin >> N >> M;

		for (int i = 0; i < N; i++) {
			cin >> s;
			for (int j = 0; j < M; j++)
				Rectangle[i][j] = s[j] - '0';
		}

		Solve(0, 0);

		cout << ans << "\n"; 
	}