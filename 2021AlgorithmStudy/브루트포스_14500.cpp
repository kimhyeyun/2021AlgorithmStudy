#include<iostream>
#include<vector>

using namespace std;

#define MAX 501

int dx[] = { 0,0,-1,1 };
int dy[] = { 1,-1,0,0 };

vector<vector<int> > board;
vector<vector<bool>> visited;
int N, M;

//�� ����� �����ϰ�� �ѹ��� 4������ ���� �� �ֱ� ������ 
// ��ĭ���� 4���� ����� ��� ����� ���� ����ؼ� �ִ밪�� ���غ�
// ��� ĭ���� ����ϰ� �ִ밪�� ����
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

// dfs�� �Ұ����� �� ��� ���
int MiddleFinger(int i, int j) {
	int sum = 0;
	//�� ���
	if (i > 0 && j > 0 && j < M - 1)
		sum = max(sum, board[i][j] + board[i - 1][j] + board[i][j - 1] + board[i][j + 1]);
	//�� ���
	if (i < N - 1 && j>0 && j < M - 1)
		sum = max(sum, board[i][j] + board[i + 1][j] + board[i][j - 1] + board[i][j + 1]);
	//�� ���
	if (i > 0 && i < N - 1 && j < M - 1)
		sum = max(sum, board[i][j] + board[i - 1][j] + board[i + 1][j] + board[i][j + 1]);
	//�� ���
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

	////1) 1������ �ִ밪 ���ϱ�
	////1-1) ����
	//for (int i = 0; i < N; i++) {
	//	int sum = 0;
	//	for (int j = 0; j < M; j++) {
	//		sum += board[i][j];
	//	}
	//	int m = min(board[i][0], board[i][M-1]);
	//	sum -= m;
	//	ans = max(sum, ans);
	//}

	////1-2) ����
	//for (int i = 0; i < M; i++) {
	//	int sum = 0;
	//	for (int j = 0; j < N; j++) {
	//		sum += board[j][i];
	//	}
	//	int m = min(board[0][i], board[N - 1][i]);
	//	sum -= m;
	//	ans = max(sum, ans);
	//}

	////2) �׸� �ִ밪 ���ϱ�
	//for (int i = 0; i < N; i++) {
	//	for (int j = 0; j < M; j++) {
	//		int sum = 0;
	//		sum += board[i][j] + board[i][j + 1] + board[i + 1][j] + board[i + 1][j + 1];
	//		ans = max(sum, ans);
	//	}
	//}

	// .... ���� ���� ��� �����ѵ� ���� �ٸ��� ���ϰ�..... �׷��� dfs �̿�����...
}