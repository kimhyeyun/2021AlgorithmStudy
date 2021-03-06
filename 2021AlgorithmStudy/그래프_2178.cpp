#include <iostream>
#include <stdio.h>

#define MAX 101
using namespace std;

int maze[MAX][MAX];
bool visited[MAX][MAX];
int n, m;
int ans = 999999;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};

void DFS(int x, int y, int cnt)
{
    visited[x][y] = true;
    if (x == n - 1 && y == m - 1)
    {
        ans = min(ans, cnt);
        return;
    }

    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < m)
        {
            if (maze[nx][ny] == 1 && !visited[nx][ny])
            {
                visited[nx][ny] = true;
                DFS(nx, ny, cnt + 1);
            }
        }
    }
}

int main()
{
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%1d", &maze[i][j]);
        }
    }

    DFS(0, 0, 1);

    cout << ans << "\n";
}