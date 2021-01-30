#include<iostream>
#include<vector>

using namespace std;

#define MAX 501

int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

vector<vector<int> > board;
vector<vector<bool>> visited;
int N, M;

//ㅗ 모양을 제외하고는 한번에 4번만에 만들 수 있기 때문에 
// 한칸에서 4가지 모양을 모두 만들어 합을 계산해서 최대값을 구해봄
// 모든 칸들을 계산하고 최대값을 구함
int DFS(int x, int y, int cnt) {
	if (cnt > 4)
		return 0 ;
	
	int ans = 0;
	
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (0 <= nx && nx < N && 0 <= ny && ny < M) {
			if (!visited[nx][ny]) {
				visited[nx][ny] = true;
				ans = max(ans, DFS(nx, ny, cnt + 1) + board[x][y]);
				visited[nx][ny] = false;
			}
		}
	}
	return ans;
}

// dfs로 불가능한 ㅗ 모양 계산
int MiddleFinger(int i, int j) {
	int sum = 0;
	//ㅗ 모양
	if (i > 0 && j > 0 && j < M - 1)
		sum = max(sum, board[i][j] + board[i - 1][j] + board[i][j - 1] + board[i][j + 1]);
	//ㅜ 모양
	if (i < N - 1 && j>0 && j < M - 1)
		sum = max(sum, board[i][j] + board[i + 1][j] + board[i][j - 1] + board[i][j + 1]);
	//ㅏ 모양
	if (i > 0 && i < N - 1 && j < M - 1)
		sum = max(sum, board[i][j] + board[i - 1][j] + board[i + 1][j] + board[i][j + 1]);
	//ㅓ 모양
	if (i > 0 && i < N - 1 && j>0)
		sum = max(sum, board[i][j] + board[i - 1][j] + board[i + 1][j] + board[i][j - 1]);

	return sum;
}

int main() {

	cin >> N >> M;

	board = vector<vector<int>>(N, vector<int>(M,0));
	visited = vector<vector<bool>>(N, vector<bool>(M, false));

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}

	int ans = 0;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			visited[i][j] = true;
			ans = max(ans, DFS(i, j, 1));
			ans = max(ans, MiddleFinger(i, j));
			visited[i][j] = false;
		}
	}

	cout << ans << "\n";

	//int ans = 0;

	////1) 1자형의 최대값 구하기
	////1-1) 가로
	//for (int i = 0; i < N; i++) {
	//	int sum = 0;
	//	for (int j = 0; j < M; j++) {
	//		sum += board[i][j];
	//	}
	//	int m = min(board[i][0], board[i][M-1]);
	//	sum -= m;
	//	ans = max(sum, ans);
	//}

	////1-2) 세로
	//for (int i = 0; i < M; i++) {
	//	int sum = 0;
	//	for (int j = 0; j < N; j++) {
	//		sum += board[j][i];
	//	}
	//	int m = min(board[0][i], board[N - 1][i]);
	//	sum -= m;
	//	ans = max(sum, ans);
	//}

	////2) 네모 최대값 구하기
	//for (int i = 0; i < N; i++) {
	//	for (int j = 0; j < M; j++) {
	//		int sum = 0;
	//		sum += board[i][j] + board[i][j + 1] + board[i + 1][j] + board[i + 1][j + 1];
	//		ans = max(sum, ans);
	//	}
	//}

	// .... 여기 까진 어떻게 가능한데 ㄴ과 다른건 못하겠..... 그래서 dfs 이용하자...
}