#include <iostream>
#include <queue>

#define MAX 1001
using namespace std;

int tomato[MAX][MAX];
int day[MAX][MAX];
int n, m;
int dx[] = {-1, 0, 0, 1};
int dy[] = {0, -1, 1, 0};

queue<pair<int, int> > q;

int main()
{
    cin >> m >> n;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            cin >> tomato[i][j];
            if (tomato[i][j] == 1)
            {
                q.push(make_pair(i, j));
                day[i][j] = 1;
            }
            if (tomato[i][j] == -1)
                day[i][j] = 1;
        }
    }

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
                if (tomato[nx][ny] == 0 && (day[nx][ny] == 0 || day[nx][ny] > day[tmpx][tmpy] + 1))
                {
                    day[nx][ny] = day[tmpx][tmpy] + 1;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }

    int max = 0;
    bool flag = false;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (day[i][j] > max)
                max = day[i][j];
            if (day[i][j] == 0)
                flag = true;
        }
    }

    if (flag)
        cout << -1 << "\n";
    else
        cout << max - 1 << "\n";
}