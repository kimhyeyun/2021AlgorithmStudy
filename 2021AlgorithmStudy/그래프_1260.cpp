#include <iostream>
#include <vector>
#include <queue>

#define MAX 1001
using namespace std;

int n, m, v;
int R[MAX][MAX];
bool visited[MAX];

void DFS(int idx)
{
    cout << idx << " ";
    visited[idx] = true;

    for (int i = 1; i <= n; i++)
    {
        if (!visited[i] && R[idx][i] == 1)
            DFS(i);
    }
    return;
}

void BFS(int idx)
{
    queue<int> q;

    visited[idx] = false;
    q.push(idx);

    while (!q.empty())
    {
        int x = q.front();
        cout << x << " ";
        q.pop();

        for (int i = 1; i <= n; i++)
        {
            if (visited[i] && R[x][i] == 1)
            {
                q.push(i);
                visited[i] = false;
            }
        }
    }
}

int main()
{
    cin >> n >> m >> v;

    for (int i = 0; i < m; i++)
    {
        int x, y;
        cin >> x >> y;
        R[x][y] = 1;
        R[y][x] = 1;
    }

    DFS(v);
    cout << "\n";

    BFS(v);
    cout << "\n";
}