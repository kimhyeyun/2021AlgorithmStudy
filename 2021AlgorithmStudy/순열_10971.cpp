#include<iostream>
#include<algorithm>
#include<vector>

#define MAX 11
using namespace std;

int N;
int City[MAX][MAX];
bool visited[MAX];
int ans = 9999999;

//start :  이동하는 점, destination : 처음에 출발했고 마지막에 도착할곳
void Solve(int start, int destination, int sum, int cnt) {
	//도시를 전부 방문하고, 출발지에 도착했다면
	if (cnt == N && start == destination) {
		ans = min(ans, sum);	
		return;
	}

	for (int i = 0; i < N; i++) {
		// 갈 수 있고, 방문하지않았다면
		if (City[start][i] != 0 && !visited[i]) {
			visited[i] = true;
			sum += City[start][i];

			Solve(i, destination, sum, cnt + 1);

			visited[i] = false;
			sum -= City[start][i];
				
		}
	}
}

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++)
			cin >> City[i][j];
	}

	for (int i = 0; i < N; i++) {
		Solve(i, i, 0, 0);
	}
	cout<<ans<<"\n";
}


