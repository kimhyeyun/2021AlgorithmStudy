#include <iostream>
#include<string.h>
#include <queue>

#define MAX 301
using namespace std;

int dx[] = {-2, -1, 1, 2};
int dy[][2] = {{-1, 1}, {-2, 2}, {-2, 2}, {-1, 1}};

int chess[MAX][MAX] = {0, };
bool visited[MAX][MAX] = {false,};
int I;

void BFS(int x, int y)
{
    queue<pair<int, int> > q;

    visited[x][y] = true;
    q.push(make_pair(x, y));

    while (!q.empty())
    {
        int tmpx = q.front().first;
        int tmpy = q.front().second;

        q.pop();

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                int nx = tmpx + dx[i];
                int ny = tmpy + dy[i][j];

                if (0 <= nx && nx < I  && 0 <= ny && ny < I)
                {
                    if (chess[nx][ny] == 0 && !visited[nx][ny])
                    {
                        chess[nx][ny] = chess[tmpx][tmpy] + 1;
                        visited[nx][ny] = true;
                        q.push(make_pair(nx, ny));
                    }
                }
            }
        }
    }
}

int main()
{
    int t;
    cin >> t;

    for(int i=0;i<t;i++)
    {
        int  x, y, n, m;
        cin >> I >> x >> y >> n >> m;

        BFS(x,y);

        cout << chess[n][m] << "\n";

        memset(chess,0,sizeof(chess));
        memset(visited,false,sizeof(visited));
    }
}