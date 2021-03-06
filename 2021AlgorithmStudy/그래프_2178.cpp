#include <iostream>
#include <stdio.h>
#include <queue>

#define MAX 101
using namespace std;

int maze[MAX][MAX];
bool visited[MAX][MAX]; //dfs용
int day[MAX][MAX];
int n, m;
int ans = 999999; //dfs용
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};

// void DFS(int x, int y, int cnt)
// {
//     visited[x][y] = true;
//     if (x == n - 1 && y == m - 1)
//     {
//         ans = min(ans, cnt);
//         return;
//     }

//     for (int i = 0; i < 4; i++)
//     {
//         int nx = x + dx[i];
//         int ny = y + dy[i];

//         if (nx >= 0 && nx < n && ny >= 0 && ny < m)
//         {
//             if (maze[nx][ny] == 1 && !visited[nx][ny])
//             {
//                 visited[nx][ny] = true;
//                 DFS(nx, ny, cnt + 1);
//             }
//         }
//     }
// }

//최단 경로는 bfs로 구해야함
void BFS(int x, int y)
{
    queue<pair<int, int> > q;
    q.push(make_pair(x, y));
    day[x][y] = 1;

    while (!q.empty())
    {
        int tmpx = q.front().first;
        int tmpy = q.front().second;

        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = tmpx + dx[i];
            int ny = tmpy + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m)
            {
                if (maze[nx][ny] == 1 && day[nx][ny] == 0)
                {
                    day[nx][ny] = day[tmpx][tmpy] + 1;
                    q.push(make_pair(nx, ny));
                }
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

    //DFS(0, 0, 1);
    BFS(0, 0);

    cout << day[n - 1][m - 1] << "\n";
}